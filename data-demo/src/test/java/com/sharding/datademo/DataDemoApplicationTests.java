package com.sharding.datademo;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sharding.datademo.domain.Comment;
import com.sharding.datademo.mapper.CommentMapper;
import com.sharding.datademo.remote.CommentRemote;
import com.sharding.datademo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@EnableScheduling
@Slf4j
class DataDemoApplicationTests {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private CommentRemote commentRemote;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String BATCH_KEY = "insert:batch";

    private final static String LOU = "find";

    @Test
    public void getIdList() {
        log.info("id size is {}", redisTemplate.opsForList().size(LOU));
    }

    @Test
    public void select() {
        for (int i = 1002789; i <= 22473422; i++) {
            try {
                commentRemote.isExist(i);
            } catch (Exception e) {
                continue;
            }
        }
        log.info("遗漏的id个数为 {}", redisTemplate.opsForList().size(LOU));

        while (redisTemplate.opsForList().size(LOU) > 0) {
            Integer pop = (Integer) redisTemplate.opsForList().rightPop(LOU);
            Comment byId = commentService.getById(pop);
            try {
                if (Objects.nonNull(byId)) {
                    commentRemote.insert(byId);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    @Test
    public void insert(){
        for (int i = 18180000; i <= 19000000; i++) {
            try {
                Comment byId = commentService.getById(i);
                if (Objects.nonNull(byId)) {
                    commentRemote.insert(byId);
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    private static Executor executor = new ThreadPoolExecutor(5,
            20,
            200,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10));

    @Test
    public void getListFromRedis() {
        log.info("size is {}", redisTemplate.opsForList().size(BATCH_KEY));
        while (redisTemplate.opsForList().size(BATCH_KEY) > 0) {
            String pop = (String) redisTemplate.opsForList().rightPop(BATCH_KEY);
            List<Comment> list = JSON.parseObject(pop, List.class);
            try {
                commentRemote.insertCommentBatch(list);
            } catch (Exception e) {
                continue;
            }
        }
    }

    @Test
    public void getRedisSize() {
        log.info("size is {}", redisTemplate.opsForList().size(BATCH_KEY));
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void insertData() {
        long timeMillis = System.currentTimeMillis();
        log.info("开始插入数据，当前时间为 {}", LocalDateTime.now().toString());
        System.out.println(LocalDateTime.now());
        for (int i = 0; i < 20000000; ) {
            List<Comment> list = Lists.newArrayList();
            for (int j = i; j < i + 10000; j++) {
                Comment comment = new Comment();
                comment.setCommentTime(LocalDateTime.now());
                comment.setContent(RandomUtil.randomString(50));
                comment.setNoticeId(RandomUtil.randomInt(25000));
                comment.setParentId(0);
                comment.setUserId(RandomUtil.randomInt(3500000));
                list.add(comment);
            }
            commentService.saveBatch(list);
            i += 10000;
        }
        System.out.println("插入完成，时间 ：" + String.valueOf(System.currentTimeMillis() - timeMillis) + "ms");
        log.info("完成 {}ms", System.currentTimeMillis() - timeMillis);
    }

    public static void main(String[] args) {
        LocalDateTime parse = LocalDateTime.parse("2020-09-28T11:50:23.662");
        LocalDateTime now = LocalDateTime.parse("2020-09-28T14:27:16.944");
        Duration duration = Duration.between(parse, now);
        System.out.println("批量插入两千万条数据，消耗时间 " + duration.toMinutes() + "分");
    }

    @Test
    public void insetInMultiThread() {
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> insertData());
        }
    }

    @Test
    public void selectOne() {
        Comment comment = commentService.getById(123);
        System.out.println(comment.toString());
    }

    @Test
    public void getAndInsert() {
        LocalDateTime start = LocalDateTime.now();
        log.info("开始进行数据库迁移 ... 时间 {}", start);
        int maxId = 22473422;
        int max = 14000000;
        ArrayList<Integer> list = Lists.newArrayList();
        for (int i = 13950000; i <= max; i++) {
            list.add(i);
            if (list.size() % 15000 == 0 || i == maxId) {
                List<Comment> comments = commentService.selectBatchByIds(list);
                try {
                    commentRemote.insertCommentBatch(comments);
                    list = Lists.newArrayList();
                } catch (Exception e) {
                    list = Lists.newArrayList();
                    continue;
                }
            }
        }
        LocalDateTime now = LocalDateTime.now();
        log.info("迁移结束，时间为 {}", now);
        Duration between = Duration.between(start, now);
        log.info("花费时间 {} 分", between.toMinutes());
    }

    @Test
    public void getListFromRedisInsert() {
        log.info("size is {}", redisTemplate.opsForList().size(BATCH_KEY));
        while (redisTemplate.opsForList().size(BATCH_KEY) > 0) {
            String pop = (String) redisTemplate.opsForList().rightPop(BATCH_KEY);
            List<Comment> list = JSON.parseObject(pop, List.class);
            try {
                list.parallelStream().forEach(comment -> {
                    commentRemote.insert(comment);
                });
            } catch (Exception e) {
                continue;
            }
        }
    }

    @Test
    public void getId() {
//        Boolean exist = commentRemote.isExist(123);
        Comment byId = commentService.getById(14000000);
        commentRemote.insert(byId);
//        log.info("the result is {}", exist);
    }


    public int count(int start, int end) {
        LambdaQueryWrapper<Comment> commentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        commentLambdaQueryWrapper.le(Comment::getId, end)
                .gt(Comment::getId, start);
        List<Comment> comments = commentMapper.selectList(commentLambdaQueryWrapper);
        log.info("======> {} - {}区间 总数为 {}", start, end, comments.size());
        return comments.size();
    }

    @Test
    public void countBatch() {
        for (int i = 21; i <= 23; i++) {
            int start = (i - 1) * 1000000;
            int end = i * 1000000;
//            executor.execute(() -> count(start, end));
            int count = count(start, end);
            log.info("{} - {}区间 总数为 {}", start, end, count);
        }
    }
}

package com.db.sharingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.db.sharingjdbcdemo.domain.Comment;
import com.db.sharingjdbcdemo.mapper.CommentMapper;
import com.db.sharingjdbcdemo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SharingJdbcDemoApplicationTests {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private final static String LOU = "find";

    @Test
    public void contextLoads() {

    }

    @Test
    public void select() {
        log.info(commentService.getById(123).toString());
//        for (int i = 1; i <= 22473422; i++) {
//            Comment byId = commentService.getById(i);
//            if (Objects.isNull(byId)) {
//                redisTemplate.opsForList().leftPush(LOU, i);
//            }
//        }

    }

    public int count(int start, int end) {
        LambdaQueryWrapper<Comment> commentLambdaQueryWrapper = new LambdaQueryWrapper<>();
        commentLambdaQueryWrapper.le(Comment::getId, end)
                .gt(Comment::getId, start);
        List<Comment> comments = commentMapper.selectList(commentLambdaQueryWrapper);
        log.info("{} - {}区间 总数为 {}", start, end, comments.size());
        return comments.size();
    }

    @Test
    public void countBatch() {
        for (int i = 21; i <= 23; i++) {
            int start = (i - 1) * 1000000;
            int end = i * 1000000;
            int count = count(start, end);
            log.info("{} - {}区间 总数为 {}", start, end, count);
        }
    }

    @Test
    public void count() {
            int start = 19000000;
            int end = 19500000;
            int count = count(start, end);
            log.info("{} - {}区间 总数为 {}", start, end, count);
    }
}

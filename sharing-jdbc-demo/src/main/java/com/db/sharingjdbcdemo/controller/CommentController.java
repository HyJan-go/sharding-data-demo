package com.db.sharingjdbcdemo.controller;

import com.alibaba.fastjson.JSON;
import com.db.sharingjdbcdemo.domain.Comment;
import com.db.sharingjdbcdemo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @description: 评论控制类
 * @author: HyJan
 * @create: 2020-09-28 16:34
 **/
@RequestMapping("/comment")
@RestController
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String BATCH_KEY = "insert:batch";
    private static final String INSERT_KEY = "insert";
    private final static String LOU = "find";

    /**
     * 批量插入评论
     *
     * @param comments
     * @return
     */
    @PostMapping("/insert/batch")
    public String insertCommentBatch(@RequestBody List<Comment> comments) {
        log.info("receive the request !!!! request is {}",comments.size());
        try {
            boolean batch = commentService.saveBatch(comments);
            if (batch) {
                return "success";
            }
            redisTemplate.opsForList().leftPush(BATCH_KEY, JSON.toJSONString(comments));
            return "failure";
        } catch (Exception e) {
            log.error("批量插入发生错误 {}", e);
            // 放到一个队列中
            Long push = redisTemplate.opsForList().leftPush(BATCH_KEY, JSON.toJSONString(comments));
            log.info("错误数据已插入redis中....");
            return "failure";
        }
    }

    /**
     * 单量插入
     *
     * @param comment
     * @return
     */
    @PostMapping("/insert")
    public String insert(@RequestBody Comment comment) {
        log.info("receive the request !!!! data is {}", JSON.toJSONString(comment));
        try {
            boolean insert = commentService.saveOrUpdate(comment);
            if (insert) {
                return "success";
            }
            redisTemplate.opsForList().leftPush(INSERT_KEY, JSON.toJSONString(comment));
            return "failure";
        } catch (Exception e) {
            log.error("单条插入发生错误 {}", e);
            redisTemplate.opsForList().leftPush(INSERT_KEY, JSON.toJSONString(comment));
            log.info("存入redis完成...");
            return "failure";
        }
    }

    @PostMapping("/select")
    public Boolean isExist(@RequestBody Integer id){
        try {
            Comment byId = commentService.getById(id);
            log.info("查询结果为 {}", byId.toString());
            if (Objects.isNull(byId)){
                redisTemplate.opsForList().leftPush(LOU, id);
                return false;
            }
            return true;
        }catch (Exception e){
            redisTemplate.opsForList().leftPush(LOU, id);
            log.info("发生异常 ", e);
            return false;
        }
    }
}

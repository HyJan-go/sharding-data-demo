package com.sharding.datademo.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: HyJan
 * @create: 2020-09-29 13:44
 **/
@Component
@Slf4j
public class RedisScheduled {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String BATCH_KEY = "insert:batch";

    private static final String INSERT_KEY = "insert";

    /**
     * 每10秒执行一次
     */
//    @Scheduled(cron = "0/10 * * * * ?")
    @Scheduled(fixedDelay = 10000)
    public void getRedisSize(){
        log.info("-----------> batch size is {}",redisTemplate.opsForList().size(BATCH_KEY));
        log.info("=============> insert size is {}", redisTemplate.opsForList().size(INSERT_KEY));
//        System.out.println("batch size is " + redisTemplate.opsForList().size(BATCH_KEY));
    }

}

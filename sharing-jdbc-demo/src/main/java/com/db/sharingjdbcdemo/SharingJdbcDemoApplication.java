package com.db.sharingjdbcdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 雪花算法的缺陷：如果时间不连续进行访问，很容易出现全是单数，或者全是双数的这种会造成数据都在一个表中
 * 高并发场景才适用雪花算法
 *
 * 缺陷：感觉数据加密并没有配错，但是数据脱敏并没有成功，当然，这个也可以通过业务层手动进行加密，看选择。
 *
 * 数据库分片的时候，不适用与携带下划线的情况，特别是"name_1,name_2"这种，否则配置之后会出错
 *
 * mp 的一个坑，数据库是Date，实例类用LocalDateTime会报错
 */
@MapperScan(basePackages = {"com.db.sharingjdbcdemo.mapper"})
@EnableDiscoveryClient
@SpringBootApplication
public class SharingJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharingJdbcDemoApplication.class, args);
    }

}

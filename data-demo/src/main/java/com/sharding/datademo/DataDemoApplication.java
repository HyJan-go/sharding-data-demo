package com.sharding.datademo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableDiscoveryClient
@MapperScan("com.sharding.datademo.mapper")
@ComponentScan("com.sharding.datademo.*")
public class DataDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataDemoApplication.class, args);
    }
}

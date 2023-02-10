package com.cevier.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cevier.sharding.mapper")
public class ShardingJdbcLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcLearningApplication.class, args);
    }

}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class MybatisPlusOracleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusOracleApplication.class, args);
    }
}

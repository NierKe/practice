package com.dk.demo1.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")//读取配置文件
@ConfigurationProperties(prefix="student")//读取节点
@Data
public class StudentConfig {
    private String name;
    private String sex;
    private int age;

}

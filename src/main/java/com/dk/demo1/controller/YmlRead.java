package com.dk.demo1.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix="pk-group.pk-org.pk-dept")
@Data
public class YmlRead {
    String user_id;
}

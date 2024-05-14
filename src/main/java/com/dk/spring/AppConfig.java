package com.dk.spring;

import com.dk.spring.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.security.auth.login.CredentialNotFoundException;

//定义扫描路径
@ComponentScan("com.dk.spring")
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public OrderService orderService1(){
        return new OrderService();
    }

    @Bean
    public OrderService orderService2(){
        return new OrderService();
    }
}

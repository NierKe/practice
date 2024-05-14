package com.dk.spring.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService implements InitializingBean {
    @Autowired
    OrderService orderService;

//    public UserService() {
//        System.out.println("无参构造");
//    }

    public UserService(OrderService orderService2) { //先byType - > byName
        this.orderService = orderService2;
        System.out.println("有参构造");
    }

    @PostConstruct
    public void a(){
        System.out.println("spring 自动调用");
    }

    public void test(){
        System.out.println(orderService);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("spring 实现 InitializingBean 接口 实现自动调用方法");
    }
}

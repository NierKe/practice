package com.dk.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DkAspect {
    @Before("execution(public void com.dk.spring.service.UserService.test())")
    public void dkBefore(JoinPoint joinPoint){
        System.out.println("dkBefore");
       // C:\Users\78212\IdeaProjects\demo1\src\main\java\com\dk\spring\service\UserService.java
    }
}

package com.dk.ioc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class CalAspect {
    @Before("execution(public int com.dk.ioc.CalImpl.*(..))")
    public void before (JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "参数是"+ Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(value = "execution(public int com.dk.ioc.CalImpl.*(..))",returning = "result")
    public void afterReturning (JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "的方法结果是："+ result);

    }
}

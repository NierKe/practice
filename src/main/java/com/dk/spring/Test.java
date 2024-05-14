package com.dk.spring;

import com.dk.spring.service.OrderService;
import com.dk.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;

public class Test {

    public static void main(String[] args) {

        //UserService.class -->推断构造方法 --> 构造注入 --> 普通对象 --> 依赖注入 --> 初始化（调用afterPropertiesSet()） --> 初始化后(AOP) --> 代理对象 --> Map 单例池
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //bean对象
        UserService userService = (UserService)applicationContext.getBean("userService");//Map<beanName,bean对象>
        UserService userService1 = (UserService)applicationContext.getBean("userService");
        UserService userService2 = (UserService)applicationContext.getBean("userService");
        userService.test();

//        //代理类
//        class UserServiceProxy extends UserService{
//            UserService target;
//
//
//            public  void test(){
//                //切面逻辑
//                target.test();
//            }
//        }





        //放到Map池里的对象叫做bean对象
        Object o = new Object();
        applicationContext.getBeanFactory().registerSingleton("xxx",o);

        System.out.println(applicationContext.getBean("orderService"));
        System.out.println(applicationContext.getBean("orderService1"));
        System.out.println(applicationContext.getBean("orderService2"));

        //普通对象
//        UserService userService1 = new UserService();
//        userService1.test();




//        UserService bean = new UserService();
//        //依赖注入
//        for (Field field : bean.getClass().getDeclaredFields()){
//            if (field.isAnnotationPresent(Autowired.class)){
//                field.set(bean,??);
//            }
//        }
    }

}

package com.dk.ioc;

import com.dk.equals.StudentVO;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class AopTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Cal bean = context.getBean(Cal.class);
        System.out.println(bean.Add(6,5));
        System.out.println(bean.div(6,5));
        System.out.println(bean.mul(6,5));
        System.out.println(bean.sub(6,5));
        System.out.println(3*0.1);
        System.out.println(StudentVO.num);
    }
}

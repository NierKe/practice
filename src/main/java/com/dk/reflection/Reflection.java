package com.dk.reflection;

import com.dk.demo1.pojo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException {

        Class<User> aClass = User.class;
        User user = aClass.newInstance();
        user.setId(123123L);
        System.out.println(user);

        Constructor<?> []declaredConstructor =  User.class.getDeclaredConstructors();
        System.out.println(declaredConstructor.length);
        Object user1 = declaredConstructor[0].newInstance();
       // Object user2 = declaredConstructor[1].newInstance();
        System.out.println(declaredConstructor.length);
        System.out.println(user1);

        //
        User user2 = new User();
        user2.setPassword("ssss");
        User clone = user2.clone();

        System.out.println(clone);
    }

}

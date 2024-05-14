package com.dk.reflection;

import org.apache.commons.lang3.SerializationUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Reflect {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException {
        People people = People.class.newInstance();
        Field sys = People.class.getDeclaredField("sys");
        sys.setAccessible(true);
        System.out.println(sys.get(people));

//        People p = new People();
//        Field sys = p.getClass().getDeclaredField("sys");
//        sys.setAccessible(true);
//        System.out.println(sys.get(p));
//
        Class<?> aClass = Class.forName("com.dk.reflection.People");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        People o = (People) declaredConstructors[1].newInstance("董科",29, "男","213123123");
        System.out.println(o);

    //序列化创建对象
        People p2 = new People("董科2",29, "男","213123123");
        byte[] serialize = SerializationUtils.serialize(p2);
        People deserialize = (People) SerializationUtils.deserialize(serialize);

        System.out.println(deserialize);
        System.out.println(deserialize == p2);

    }
}

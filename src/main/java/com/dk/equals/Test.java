package com.dk.equals;

import java.util.Objects;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {

        StudentVO zhangsan = new StudentVO();
        Father father = new Father("zhangsanbaba","male",30);
        zhangsan.setSex("male");
        zhangsan.setAge(11);
        zhangsan.setName("zhangsan");
        zhangsan.setFather(null);
        StudentVO lici = new StudentVO(1,13,"famale",zhangsan,new Father("李四爸爸","male",31),"lisi") ;

        String zhangsanFatherName = "";
//        StudentVO stuZhangSan = lici.getClassMate();
//        if(stuZhangSan != null){
//            Father faZhangsan = stuZhangSan.getFather();
//            if(faZhangsan != null){
//                zhangsanFatherName = faZhangsan.getName();
//            }
//
//        }
        String s = Optional.ofNullable(lici.getClassMate())
                .map(StudentVO::getFather)
                .map(Father::getName).orElse("没找到");
        System.out.println(s);


    }
}

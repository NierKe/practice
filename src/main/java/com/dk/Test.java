package com.dk;

import org.thymeleaf.util.StringUtils;

public class Test {
    public static void main(String[] args) {
        String code ="车位管理费&dsda&";
        int i1 = code.lastIndexOf("&");
        int i2 = code.indexOf("&");
        if(!StringUtils.isEmpty(code) && code.contains("&") && code.lastIndexOf("&") != code.indexOf("&")){
            int i = code.lastIndexOf("&");
            int m = code.indexOf("&") + 1;
            String substring = code.substring(m, i);
            System.out.println(substring);
        }

    }
}

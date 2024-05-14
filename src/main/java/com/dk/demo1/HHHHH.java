package com.dk.demo1;

public class HHHHH {
    public static void main(String[] args) {
        String str = "&AADAD&你好";
        String str2 = str.substring(str.indexOf("&")+1,str.lastIndexOf("&"));
        System.out.println(str2);
    }
}

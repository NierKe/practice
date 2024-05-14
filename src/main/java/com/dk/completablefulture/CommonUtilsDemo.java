package com.dk.completablefulture;

public class CommonUtilsDemo {
    public static void main(String[] args) {
        String readFile = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\new.txt");
        CommonUtils.printThreadLog(readFile);
    }
}

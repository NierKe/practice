package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo3 {
    public static void main(String[] args) {
        CommonUtils.printThreadLog("main start");
        CompletableFuture.runAsync(()->{
            CommonUtils.printThreadLog("读取文件");
            String s = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\new.txt");
            System.out.println(s);
        });
        CommonUtils.printThreadLog("here is not blocked,main continue ");
        CommonUtils.sleepSecond(4);
        CommonUtils.printThreadLog("main end");
    }
}

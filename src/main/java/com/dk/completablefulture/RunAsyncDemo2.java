package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo2 {
    public static void main(String[] args) {
        CommonUtils.printThreadLog("main start");
        CompletableFuture.runAsync(()->{
            CommonUtils.printThreadLog("读取文件开始");
            CommonUtils.sleepSecond(3);
            CommonUtils.printThreadLog("读取文件结束");
        });
        CommonUtils.printThreadLog("here is not blocked,main continue ");
        CommonUtils.sleepSecond(4);
        CommonUtils.printThreadLog("main end");
    }
}

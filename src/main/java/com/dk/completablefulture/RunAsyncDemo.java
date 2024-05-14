package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;

public class RunAsyncDemo {
    public static void main(String[] args) {
        //runAsync 创建异步任务
        CommonUtils.printThreadLog("main start");
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                CommonUtils.printThreadLog("读取文件开始");
                CommonUtils.sleepSecond(3);
                CommonUtils.printThreadLog("读取文件结束");
            }
        });
        CommonUtils.printThreadLog("here is not blocked,main continue ");
        CommonUtils.sleepSecond(1);
        CommonUtils.printThreadLog("main end");
        //CompletableFuture 中的异步任务底层开启一个线程
    }
}

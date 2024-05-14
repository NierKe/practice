package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenComposeDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CommonUtils.printThreadLog("main start");
        CompletableFuture<String[]> filterWordsFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件内容");
            String content = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\filter_world.txt");
            return content;
        }).thenComposeAsync(content -> CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("将文件内容替换为敏感词数组");
            String[] split = content.split(",");
            return split;
        },executorService));
        CommonUtils.printThreadLog("main continue");
        filterWordsFuture.get();
        CommonUtils.printThreadLog("main end");
        executorService.shutdown();
    }

}

package com.dk.completablefulture;

import java.util.Arrays;
import java.util.concurrent.*;

public class ThenApplyDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CommonUtils.printThreadLog("mian start");
        CompletableFuture<String[]> filterWordsFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件内容");
            String content = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\filter_world.txt");
            return content;
        }).thenApplyAsync(content -> {
            CommonUtils.printThreadLog("替换文件内容为敏感词数组");
            String[] filterWords = content.split(",");
            return filterWords;
        },executorService);
        CommonUtils.printThreadLog("main continue");
        String[] filterWorlds = filterWordsFuture.get();
        CommonUtils.printThreadLog("filterwords :"+ Arrays.toString(filterWorlds));
        CommonUtils.printThreadLog("main end");
        executorService.shutdown();
    }
}

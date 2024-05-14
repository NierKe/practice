package com.dk.completablefulture;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApplyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main start");
        CompletableFuture<String> readFileFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取文件内容");
            String content = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\filter_world.txt");
            return content;
        });
        CompletableFuture<String[]> filterWorldFuture = readFileFuture.thenApply(content -> {
            CommonUtils.printThreadLog("文件转换成敏感词数组");
            String[] filterWords = content.split(",");
            return filterWords;
        });
        CommonUtils.printThreadLog("main continue");
        String[] filterWorlds = filterWorldFuture.get();
        CommonUtils.printThreadLog("filterwords :"+ Arrays.toString(filterWorlds));
        CommonUtils.printThreadLog("main end");
    }
}

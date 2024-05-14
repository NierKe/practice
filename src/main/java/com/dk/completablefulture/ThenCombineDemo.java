package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenCombineDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main strat");
        //读取敏感词
        CompletableFuture<String[]> future1 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取filer_words 文件内容");
            String content = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\filter_world.txt");
            return content.split(",");
        });
        //读取新闻
        CompletableFuture<String> fulure2 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取news文件内容");
            String content = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\new.txt");
            return content;
        });
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<String> combineFuture = future1.thenCombineAsync(fulure2, (filterWords, news) -> {
            CommonUtils.printThreadLog("替换操作");
            for (String word : filterWords) {
                if (news.indexOf(word) > 0) {
                    news = news.replace(word, "*");
                }
            }
            return news;
        },executorService);

        CommonUtils.printThreadLog("main continue");
        String news = combineFuture.get();
        CommonUtils.printThreadLog(news);
        CommonUtils.printThreadLog("main end");
    }
}

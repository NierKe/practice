package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class SupplyAsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CommonUtils.printThreadLog("main start");
        CompletableFuture<String> newFuture = CompletableFuture.supplyAsync(() ->{
            String content = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\new.txt");
            return content;
        },executorService);
        CommonUtils.printThreadLog("here not block! main continue");
        String news = newFuture.get();
        System.out.println(news);
        CommonUtils.printThreadLog("main end");
        executorService.shutdown();
    }
}

package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practise {
    public static String step1()  {
        try {
            //int i = 1 / 0;
            Thread.sleep(3000);
            String name = Thread.currentThread().getName();
            System.out.println(name+": 步骤1");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "步骤1完成";
    }
    public static String step2()  {
        try {
            Thread.sleep(3000);
            String name = Thread.currentThread().getName();
            System.out.println(name+": 步骤2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "步骤2完成";
    }
    public static String step3() {
        try {
            Thread.sleep(3000);
            String name = Thread.currentThread().getName();
            System.out.println(name+": 步骤3");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "步骤3完成";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(Practise::step1,executorService).exceptionally(ex->{
            return "出现异常返回默认值：0XX";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(Practise::step2,executorService).exceptionally(ex->{
            return "出现异常返回默认值：0XX";
        });
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(Practise::step3,executorService).exceptionally(ex->{
            return "出现异常返回默认值：0XX";
        });
//        CompletableFuture<String> stringCompletableFuture = future2.thenCombine(future3, (tx1, tx2) -> {
//            return tx1 + tx2;
//        });
//        String s = stringCompletableFuture.get();
//        CompletableFuture<String> stringCompletableFuture = future2.thenCompose(s -> CompletableFuture.supplyAsync(() -> {
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return s + ": 哈哈哈哈";
//                })
//        );
//        String s = stringCompletableFuture.get();
//        System.out.println(s);

        CompletableFuture<String> stringCompletableFuture = future1.thenCombine(future2, (a, b) -> {
            return a + b;
        });
        String s = stringCompletableFuture.get();
        System.out.println(s);

        String name = Thread.currentThread().getName();
        System.out.println(name);
        long end = System.currentTimeMillis();
        System.out.println("耗时："+ (end-start) / 1000 + "秒");
    }
}

package com.dk.completablefulture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AllOfDemo {
    //有多个需要独立并运行的Future，并在所有这些Future都完成后执行一些操作
    public static CompletableFuture<String> readFileFuture(String fileName  ){
        return CompletableFuture.supplyAsync(()->{
            return CommonUtils.readFile(fileName);
        });
    };
    public static void main(String[] args) {
        //创建list集合
        List<String> fileList = Arrays.asList("D:\\work\\practice\\demo1-master\\src\\new.txt",
                "D:\\work\\practice\\demo1-master\\src\\new.txt","D:\\work\\practice\\demo1-master\\src\\new3.txt");
        List<CompletableFuture<String>> readFileFutureList = fileList.stream().map(fileName -> {
            return readFileFuture(fileName);
        }).collect(Collectors.toList());

        //把list转为数组待用，以便传入allof方法中
        int len = readFileFutureList.size();
        CompletableFuture[] readFileFutureArr = readFileFutureList.toArray(new CompletableFuture[len]);
        //使用allOf方法合并多个异步任务
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(readFileFutureArr);
        //多个异步任务完成后，使用回调操作文件结果，统计符合条件文件个数
        CompletableFuture<Long> countFuture = allOfFuture.thenApply(v -> {
            return readFileFutureList.stream().map(future -> future.join())
                    .filter(content -> content.contains("TMD"))
                    .count();
        });
        //主线程打印文件个数
        Long count = countFuture.join();
        System.out.println("count = " +count);
    }
}

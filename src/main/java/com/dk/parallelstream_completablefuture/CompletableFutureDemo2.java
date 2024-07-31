package com.dk.parallelstream_completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureDemo2 {
    public static void main(String[] args) {
        //创建10个Mystak队形，每个对象存入list
        IntStream intStream = IntStream.range(0, 20);
        List<MyTask> tasks = intStream.mapToObj(item -> {
            return new MyTask(1);
        }).collect(Collectors.toList());

        //主备线程池
        int N_CPU = Runtime.getRuntime().availableProcessors();
        //设置线程池线程数量最小为20
        ExecutorService executor = Executors.newFixedThreadPool(Math.min(tasks.size(), N_CPU * 2));

        //构建10个异步任务
        List<CompletableFuture<Integer>> futures = tasks.stream().map(task -> {
            return CompletableFuture.supplyAsync(() -> {
                return task.doWork();
            },executor);
        }).collect(Collectors.toList());
        long start = System.currentTimeMillis();
        //执行异步任务
        List<Integer> results = futures.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        double costTime = (end-start)/1000.0;
        System.out.printf("processed %d task %.2f second",tasks.size(),costTime);
        executor.shutdown();
    }


}
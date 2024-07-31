package com.dk.parallelstream_completablefuture;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SequenceDemo {
    public static void main(String[] args) {
        //并行流局限性
        //需求：创建10个MyTask耗时任务，统计他们的总耗时
        //方案一  在主线程中使用串行执行
        //创建10个MYtask任务，每个任务执行1s，存入list集合
        IntStream intStream = IntStream.range(0,10);
        List<MyTask> tasks = intStream.mapToObj(item -> {
            return new MyTask(1);
        }).collect(Collectors.toList());
        long start = System.currentTimeMillis();
        //执行10个task，统计总耗时
        List<Integer> results = tasks.stream().map(myTask -> {
            return myTask.doWork();
        }).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        double costTime = (end-start)/1000.0;
        System.out.printf("processed %d task %.2f second",tasks.size(),costTime);

    }
}

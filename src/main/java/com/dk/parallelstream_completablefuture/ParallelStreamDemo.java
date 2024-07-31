package com.dk.parallelstream_completablefuture;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0,20);
        List<MyTask> tasks = intStream.mapToObj(item -> {
            return new MyTask(1);
        }).collect(Collectors.toList());
        long start = System.currentTimeMillis();
        //执行10个task，统计总耗时
        List<Integer> results = tasks.parallelStream().map(myTask -> {
            return myTask.doWork();
        }).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        double costTime = (end-start)/1000.0;
        System.out.printf("processed %d task %.2f second",tasks.size(),costTime);
    }
}

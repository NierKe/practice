package com.dk.completablefulture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //1.step 读取敏感词汇-》thread1
        Future<String[]> filterWordsFuture = executor.submit(() -> {
            String str = CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\filter_world.txt");
            String[] filterWords = str.split(",");
            return filterWords;
        });
        //2.step读取新闻稿->thread2
        Future<String> newsFuture = executor.submit(() -> {
            return CommonUtils.readFile("D:\\work\\practice\\demo1-master\\src\\new.txt");
        });
        //3.step替换->thread3
        Future<String> replaceFuture = executor.submit(() -> {
            String[] words = filterWordsFuture.get();
            String news = newsFuture.get();
            for (String word : words) {
                if (news.indexOf(word) >= 0) {
                    news = news.replace(word, "*");
                }
            }
            return news;
        });
        //4.step打印替换后=》main
        String filterednews = replaceFuture.get();
        System.out.println("filterednews:"+filterednews);

    }
}

package com.dk.completablefulture;

import ch.qos.logback.core.util.TimeUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonUtils {
    public static  String readFile(String path){
        try {
            StringBuffer sb = new StringBuffer();
            Stream<String> lines = Files.lines(Paths.get(path));
            lines.flatMap(x->{
                List<Character> s = new ArrayList<>();
                char[] chars = x.toCharArray();
                for (Character c : chars){
                    s.add(c);
                }
                return s.stream();
            }).forEach(x->{
                sb.append(x);
            });
            return sb.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public static void sleepMillis(long millis){
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleepSecond(long second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void printThreadLog(String msg){
       String result =  new StringJoiner("|").add(String.valueOf(System.currentTimeMillis()))
                .add(String.format("%2d",Thread.currentThread().getId()))
                .add(Thread.currentThread().getName())
                .add(msg)
               .toString();
        System.out.println(result);
    }
}

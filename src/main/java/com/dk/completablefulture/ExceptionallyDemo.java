package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyDemo {
    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            int r = 1 / 0;
            return "result1";
        }).thenApply(result -> {
            CommonUtils.printThreadLog(result);
            String str = null;
            int length = str.length();
            return result + " result2";
        }).thenApply(result -> {
            return result + " result3";
        }).exceptionally(ex ->{
            String message = ex.getMessage();
            System.out.println("message = " + message);
            return "Unknown";
        });

    }

}

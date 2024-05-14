package com.dk.completablefulture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HandleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            // handle()
            CommonUtils.printThreadLog("main start");
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                int r = 1 / 0;
                return "result1";
            }).handle((result,ex)->{
                CommonUtils.printThreadLog("上一步异常的恢复");
                if(ex != null){
                    CommonUtils.printThreadLog("出现异常：" + ex.getMessage());
                    return "UnKnown";
                }
                return result;
            });

            CommonUtils.printThreadLog("main continue");
            String ret = future.get();
            CommonUtils.printThreadLog("ret = " + ret);

            CommonUtils.printThreadLog("main end");

        }

}

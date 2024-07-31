package com.dk.parallelstream_completablefuture;

import com.dk.completablefulture.CommonUtils;

public class MyTask {
    private int duration;
    public MyTask(int duration){
        this.duration = duration;
    }
    //模拟耗时长任务
    public int doWork(){
        CommonUtils.printThreadLog("doWork");
        CommonUtils.sleepSecond(duration);
        return duration;
    }
}

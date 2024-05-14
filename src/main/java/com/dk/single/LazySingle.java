package com.dk.single;

public class LazySingle {
    private LazySingle(){}

    private volatile static LazySingle single = null;

    public static LazySingle getInstance(){
        if(single == null){
            synchronized (LazySingle.class){
                if (single == null){
                    return new LazySingle();
                }
            }

        }
        return single;
    }



}

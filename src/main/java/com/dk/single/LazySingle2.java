package com.dk.single;

public class LazySingle2 {
    private LazySingle2(){};
    private volatile static LazySingle2 instance;

    public static LazySingle2 getInstance(){
        if(instance == null){
            synchronized (LazySingle2.class){
                if(instance == null){
                    return instance;
                }
            }
        }
        return instance;
    };
}

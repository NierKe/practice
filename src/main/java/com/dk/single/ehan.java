package com.dk.single;

public class ehan {
    private ehan(){};
    private static ehan instance = new ehan();
    public static ehan getInstance(){
        return instance;
    }
}

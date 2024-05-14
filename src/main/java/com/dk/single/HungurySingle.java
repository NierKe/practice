package com.dk.single;

public class HungurySingle {
    private HungurySingle(){}
    private static HungurySingle instance = new HungurySingle();

    public static  HungurySingle getInstance(){
        return  instance;
    }

}

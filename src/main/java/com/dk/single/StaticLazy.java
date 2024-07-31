package com.dk.single;

public class StaticLazy {
private StaticLazy(){};

private static class  StaticLazyHander{
    private static StaticLazy instance = new StaticLazy();
}

public static StaticLazy getInstance(){
    return  StaticLazyHander.instance;
}
}

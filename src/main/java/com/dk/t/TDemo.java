package com.dk.t;

public class TDemo<T> {
    private T t;
    public T getValue() {
        return t;
    }
    public void setValue(T t) {
        this.t = t;
    }


    public <T extends Comparable> T getCompare(T t1, T t2){
        if(t1.compareTo(t2) > 0){
            return t1;
        }
        return t2;
    }
}

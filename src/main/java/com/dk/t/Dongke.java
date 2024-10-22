package com.dk.t;

public class Dongke<T> {
    public T getT() {
        return t;
    }

    public Dongke() {
    }

    public Dongke(T t) {
        this.t = t;
    }

    public void setT(T t) {
        this.t = t;
    }

    private T t;

}

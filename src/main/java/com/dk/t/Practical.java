package com.dk.t;

import java.util.ArrayList;

/**
 * @author 78212
 */
public class Practical<T>{
    ArrayList<T> list;
    public Practical() {
        list = new ArrayList<>();
    }
    public void add(T t) {
        list.add(t);
    }
    public T getFirst() {
       return list.get(0);
    }



    public void printEmployee(Practical<? extends Employee> p) {
        p.getFirst();
    }

}

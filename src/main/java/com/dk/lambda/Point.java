package com.dk.lambda;

import java.util.Arrays;
import java.util.List;

public class Point {
    private int x;
    private int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(11, 2, 3, 5);
        //integers.stream().map(Point::new).forEach(System.out::println);
    }
}

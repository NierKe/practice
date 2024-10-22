package com.dk.hanshu;

import java.util.function.Function;

public class FunctionPractise {
    public static void main(String[] args) {
        Function<Integer,String> function = i -> i + "hello";
        String result = function.apply(1);
        System.out.println(result);

    }
}

package com.dk.lambda;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class List {

    public static int square(int num){
        return num * num;
    }
    public static void main(String[] args) {
       // java.util.List<String> strings = Arrays.asList("AA", "BB", "DD");
        //strings.forEach(name -> System.out.println(name));
        //strings.forEach(System.out::println);


        java.util.List<Integer> integers = Arrays.asList(1, 2, 5);
       // integers.stream().map(List::square).forEach(System.out::println);
       // integers.stream().forEach(System.out::println);

        java.util.List l = new CopyOnWriteArrayList<>(Arrays.asList("one", "two"));
        Stream sl = l.stream();
        sl.forEach(s -> l.add("three"));
    }
}

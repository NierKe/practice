package com.dk.steam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Practise {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三","李四","王五","赵六","董科","王天宇","王子长","张岳强","杨金刚","刘贞宜");
        Stream<String> stream = list.stream();
        stream.filter((String name) -> {return name.startsWith("王");});

    }
}

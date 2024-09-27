package com.dk;

import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//        Integer reduce = Stream.of(1, 2, 3, 4)
//                .reduce(1, (n1, n2) -> {
//                    int ret = n1 + n2;
//                    System.out.println(n1 + "(n1)+" + n2 + "(n2)=" + ret);
//                    return ret;
//                });
//        System.out.println(reduce);
        List<Integer> nums = Stream.iterate(0, n -> n + 1)
                .limit(100).collect(Collectors.toList());
        List<List<Integer>> collect = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .parallel()
                .map(x -> {
                    System.out.println(Thread.currentThread().getName());
                    return nums.stream().skip(x * 10).limit(10).collect(Collectors.toList());
                }).collect(Collectors.toList());

         System.out.println(collect);
    }
}

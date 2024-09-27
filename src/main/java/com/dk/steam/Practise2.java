package com.dk.steam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practise2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("ssss", "sssss", "s");
        List<String> collect = strings.stream().map(s -> "update bd_defdoc set def19 = '' where pk_defdoc = '"+s+"'").collect(Collectors.toList());
        System.out.println(collect);
        printNumbers(1);
        printNumbers(1,2);
    }

    public static void printNumbers(int... numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

}

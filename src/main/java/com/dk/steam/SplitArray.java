package com.dk.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitArray {
    public static void main(String[] args) {
        int maxNum = 200;
        List<Integer> numList = new ArrayList<>();
        for(int i=0;i<401;i++){
            numList.add(i);
        }
        int step = (numList.size() + maxNum - 1) / maxNum;
        List<List<Integer>> collect = Stream.iterate(0, n -> n + 1)
                .limit(step)
                .parallel()
                .map(a -> numList.stream()
                        .skip(a * maxNum)
                        .limit(maxNum)
                        .parallel()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}

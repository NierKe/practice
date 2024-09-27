package com.dk.steam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practise {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三","李四","王五","赵六","董科","王天宇","王子长","张岳强","杨金刚","刘贞宜");
        Stream<String> stream = list.stream();
        List<String> newList = stream.filter(x -> x.startsWith("王")).collect(Collectors.toList());
        System.out.println(newList);

        Map<String,String> map1 = new HashMap<>();
        Map<String,String> map2 = new HashMap<>();
        Map<String,String> map3 = new HashMap<>();
        map1.put("DK","ss");
        map2.put("DK","ss2");
        map3.put("DK","ss3");
        List<Map<String, String>> maps = Arrays.asList(map1, map2, map3);
        Map<String, Map<String, String>> dk = maps.stream().collect(Collectors.toMap(a -> a.get("DK"), a -> a, (a1, b1) -> a1));
        System.out.println(dk);
    }
}

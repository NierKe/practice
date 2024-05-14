package com.dk.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest
{
    public static void main(String[] args) {
//        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
     //  IntStream.range(1, 3).forEach(System.out::println);
        //IntStream.rangeClosed(1, 6).forEach(System.out::println);


//        Stream<String> stream3 = Stream.of(new String[]{"1", "2", "3", "4", "6", "7", "8", "9"});
//        List<String> collect = stream3.filter(x -> Integer.parseInt(x) > 3).collect(Collectors.toList());
//        System.out.println(collect);
//        stream3.forEach(System.out::println);
//        List<String> list = Arrays.asList("aaa", "bbb", "ddd", "eee", "ccc");
//       list.stream().flatMap(x -> {
//            List<Character> characterList = new ArrayList<>();
//            char[] chars = x.toCharArray();
//            for (char c : chars) {
//                characterList.add(c);
//            }
//            return characterList.stream();
//        }).forEach(System.out::print);
//      //  System.out.println(collect);


//        Stream<Integer> stream3 = Stream.of(3,5,1,4,2,6,8,7);
//        List<Integer> integerList = stream3.limit(3).collect(Collectors.toList());
//        System.out.println(integerList);
//        Stream<Integer> stream3 = Stream.of(4, 5, 2, 6, 9, 0, 1, 3, 6, 8);
//        List<Integer> integerList = stream3.sorted((x, y) -> x - y).collect(Collectors.toList());
//        System.out.println(integerList);
        class Item {
            public Item(int value) {
                this.value = value;
            }
            private int value;
            public int getValue() {
                return value;
            }
            public void setValue(int value) {
                this.value = value;
            }
        }

        Stream<Item> stream3 = Stream.of(new Item(4), new Item(3), new Item(6), new Item(9));
        List<Item> itemList = stream3.sorted(Comparator.comparingInt(Item::getValue)).collect(Collectors.toList());
        itemList.forEach(x -> System.out.print(x.getValue()+","));



    }
}

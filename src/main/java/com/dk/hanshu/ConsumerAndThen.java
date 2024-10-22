package com.dk.hanshu;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerAndThen {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Consumer<List<Integer>> printList = list2 ->{
          for(int i =0;i<list2.size();i++){
              list2.set(i,list2.get(i) * list2.get(i));
          }
        };
        Consumer<List<Integer>> printList2 = list2 -> list2.forEach(System.out::println);
        printList.andThen(printList2).accept(list);

        Supplier<String> stringSupplier = () -> "hello";

        //Predicate

    }
}

package com.dk.hanshu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractise {

    public static void main(String[] args) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        Consumer<Integer> storeNumber = n ->{
            if(n % 2 == 0){
                oddList.add(n);
            }else {
                evenList.add(n);
            }
        };

        Consumer<List<Integer>> printList = list -> list.forEach(System.out::println);
        storeNumber.accept(1);
        storeNumber.accept(2);
        storeNumber.accept(3);
        storeNumber.accept(4);
        System.out.println("oddList");
        printList.accept(oddList);
        System.out.println("evenList");
        printList.accept(evenList);


    }
}

package com.dk.t;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static double getSum(List<? extends Number> list){
        double sum = 0;
        for (Number n : list){
            sum += n.doubleValue();
        }
        return sum;
    }
    public static void main(String[] args) {
        Dongke<String> dongke = new Dongke();
        dongke.setT("董科");
        System.out.println(dongke.getT());

        Dongke<Integer> dongke2 = new Dongke(29);
        System.out.println(dongke2.getT());
        Practical<Manager> manager = new Practical<>();
        Practical<Employee> employee = new Practical<>();

        Practical<? super Employee> p = new Practical<>();
        p.add(new Manager());
        List list = new ArrayList();
    }
}

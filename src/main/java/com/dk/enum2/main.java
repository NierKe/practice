package com.dk.enum2;

public class main {
    public static void main(String[] args) {
        Cal cal = Cal.getCal("8");
        assert cal != null;
        double calculate = cal.calculate(1, 2);
        System.out.println(calculate);

    }
}

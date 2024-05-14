package com.dk.lambda;
interface ITest{
    void hh(int a);
}
public class Lambda {
    public static void main(String[] args) {
        ITest test = (a)->{
            System.out.println("lambda测试->"+a);
        };
        test = b->{
            System.out.println("lambda测试->"+b);
        };
        test = b-> System.out.println("lambda测试->"+b);


        test.hh(2000);
    }
}

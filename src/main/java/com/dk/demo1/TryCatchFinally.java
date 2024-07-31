package com.dk.demo1;

public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(extracted());
    }

    private static int extracted() {
        try{
            System.out.println("start");
            try {
                int num = 1 /0 ;
                return 1;
            }catch (Exception e){
                return 2;
            }finally {
                return 3;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            return 4;
        }
    }
}

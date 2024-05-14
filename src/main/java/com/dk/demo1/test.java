package com.dk.demo1;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
public class test {

    HashMap<String,String> map = new HashMap<String,String> ();
    Hashtable tt = new Hashtable();

    ConcurrentHashMap sd = new ConcurrentHashMap();

    //Runtime.getRuntime().availableProcessors();

    StringBuffer svb = new StringBuffer();
    ThreadPoolTaskExecutor s = new ThreadPoolTaskExecutor();

    public static int soutAA(){
        int a = 0;
        try{

            int b = 1/a;
            return a;

        }catch (RuntimeException e){
            a = 3;
            return a;
        }finally {
            a = a +1;
            return a;
        }
    }

    public static  int test() {
        int i = 0;
        try {
            i++;
            i = i / 0;
            return i++;
        } catch (Exception e) {
            i++;
            return i++;
        } finally {
            return ++i;
        }
    }
    public static void  test2(){
        int i = 0;
        i=i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String> ();
        map.put("123","231");
        map.put("123","aaa");

       // System.out.println(test());
      //  test2();


       byte aa = 21;
        char bb = (char) aa;

        System.out.println(bb);
    }

}

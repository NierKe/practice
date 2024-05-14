package com.dk.thread;

public class ThreadStoptTest implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run...thread"+i++);
        }
    }
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStoptTest t1 = new ThreadStoptTest();
        new Thread(t1).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if (i == 900){
                t1.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}

package com.dk.thread;

public class Race implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(winner != null){
                break;
            }
            if(!isStop(i)){
                System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
                if(Thread.currentThread().getName().equals("兔子") && i % 20 == 0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public boolean isStop(int metre){
        if(winner != null){
            return true;
        }else {
            if(metre == 100){
                winner = Thread.currentThread().getName();
                System.out.println("冠军是"+Thread.currentThread().getName());
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Race t1 = new Race();
        new Thread(t1,"乌龟").start();
        new Thread(t1,"兔子").start();
    }
}

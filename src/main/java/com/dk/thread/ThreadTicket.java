package com.dk.thread;

public class ThreadTicket implements Runnable{

    private int ticketNums = 10;
    @Override
    public synchronized void run() {
        while(true){
            if (ticketNums <= 0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"票");

        }

    }

    public static void main(String[] args) {
        ThreadTicket threadTicket = new ThreadTicket();
        new Thread(threadTicket,"小明").start();
        new Thread(threadTicket,"老师").start();
        new Thread(threadTicket,"黄牛党").start();


    }
}

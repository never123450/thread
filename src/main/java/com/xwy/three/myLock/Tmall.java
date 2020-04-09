package com.xwy.three.myLock;

public class Tmall {

    private int count;

    public final int MAX_COUNT = 10;


    public synchronized void push() {
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存不足");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "生产者生产");
        notifyAll();
    }

    public synchronized void take() {
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存不足");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "消费者消费");
        notifyAll();
    }


}
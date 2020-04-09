package com.xwy.three.myLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tmall2 {

    private int count;

    public final int MAX_COUNT = 10;

    private Lock lock = new ReentrantLock();
    Condition p = lock.newCondition();
    Condition t = lock.newCondition();



    public  void push() {
        lock.lock();
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存不足");
                p.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + "生产者生产");
        t.signal();
        lock.unlock();
    }

    public  void take() {
        lock.lock();
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存不足");
                t.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "消费者消费");
        p.signal();
        lock.unlock();
    }


}
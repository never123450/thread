package com.xwy.one.wangwenjun.three.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: AtomicInteger 保证可见性，有序性，原子性
 * @author: xwy
 * @create: 7:25 PM 2020/5/28
 **/

public class AtomicIntegerTest {

    /**
     * volatile
     * 1.可见性
     * 2.内存屏障，保证顺序性
     * 不保证原子性
     */
//    private static volatile int value = 0;
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = run();
//        Thread t2 = run();
//        Thread t3 = run();
//        t1.start();
//        t2.start();
//        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();

//        AtomicInteger value = new AtomicInteger();
//        Thread t1 = run(value);
//        Thread t2 = run(value);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();

        AtomicInteger i = new AtomicInteger(10);
        boolean flag = i.compareAndSet(12,20);
        System.out.println(i.get());
        System.out.println(flag);

    }

//    private static Thread run() {
//        return
//                new Thread(() -> {
//                    int x = 0;
//                    while (x < 50) {
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        int tmp = value;
//                        System.out.println(Thread.currentThread().getName() + " : " + tmp);
//                        value += 1;
//                        x++;
//                    }
//                });
//    }


    private static Thread run(AtomicInteger value) {
        return
                new Thread(() -> {
                    int x = 0;
                    while (x < 50) {
                        int v = value.getAndIncrement();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " : " + v);
                        x++;
                    }
                });
    }

}
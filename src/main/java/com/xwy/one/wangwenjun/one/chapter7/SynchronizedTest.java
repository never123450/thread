package com.xwy.one.wangwenjun.one.chapter7;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:04 PM 2020/5/12
**/

public class SynchronizedTest {

    private final static Object LOCK = new Object();

    public static void main(String[] args) {

        Runnable runnable = () -> {
            synchronized (LOCK) {
                try {
                    Thread.sleep(2_000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();

    }
}

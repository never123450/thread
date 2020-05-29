package com.xwy.one.wangwenjun.one.chapter10;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:14 PM 2020/5/13
**/

public class SynchronizedProblem {

    public static void main(String[] args) throws InterruptedException {

        new Thread() {
            @Override
            public void run() {
                SynchronizedProblem.run();
            }
        }.start();

        Thread.sleep(1000);

        Thread t2 = new Thread() {
            @Override
            public void run() {
//                /sdfsdfsd
                SynchronizedProblem.run();
                //sdfsdfsd
            }
        };
        t2.start();
        Thread.sleep(2000);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
    }

    private synchronized static void run() {
        System.out.println(Thread.currentThread());
        while (true) {

        }
    }
}

package com.xwy.one.wangwenjun.three.utils.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 9:34 PM 2020/6/2
**/

public class CountDownLatchExample2 {

    public static void main(String[] args) throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        new Thread(){
            @Override
            public void run() {
                System.out.println("Do some initial working.");
                try {
                    Thread.sleep(1000);
                    latch.await();
                    System.out.println("DO other working...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("asyn prepate for some data...");
                try {
                    Thread.sleep(1000);
                    System.out.println("data prepare for done...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    latch.countDown();
                }
            }
        }.start();

        Thread.currentThread().join();

    }
}
package com.xwy.one.wangwenjun.three.utils.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: xwy
 * @create: 7:47 PM 2020/6/4
 **/

public class SemaphoreExample2 {

    /**
     * connection pool
     * when get the not available connection/policy
     * 1.get 1000ms then throw exception
     * 2.blocking
     * 3.discard
     * 4.get then throw exception
     * 5.get -> register the callback,-> call you
     *
     * @param args
     */
    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " in");
                try {
                    semaphore.acquire(2);
                    System.out.println(Thread.currentThread().getName() + " get the semaphore");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(1);
                }

                System.out.println(Thread.currentThread().getName() + " out");

            }).start();
        }

        while (true) {
            System.out.println("AP-> " + semaphore.availablePermits());
            System.out.println("QL-> " + semaphore.getQueueLength());
            System.out.println("------------------------------------");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
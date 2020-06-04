package com.xwy.one.wangwenjun.three.utils.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 8:06 PM 2020/6/4
**/

public class SemaphoreExample3 {

    public static void main(String[] args) {

        final Semaphore semaphore = new Semaphore(2);

        Thread t1 = new Thread(()->{
            try {
                semaphore.acquire();
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
            System.out.println("T1 finished");
        });

        t1.start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(()->{
            try {
                semaphore.acquireUninterruptibly();
//                semaphore.acquire();
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaphore.release();
            }
            System.out.println("T2 finished");
        });

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();

    }
}
package com.xwy.three.myLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public void method(Semaphore semaphore) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "is running...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();
    }

    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();

//        Semaphore semaphore = new Semaphore(5);
//        while (true) {
//            new Thread(() -> {
//                semaphoreTest.method(semaphore);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }).start();
//        }

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        while (true) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 执行完毕");
            });
        }
    }

}
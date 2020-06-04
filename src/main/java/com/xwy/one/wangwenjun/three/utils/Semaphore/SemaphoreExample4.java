package com.xwy.one.wangwenjun.three.utils.Semaphore;

import java.util.Collection;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: xwy
 * @create: 8:20 PM 2020/6/4
 **/

public class SemaphoreExample4 {

    public static void main(String[] args) throws InterruptedException {
        final MySemaphore semaphore = new MySemaphore(5);

        Thread t1 = new Thread(() -> {
            try {
                semaphore.drainPermits();
                System.out.println("availablePermits: " + semaphore.availablePermits());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(5);
            }
            System.out.println("T1 finished");
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                boolean success = semaphore.tryAcquire();
                System.out.println(success ? "successful" : "failed");
            } finally {
                semaphore.release();
            }
            System.out.println("T2 finished");
        });

        t2.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("hasQueuedThreads: " + semaphore.hasQueuedThreads());

        Collection<Thread> waittingThreads = semaphore.getWaitingThreads();
        for (Thread t : waittingThreads) {
            System.out.println(t);
        }
    }

    static class MySemaphore extends Semaphore {

        public MySemaphore(int permits) {
            super(permits);
        }

        public MySemaphore(int permits, boolean fair) {
            super(permits, fair);

            super.getQueuedThreads();
        }

        public Collection<Thread> getWaitingThreads() {
            return super.getQueuedThreads();
        }
    }
}
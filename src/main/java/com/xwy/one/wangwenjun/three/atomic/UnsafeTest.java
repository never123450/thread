package com.xwy.one.wangwenjun.three.atomic;

import sun.misc.Unsafe;
import sun.rmi.runtime.Log;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: xwy
 * @create: 8:31 PM 2020/5/31
 **/

public class UnsafeTest {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException {
//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe);
//        Unsafe unsafe = getUnsafe();
//        System.out.println(unsafe);

        ExecutorService service = Executors.newFixedThreadPool(1000);
        Counter counter = new CasCounter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            service.submit(new CounterRunnable(counter, 10000));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("counter result:" + counter.getCounter());
        System.out.println("time passed in ms:" + (end - start));


    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    interface Counter {
        void increment();

        long getCounter();
    }

    /**
     * counter result:9971042
     * time passed in ms:202
     */
    static class StupiedCounter implements Counter {


        private long counter = 0;

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }

    }


    /**
     * counter result:10000000
     * time passed in ms:638
     */
    static class SyncCounter implements Counter {


        private long counter = 0;

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }

    }

    /**
     * counter result:10000000
     * time passed in ms:797
     */
    static class LockCounter implements Counter {


        private final Lock lock = new ReentrantLock();

        private long counter = 0;

        @Override
        public synchronized void increment() {
            try {
                lock.lock();
                counter++;
            } finally {
                lock.unlock();
            }

        }

        @Override
        public long getCounter() {
            return counter;
        }

    }


    /**
     * counter result:10000000
     * time passed in ms:579
     */
    static class AtomicCounter implements Counter {

        private AtomicLong counter = new AtomicLong();


        @Override
        public synchronized void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }

    }

    /**
     * counter result:10000000
     * time passed in ms:644
     */
    static class CasCounter implements Counter {

        private volatile long counter = 0;
        private Unsafe unsafe;
        private long offset;

        CasCounter() throws NoSuchFieldException {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
        }


        @Override
        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this, offset, current, current + 1)) {
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }


    static class CounterRunnable implements Runnable {

        private final Counter counter;
        private final int num;

        public CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }


        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

}
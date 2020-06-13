package com.xwy.one.wangwenjun.three.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: xwy
 * @create: 9:14 PM 2020/6/8
 **/

public class ReadWriteLockExample {
    private final static ReentrantLock LOCK = new ReentrantLock(true);

    private final static List<Long> data = new ArrayList<>();

    private final static ReentrantReadWriteLock REENTRANT_READ_WRITE_LOCK = new ReentrantReadWriteLock(true);

    private final static Lock readLock = REENTRANT_READ_WRITE_LOCK.readLock();

    private final static Lock writeLock = REENTRANT_READ_WRITE_LOCK.writeLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            read();
        }).start();

        TimeUnit.SECONDS.sleep(2);

        Thread thread = new Thread(ReadWriteLockExample::read);
        thread.start();
    }

    public static void write() {
        try {
            writeLock.lock();
            data.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void read() {
        try {
            readLock.lock();
            data.forEach(System.out::println);
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + "-------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}
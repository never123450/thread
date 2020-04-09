package com.xwy.three.myLock;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock r = rwl.readLock();

    private Lock w = rwl.writeLock();

    public Object get(String key) {
        r.lock();
        System.out.println(Thread.currentThread().getName() + "读操作在执行。。。");

        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        } finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName() + "读操执行完毕。。。");

        }
    }


    public void put(String key, Object value) {
        w.lock();
        System.out.println(Thread.currentThread().getName() + "写操作在执行。。。");
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        } finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName() + "写操作执行完毕。。。");
        }
    }


}
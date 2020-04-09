package com.xwy.three.myLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/**
 *
 * @description: 自定义锁
 *
 * @author: xwy
 *
 * @create: 5:29 PM 2019/9/22
**/

public class MyLock implements Lock {

    private boolean isLocked = false;

    Thread lockBy = null;//当前上锁的线程

    private int lockCount = 0;


    @Override
    public synchronized void lock() {
        // 阻塞

        Thread currentThread = Thread.currentThread();

        while (isLocked && currentThread != lockBy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = currentThread;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()) {
            lockCount--;
            if (lockCount == 0) {
                isLocked = false;
                notify();
            }
        }

    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
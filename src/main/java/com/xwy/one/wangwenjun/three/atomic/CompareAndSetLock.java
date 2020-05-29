package com.xwy.one.wangwenjun.three.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:使用AtomicInteger实现一个简单的锁
 * @author: xwy
 * @create: 10:33 PM 2020/5/28
 **/

public class CompareAndSetLock {
    private final AtomicInteger value = new AtomicInteger(0);

    private Thread lockedThread;

    public void tryLock() throws GetLockException {
        boolean success = value.compareAndSet(0, 1);
        if (!success)
            throw new GetLockException("get the lock faild");
        else
            lockedThread = Thread.currentThread();
    }

    public void unLock() {
        if (0 == value.get())
            return;

        if (lockedThread == Thread.currentThread())
            value.compareAndSet(1, 0);
    }
}
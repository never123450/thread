package com.xwy.test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * @description: 基于AQS简单的实现锁
 * @projectName:thread
 * @see:com.xwy.test
 * @author:xwy
 * @createTime:13/2/2022 上午8:50
 * @version:1.0
 */
public class MyLockByAtomic {

    private AtomicLong cas = new AtomicLong(0);

    private Thread currrentThread;

    /**
     * @return boolean
     * @Description 获取锁，锁是有状态的  0-表示没有人持有该锁  1-表示该锁已经被现场持有
     * 获取成功：cas 0->1 返回 true
     * 获取失败：cas 返回 false
     */
    public boolean tryLock() {
        boolean result = cas.compareAndSet(0, 1);
        if (result) {
            currrentThread = Thread.currentThread();
        }
        return result;
    }

    public boolean unLock() {
        if (currrentThread != Thread.currentThread()) {
            return false;
        }
        return cas.compareAndSet(1, 0);
    }

    public static void main(String[] args) {
        MyLockByAtomic lock = new MyLockByAtomic();
        IntStream.range(1, 10).forEach((i) -> new Thread(() -> {
            try {
                boolean result = lock.tryLock();
                if (result) {
                    lock.currrentThread = Thread.currentThread();
                    System.out.println(Thread.currentThread().getName() + " 获取到锁了");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 获取锁失败");
                }
            } catch (Exception e) {
            } finally {
                if (lock != null) {
                    lock.unLock();
                }
            }
        }).start());
    }
}

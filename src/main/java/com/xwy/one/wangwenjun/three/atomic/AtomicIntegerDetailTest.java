package com.xwy.one.wangwenjun.three.atomic;

/**
 * @description:
 * @author: xwy
 * @create: 10:02 PM 2020/5/28
 **/

public class AtomicIntegerDetailTest {

    private final static CompareAndSetLock LOCK = new CompareAndSetLock();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        doSomething2();
                    } catch (GetLockException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    private static void doSomething() {
        synchronized (AtomicIntegerDetailTest.class) {
            System.out.println(Thread.currentThread().getName() + " get the lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static void doSomething2() throws GetLockException {
        try {
            LOCK.tryLock();
            System.out.println(Thread.currentThread().getName() + " get the lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            LOCK.unLock();
        }
    }


}
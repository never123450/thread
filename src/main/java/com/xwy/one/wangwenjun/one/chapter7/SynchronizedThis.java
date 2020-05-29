package com.xwy.one.wangwenjun.one.chapter7;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:05 PM 2020/5/12
**/

public class SynchronizedThis {

    public static void main(String[] args) {

        ThisLock thisLock = new ThisLock();
        ThisLock thisLock1 = new ThisLock();

        new Thread("T1") {
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                thisLock1.m2();
            }
        }.start();
    }
}

class ThisLock {

    private final static Object LOCK = new Object(); // stack去掉试试

    public void m1() {
        synchronized (LOCK) { // LOCK换成this试试
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m2() {
        synchronized (LOCK) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

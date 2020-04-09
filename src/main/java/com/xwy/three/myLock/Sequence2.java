package com.xwy.three.myLock;

/**
 *
 * @description: 测试自定义可重入锁
 *
 * @author: xwy
 *
 * @create: 5:29 PM 2019/9/22
**/

public class Sequence2 {

    MyLock lock = new MyLock();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    private void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {
        Sequence2 sequence2 = new Sequence2();
        new Thread(() -> sequence2.a()).start();
    }
}
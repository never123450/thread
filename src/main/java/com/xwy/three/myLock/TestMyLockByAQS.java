package com.xwy.three.myLock;
/**
 *
 * @description: 测试基于AQS实现的锁
 *
 * @author: xwy
 *
 * @create: 3:45 PM 2019/9/23
**/

public class TestMyLockByAQS {

    private int value;

    private MyLockByAQS lock = new MyLockByAQS();


    public int next() {
        lock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

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
        TestMyLockByAQS testMyLockByAQS = new TestMyLockByAQS();
//        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getId() + "   " + testMyLockByAQS.next());
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getId() + "   " + testMyLockByAQS.next());
//            }
//        }).start();
        new Thread(() -> {
           testMyLockByAQS.a();
        }).start();

    }
}
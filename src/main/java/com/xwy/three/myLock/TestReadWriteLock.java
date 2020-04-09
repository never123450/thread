package com.xwy.three.myLock;
/**
 *
 * @description: 测试读写锁的互斥与共享性
 *
 * @author: xwy
 *
 * @create: 5:18 PM 2019/9/23
**/

public class TestReadWriteLock {
    public static void main(String[] args) {

        ReadWriteLockTest writeLockTest = new ReadWriteLockTest();

        new Thread(()->writeLockTest.put("a",2)).start();
        new Thread(()->writeLockTest.put("a",1)).start();
        new Thread(()->writeLockTest.put("b",2)).start();
        new Thread(()->writeLockTest.put("b",1)).start();

        new Thread(() -> System.out.println(writeLockTest.get("a"))).start();
        new Thread(() -> System.out.println(writeLockTest.get("b"))).start();
        new Thread(()->writeLockTest.put("b",1)).start();
        new Thread(() -> System.out.println(writeLockTest.get("a"))).start();

    }
}
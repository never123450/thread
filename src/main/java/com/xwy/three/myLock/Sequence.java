package com.xwy.three.myLock;

/**
 *
 * @description: 测试自定义锁
 *
 * @author: xwy
 *
 * @create: 5:29 PM 2019/9/22
**/

public class Sequence {

    private MyLock lock = new MyLock();

    private int value;

    public int getNext() {
        lock.lock();
        value++;
        lock.unlock();
        return value;
    }


    public static void main(String[] args) {
        Sequence sequence = new Sequence();

        new Thread(() -> {
            while (true)
                System.out.println(sequence.getNext());
        }).start();new Thread(() -> {
            while (true)
                System.out.println(sequence.getNext());
        }).start();new Thread(() -> {
            while (true)
                System.out.println(sequence.getNext());
        }).start();new Thread(() -> {
            while (true)
                System.out.println(sequence.getNext());
        }).start();new Thread(() -> {
            while (true)
                System.out.println(sequence.getNext());
        }).start();
    }
}
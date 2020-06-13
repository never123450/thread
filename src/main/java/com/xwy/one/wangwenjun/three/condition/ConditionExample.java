package com.xwy.one.wangwenjun.three.condition;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: xwy
 * @create: 9:06 PM 2020/6/9
 **/

public class ConditionExample {

    private final static ReentrantLock LOCK = new ReentrantLock();

    private final static Condition CONDITION = LOCK.newCondition();

    private static int data = 0;

    private static volatile boolean noUse = true;

    private static void buildData() {
        try {
            LOCK.lock();
            while (noUse) {
                CONDITION.await();
            }
            data++;
            Optional.of("P:" + data).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
            noUse = true;
            CONDITION.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void useData() {
        try {
            LOCK.lock();
            while (!noUse) {
                CONDITION.await();
            }
            TimeUnit.SECONDS.sleep(1);
            Optional.of("C:" + data).ifPresent(System.out::println);
            noUse = false;
            CONDITION.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.不使用condition只使用lock
     * 2.
     * 3.不使用lock只使用condition
     *
     * @param args
     */
    public static void main(String[] args) {

        new Thread(() -> {
            for (; ; ) {
                buildData();
            }
        }).start();

        new Thread(() -> {
            for (; ; ) {
                useData();
            }
        }).start();

    }

}
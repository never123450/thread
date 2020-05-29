package com.xwy.one.wangwenjun.two.chapter2;

/**
 * @description: 一个讲解volatile关键字最好的例子
 * @author: xwy
 * @create: 10:21 PM 2020/5/17
 **/

public class VolatileTest {
    private volatile static int INIT_VALUES = 0;
    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUES;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUES) {
                    System.out.printf("The value updated to [%d]", INIT_VALUES);
                    localValue = INIT_VALUES;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = INIT_VALUES;
            while (INIT_VALUES < MAX_LIMIT) {
                System.out.printf(" Update the value to [%d]\n",++localValue);
                INIT_VALUES = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "update").start();
    }
}
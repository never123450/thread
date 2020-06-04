package com.xwy.one.wangwenjun.three.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 6:27 AM 2020/5/30
**/

public class AtomicBooleanFlag {
    private final static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (flag.get()){
                try {
                    Thread.sleep(1000);
                    System.out.println("i am working...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("i am finished...");
        }).start();

        Thread.sleep(3000);

        flag.set(false);
    }
}
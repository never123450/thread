package com.xwy.one.wangwenjun.three.atomic;

/**
 * @description:
 * @author: xwy
 * @create: 7:43 PM 2020/5/28
 **/

public class JITTest {

    private volatile static boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!init) {

            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            init = true;
            System.out.println("set init to true");
        }).start();

    }
}
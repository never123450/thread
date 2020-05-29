package com.xwy.one.wangwenjun.three.atomic;

/**
 * @description:
 * @author: xwy
 * @create: 7:43 PM 2020/5/28
 **/

public class JITTest {

    private volatile static boolean init = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                while (!init) {

                }
            }
        }.start();

        Thread.sleep(1000);

        new Thread() {
            @Override
            public void run() {
                init = true;
                System.out.println("set init to true");
            }
        }.start();

    }
}
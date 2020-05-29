package com.xwy.one.wangwenjun.one.chapter4;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 4:45 PM 2020/5/11
**/

public class DaemonThread2 {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(100_000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            innerThread.setDaemon(true);
            innerThread.start();

            try {
                Thread.sleep(1_000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t.setDaemon(true);
        t.start();


    }
}

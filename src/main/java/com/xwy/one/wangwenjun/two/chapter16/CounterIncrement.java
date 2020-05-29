package com.xwy.one.wangwenjun.two.chapter16;

import java.util.Random;

/**
 * @description:
 * @author: xwy
 * @create: 12:14 PM 2020/5/23
 **/

public class CounterIncrement extends Thread {

    private volatile boolean terminated = false;

    private int counter = 0;

    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try {
            while (!terminated) {
                System.out.println(Thread.currentThread().getName() + " " + counter++);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.clean();
        }
    }

    private void clean() {
        System.out.println("do some clean work for the second phase,current counter :" + counter);
    }

    public void close() {
        this.terminated = true;
        this.interrupt();
    }
}
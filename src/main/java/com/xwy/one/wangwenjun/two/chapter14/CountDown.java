package com.xwy.one.wangwenjun.two.chapter14;

/**
 * @description:自己实现的CountDownLatch
 * @author: xwy
 * @create: 7:58 PM 2020/5/22
 **/

public class CountDown {

    private final int total;

    private int counter = 0;

    public CountDown(int total) {
        this.total = total;
    }

    public void down() {
        synchronized (this) {
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            while (counter != total) {
                this.wait();
            }
        }
    }

}
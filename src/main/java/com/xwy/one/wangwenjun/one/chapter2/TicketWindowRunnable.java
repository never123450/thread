package com.xwy.one.wangwenjun.one.chapter2;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 5:41 PM 2020/5/10
**/

public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 50;

    @Override
    public void run() {

        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.xwy.one.wangwenjun.one.chapter7;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:00 PM 2020/5/12
**/

public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    @Override
    public void run() {

        while (true) {
            //1
            synchronized (MONITOR) {
                if (index > MAX)
                    break;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            }
            //2
        }
    }
}
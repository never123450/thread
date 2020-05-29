package com.xwy.one.wangwenjun.one.chapter6;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 7:26 PM 2020/5/11
**/

public class ThreadCloseGraceful2 {
    private static class Worker extends Thread {

        @Override
        public void run() {
            while (true) {
                if (Thread.interrupted())
                    break;
            }
            //-------------
            //-------------
            //-------------
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();
    }
}

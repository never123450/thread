package com.xwy.one.wangwenjun.one.chapter6;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 7:26 PM 2020/5/11
**/

public class ThreadCloseGraceful {

    private static class Worker extends Thread {
        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {
                //
            }
        }

        public void shutdown() {
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }
}

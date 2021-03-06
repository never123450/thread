package com.xwy.one.wangwenjun.two.chapter6;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 5:27 PM 2020/5/19
**/

public class ReaderWorker extends Thread{

    private final SharedData data;

    public ReaderWorker(SharedData data){
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true){
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " +String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
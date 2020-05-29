package com.xwy.one.wangwenjun.two.chapter17;


import java.util.Random;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:47 PM 2020/5/23
**/

public class WorkerThread extends Thread{

    private final Channle channle;
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public WorkerThread(String s, Channle channle){
        super(s);
        this.channle = channle;
    }

    @Override
    public void run() {
        while (true){
            channle.take().execute();
            try {
                Thread.sleep(RANDOM.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
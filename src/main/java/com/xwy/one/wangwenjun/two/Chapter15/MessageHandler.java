package com.xwy.one.wangwenjun.two.Chapter15;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 11:59 AM 2020/5/23
**/

public class MessageHandler {
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    private final static Executor EXECUTOR = Executors.newFixedThreadPool(5);
    public void request(Message message){

        EXECUTOR.execute(()->{
            String value = message.getValue();
            try {
                Thread.sleep(RANDOM.nextInt(1000));
                System.out.println("The message will be handle by " + Thread.currentThread().getName() + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


//        new Thread(()->{
//            String value = message.getValue();
//            try {
//                Thread.sleep(RANDOM.nextInt(1000));
//                System.out.println("The message will be handle by " + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

    }

    public void shutDown(){
        ((ExecutorService)EXECUTOR).shutdown();
    }
}
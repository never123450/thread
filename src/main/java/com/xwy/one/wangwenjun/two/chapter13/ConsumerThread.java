package com.xwy.one.wangwenjun.two.chapter13;

import java.util.Random;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 7:41 PM 2020/5/22
**/

public class ConsumerThread extends Thread{
    private final static Random RANDOM = new Random(System.currentTimeMillis());
    private final MessageQueue messageQueue ;

    public ConsumerThread(MessageQueue messageQueue,int seq){
        super("consumer-"+seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName()+"take message " + message.getData());
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
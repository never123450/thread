package com.xwy.one.wangwenjun.two.chapter13;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 7:36 PM 2020/5/22
**/

public class ProducerThread extends Thread{

    private final static Random RANDOM = new Random(System.currentTimeMillis());
    private final MessageQueue messageQueue ;
    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue messageQueue,int seq){
        super("producer-"+seq);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = new Message("Message-"+counter.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName()+"put message " + message.getData());
                Thread.sleep(RANDOM.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
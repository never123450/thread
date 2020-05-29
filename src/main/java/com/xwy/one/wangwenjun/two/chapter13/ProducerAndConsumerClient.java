package com.xwy.one.wangwenjun.two.chapter13;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 7:44 PM 2020/5/22
**/

public class ProducerAndConsumerClient {
    public static void main(String[] args) {
        final MessageQueue messageQueue = new MessageQueue();
        new ProducerThread(messageQueue,1).start();
        new ConsumerThread(messageQueue,1).start();
    }
}
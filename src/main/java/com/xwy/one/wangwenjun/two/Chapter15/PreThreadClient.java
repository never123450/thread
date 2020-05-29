package com.xwy.one.wangwenjun.two.Chapter15;

import java.util.stream.IntStream;

/**
 * @description: Thread-Per-Message Design Pattern
 * @author: xwy
 * @create: 12:00 PM 2020/5/23
 **/

public class PreThreadClient {
    public static void main(String[] args) {
        final MessageHandler messageHandler = new MessageHandler();
        IntStream.rangeClosed(0, 10).forEach(
                i -> messageHandler.request(new Message(String.valueOf(i)))
        );
        messageHandler.shutDown();
    }
}
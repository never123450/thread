package com.xwy.one.wangwenjun.two.chapter9;

import java.util.Random;

/**
 * @description: Guarded Suspension设计模式
 * @author: xwy
 * @create: 9:58 PM 2020/5/21
 **/

public class ServerClient extends Thread {
    private final RequestQueue queue;
    private final Random random;
    private volatile boolean flag = false;

    public ServerClient(RequestQueue queue) {
        this.queue = queue;
        random = new Random(System.currentTimeMillis());
    }

    public void close() {
        this.flag = true;
        this.interrupt();
    }

    @Override
    public void run() {
        while (!flag) {
            Request request = queue.getRequest();
            if (request == null) {
                System.out.println("Received the empty request.");
                continue;
            }
            System.out.println("Server -> " + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}
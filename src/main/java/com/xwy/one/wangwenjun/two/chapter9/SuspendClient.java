package com.xwy.one.wangwenjun.two.chapter9;

/**
 * @description:
 * @author: xwy
 * @create: 10:07 PM 2020/5/21
 **/

public class SuspendClient {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "xxx").start();
        ServerClient serverClient = new ServerClient(queue);
        serverClient.start();
//        serverClient.join();
        Thread.sleep(1000);
        serverClient.close();

    }
}
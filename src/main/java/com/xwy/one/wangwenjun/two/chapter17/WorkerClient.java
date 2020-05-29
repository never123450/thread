package com.xwy.one.wangwenjun.two.chapter17;

/**
 *
 * @description: Worker Thread Design Pattern
 *
 * @author: xwy
 *
 * @create: 9:04 PM 2020/5/23
**/

public class WorkerClient {
    public static void main(String[] args) {
        final Channle channle = new Channle(5);
        channle.startWorker();
        new TransportThread("xxx",channle).start();

        new WorkerThread("aaa",channle).start();
        new WorkerThread("bbb",channle).start();
    }
}
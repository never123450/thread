package com.xwy.one.wangwenjun.two.chapter6;

/**
 *
 * @description: readWriteLock design pattern
 *                 Reader-Writer design pattern
 *
 * @author: xwy
 *
 * @create: 5:34 PM 2020/5/19
**/

public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriterWorker(sharedData,"sdsfsfesfyujhgfdsew").start();
        new WriterWorker(sharedData,"sdsfsfesfyujhgfdsew").start();
    }
}
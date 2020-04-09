package com.xwy.two.concurrent.chapter6;

/***************************************
 * @author:xwy
 * @Date:2019年09月16日22:34:03
 ***************************************/

/**
 * ReadWriteLock design pattern
 * Reader-Writer design pattern
 */
public class ReadWritLockClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new ReaderWorker(sharedData).start();
        new WriterWorker(sharedData, "qwertyuiopasdfg").start();
        new WriterWorker(sharedData, "QWERTYUIOPASDFG").start();
    }
}
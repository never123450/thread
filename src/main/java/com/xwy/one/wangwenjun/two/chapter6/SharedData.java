package com.xwy.one.wangwenjun.two.chapter6;

/**
 * @description:
 * @author: xwy
 * @create: 4:33 PM 2020/5/19
 **/

public class SharedData {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            this.buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    private char[] doRead() {
        char[] newBuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuf[i] = buffer[i];

            slowly(50);
        }
        return newBuf;
    }


    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            this.doWrite(c);
        }finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length ; i++) {
            buffer[i] = c;
        }
    }


    private void slowly(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {

        }
    }
}
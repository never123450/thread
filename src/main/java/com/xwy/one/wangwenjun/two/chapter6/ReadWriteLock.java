package com.xwy.one.wangwenjun.two.chapter6;

/**
 * @description:
 * @author: xwy
 * @create: 4:11 PM 2020/5/19
 **/

public class ReadWriteLock {
    private int readingReaders = 0; // 当前有几个线程在对他进行读操作
    private int waittingReaders = 0; // 当前有几个线程想读但是读不了
    private int writtingWriters = 0;// 当前有几个线程正在写（肯定只有一个）
    private int waittingWriters = 0; // 当前有几个线程正在等待写
    private boolean preferWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public synchronized void readLock() throws InterruptedException {
        this.waittingReaders++;
        try {
            while (writtingWriters > 0 || (preferWriter && waittingWriters > 0)) {
                this.wait();
            }
            this.readingReaders++;
        } finally {
            this.waittingReaders--;
        }
    }

    public synchronized void readUnlock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.waittingWriters++;
        try {
            while (readingReaders > 0 || waittingWriters > 0) {
                this.wait();
            }
            this.writtingWriters++;
        } finally {
            this.waittingWriters--;
        }
    }

    public synchronized void writeUnlock() {
        this.writtingWriters--;
        this.notifyAll();
    }

}
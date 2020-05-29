package com.xwy.one.wangwenjun.one.chapter10;

import java.util.Collection;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 7:51 PM 2020/5/13
**/

public interface Lock {

    class TimeOutException extends Exception {

        public TimeOutException(String message) {
            super(message);
        }
    }

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();

}
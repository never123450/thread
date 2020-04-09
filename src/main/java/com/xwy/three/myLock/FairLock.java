package com.xwy.three.myLock;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 公平锁
 * @author: xwy
 * @create: 4:27 PM 2019/9/23
 **/

public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waittingThreads = new ArrayList<QueueObject>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized (this) {
            waittingThreads.add(queueObject);
        }

        while (isLockedForThisThread) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waittingThreads.get(0) != queueObject;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waittingThreads.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
        }

        try {
            queueObject.doWait();
        } catch (InterruptedException e) {
            synchronized (this) {
                waittingThreads.remove(queueObject);
            }
            throw e;
        }
    }


    public synchronized void unLock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (waittingThreads.size() > 0) {
            waittingThreads.get(0).doNotify();
        }
    }


}
package com.xwy.one.wangwenjun.two.chapter18;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 3:40 PM 2020/5/24
**/

public class SchedulerThread extends Thread {
    private final ActivationQueue activationQueue;

    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }

    public void invoke(MethodRequest request){
        this.activationQueue.put(request);
    }

    @Override
    public void run() {
        while (true){
            activationQueue.take().execute();
        }
    }

}
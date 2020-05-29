package com.xwy.one.wangwenjun.two.chapter18;

import java.util.LinkedList;

/**
 * @description:
 * @author: xwy
 * @create: 3:36 PM 2020/5/24
 **/

public class ActivationQueue {

    private final static int MAX_METHOD_REQUEST_QUEUE_SIZE = 100;

    private final LinkedList<MethodRequest> methodQueue;

    public ActivationQueue() {
        this.methodQueue = new LinkedList<>();
    }

    public synchronized void put(MethodRequest request){
        while (methodQueue.size() >= MAX_METHOD_REQUEST_QUEUE_SIZE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.methodQueue.addLast(request);
        this.notify();
    }

    public synchronized MethodRequest take(){
        while (methodQueue.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MethodRequest methodRequest = methodQueue.removeFirst();
        this.notifyAll();
        return methodRequest;
    }

}
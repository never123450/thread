package com.xwy.one.wangwenjun.two.chapter9;

import java.util.LinkedList;

/**
 * @description:
 * @author: xwy
 * @create: 9:48 PM 2020/5/21
 **/

public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest() {
        synchronized (queue) {
            while (queue.size() <= 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                   return null;
                }
            }
        }

        return queue.removeFirst();
    }

    public void putRequest(Request request){
        synchronized (queue){
            queue.addLast(request);
            queue.notifyAll();
        }
    }

}
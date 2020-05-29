package com.xwy.one.wangwenjun.two.chapter18;

/**
 * @description:
 * @author: xwy
 * @create: 3:59 PM 2020/5/24
 **/

public class ActiveObjectFactory {

    private ActiveObjectFactory() {
    }

    public static ActiveObject createActiveObject(){
        Servant servant = new Servant();
        ActivationQueue queue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(queue);
        ActiveObjectProxy proxy = new ActiveObjectProxy(schedulerThread,servant);
        schedulerThread.start();
        return proxy;
    }

}
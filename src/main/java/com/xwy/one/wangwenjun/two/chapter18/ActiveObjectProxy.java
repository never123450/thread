package com.xwy.one.wangwenjun.two.chapter18;

/**
 * @description:
 * @author: xwy
 * @create: 3:53 PM 2020/5/24
 **/

public class ActiveObjectProxy implements ActiveObject {

    private final SchedulerThread schedulerThread;
    private final Servant servant;

    public ActiveObjectProxy(SchedulerThread schedulerThread, Servant servant) {
        this.schedulerThread = schedulerThread;
        this.servant = servant;
    }

    @Override
    public Result makeString(int count, char fillchar) {
        FutureResult futureResult = new FutureResult();
        schedulerThread.invoke(new MakeStringRequest(servant,futureResult,count,fillchar));
        return futureResult;
    }

    @Override
    public void displayString(String text) {
        FutureResult futureResult = new FutureResult();
        schedulerThread.invoke(new DisplayStringRequest(servant,futureResult, text));
    }
}
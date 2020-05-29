package com.xwy.one.wangwenjun.two.chapter18;

/**
 * @description: 对应ActiveObject的每一个方法
 * @author: xwy
 * @create: 3:20 PM 2020/5/24
 **/

public abstract class MethodRequest {

    protected final Servant servant;
    protected final FutureResult futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
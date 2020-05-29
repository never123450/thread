package com.xwy.one.wangwenjun.two.chapter18;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 3:27 PM 2020/5/24
**/

public class FutureResult implements Result{

    private Result result;
    private boolean ready = false;
    public synchronized void setResult(Result result){
        this.ready =  true;
        this.result= result;
        this.notifyAll();
    }
    @Override
    public synchronized Object getResultVaule() {
        while (!ready){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.result.getResultVaule();
    }
}
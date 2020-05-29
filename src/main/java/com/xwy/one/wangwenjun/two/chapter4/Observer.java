package com.xwy.one.wangwenjun.two.chapter4;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 3:26 PM 2020/5/18
**/

public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attache(this);
    }

    public abstract void update();

}
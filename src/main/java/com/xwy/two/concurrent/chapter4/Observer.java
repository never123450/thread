package com.xwy.two.concurrent.chapter4;

/***************************************
 * @author:xwy
 * @Date:2019年09月14日21:27:46
 ***************************************/
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();

}

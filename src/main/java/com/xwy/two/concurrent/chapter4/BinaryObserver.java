package com.xwy.two.concurrent.chapter4;

/***************************************
 * @author:xwy
 * @Date:2019年09月14日21:30:59
 ***************************************/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String:" + Integer.toBinaryString(subject.getState()));
    }
}
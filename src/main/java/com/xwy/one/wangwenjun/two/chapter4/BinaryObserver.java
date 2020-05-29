package com.xwy.one.wangwenjun.two.chapter4;

/**
 * @description:
 * @author: xwy
 * @create: 3:30 PM 2020/5/18
 **/

public class BinaryObserver extends Observer {


    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Bianry String:" + Integer.toBinaryString(subject.getState()));
    }
}
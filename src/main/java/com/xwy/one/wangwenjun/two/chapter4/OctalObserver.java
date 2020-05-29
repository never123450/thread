package com.xwy.one.wangwenjun.two.chapter4;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 3:34 PM 2020/5/18
**/

public class OctalObserver extends Observer{


    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String:" + Integer.toOctalString(subject.getState()));
    }
}
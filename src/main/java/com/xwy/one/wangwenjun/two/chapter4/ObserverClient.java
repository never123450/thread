package com.xwy.one.wangwenjun.two.chapter4;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 3:36 PM 2020/5/18
**/

public class ObserverClient {
    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("===============");
        subject.setState(10);

        System.out.println("===============");
        subject.setState(10);

        System.out.println("===============");
        subject.setState(110);
    }
}
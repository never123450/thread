package com.xwy.one.wangwenjun.two.chapter1;

/**
 * @description: 静态内部类
 * @author: xwy
 * @create: 11:57 AM 2020/5/17
 **/

public class SingletonObject6 {


    private SingletonObject6() {
    }

    private static class InstanceHolder {
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }

}
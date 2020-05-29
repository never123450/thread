package com.xwy.one.wangwenjun.two.chapter1;

/**
 * @description:
 * @author: xwy
 * @create: 11:52 AM 2020/5/17
 **/

public class SingletonObject5 {
    private static volatile SingletonObject5 instance = null;

    private SingletonObject5() {
    }

    public static SingletonObject5 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject5.class) {
                if (null == instance) {
                    instance = new SingletonObject5();
                }
            }
        }
        return instance;
    }
}
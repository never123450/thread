package com.xwy.one.wangwenjun.two.chapter1;

/**
 * @description: double check
 * @author: xwy
 * @create: 11:37 AM 2020/5/17
 **/

public class SingletonObject4 {
    private static SingletonObject4 instance = null;

    private SingletonObject4() {
    }

    public static SingletonObject4 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject4.class){
                if (null == instance){
                    instance = new SingletonObject4();
                }
            }
        }
        return instance;
    }
}
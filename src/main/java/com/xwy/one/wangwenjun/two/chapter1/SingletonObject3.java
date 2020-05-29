package com.xwy.one.wangwenjun.two.chapter1;

/**
 *
 * @description: 直接加锁  性能不好
 *
 * @author: xwy
 *
 * @create: 11:37 AM 2020/5/17
**/

public class SingletonObject3 {
    private static SingletonObject3 instance = null;

    private SingletonObject3(){}

    public synchronized static SingletonObject3 getInstance(){
        if (null == instance){
            instance = new SingletonObject3();
        }

        return SingletonObject3.instance;
    }
}
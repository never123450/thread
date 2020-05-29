package com.xwy.one.wangwenjun.two.chapter1;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 11:29 AM 2020/5/17
**/

public class SingletonObject2 {
    private static SingletonObject2 instance = null;

    private SingletonObject2(){}

    public static SingletonObject2 getInstance(){
        if (null == instance){
            instance = new SingletonObject2();
        }

        return SingletonObject2.instance;
    }
}
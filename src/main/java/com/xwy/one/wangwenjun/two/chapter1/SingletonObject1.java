package com.xwy.one.wangwenjun.two.chapter1;

/**
 *
 * @description: 饿汉模式
 *
 * @author: xwy
 *
 * @create: 11:27 AM 2020/5/17
**/

public class SingletonObject1 {

    /*
    can`t lazy load
     */
    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1(){}

    public static SingletonObject1 getInstance(){
        return instance;
    }

}
package com.xwy.two.concurrent.chapter1;

/***************************************
 * @author:xwy
 * @Date:2019年09月11日18:34:45
 ***************************************/
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
package com.xwy.two.concurrent.chapter1;

/***************************************
 * @author:xwy
 * @Date:2019年09月11日10:00:36
 ***************************************/
public class SingletonObject1 {

    /**
     * can't lazy load.
     */
    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {
        //empty
    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
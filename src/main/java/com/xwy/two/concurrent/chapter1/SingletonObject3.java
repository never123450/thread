package com.xwy.two.concurrent.chapter1;

/***************************************
 * @author:xwy
 * @Date:2019年09月11日10:03:26
 ***************************************/
public class SingletonObject3 {
    private static SingletonObject3 instance;

    private SingletonObject3() {
        //empty
    }

    public synchronized static SingletonObject3 getInstance() {

        if (null == instance)
            instance = new SingletonObject3();

        return SingletonObject3.instance;
    }
}
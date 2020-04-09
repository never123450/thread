package com.xwy.two.concurrent.chapter1;

/***************************************
 * @author:xwy
 * @Date:2019年09月11日10:01:01
 ***************************************/
public class SingletonObject2 {

    private static SingletonObject2 instance;

    private SingletonObject2() {
        //empty
    }

    public static SingletonObject2 getInstance() {
        if (null == instance)
            instance = new SingletonObject2();

        return SingletonObject2.instance;
    }
}

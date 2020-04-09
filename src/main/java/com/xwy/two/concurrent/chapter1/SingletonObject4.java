package com.xwy.two.concurrent.chapter1;

/***************************************
 * @author:xwy
 * @Date:2019年09月11日18:01:40
 ***************************************/
public class SingletonObject4 {

    private static SingletonObject4 instance;

    private SingletonObject4() {
        //---
    }

    //double check
    public static SingletonObject4 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance)
                    instance = new SingletonObject4();
            }
        }

        return SingletonObject4.instance;
    }
}

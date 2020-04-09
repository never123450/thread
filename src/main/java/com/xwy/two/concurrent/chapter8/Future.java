package com.xwy.two.concurrent.chapter8;

/***************************************
 * @author:xwy
 * @Date:2019年09月18日15:55:14
 ***************************************/
public interface Future<T> {

    T get() throws InterruptedException;

}
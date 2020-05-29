package com.xwy.one.wangwenjun.two.chapter8;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 9:43 PM 2020/5/19
**/

public interface Future <T>{
    T get() throws InterruptedException;
}

package com.xwy.one.wangwenjun.two.chapter4;

import java.util.Arrays;

/**
 *
 * @description:观察者设计模式
 *
 * @author: xwy
 *
 * @create: 4:28 PM 2020/5/18
**/

public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2"));
    }
}
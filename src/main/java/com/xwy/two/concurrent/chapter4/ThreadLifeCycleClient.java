package com.xwy.two.concurrent.chapter4;

import java.util.Arrays;

/***************************************
 * @author:xwy
 * @Date:2019年09月15日09:18:46
 ***************************************/
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1", "2"));
    }
}
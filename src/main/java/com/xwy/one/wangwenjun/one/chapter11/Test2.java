package com.xwy.one.wangwenjun.one.chapter11;

import java.util.Arrays;
import java.util.Optional;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 10:17 PM 2020/5/13
**/

public class Test2 {

    public void test() {
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e -> !e.isNativeMethod())
                .forEach(e -> Optional.of(e.getClassName() + ":" + e.getMethodName() + ":" + e.getLineNumber())
                        .ifPresent(System.out::println)
                );
    }
}

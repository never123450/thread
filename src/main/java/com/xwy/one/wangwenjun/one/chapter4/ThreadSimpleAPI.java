package com.xwy.one.wangwenjun.one.chapter4;

import java.util.Optional;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 4:57 PM 2020/5/11
**/

public class ThreadSimpleAPI {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getPriority()).ifPresent(System.out::println);
    }
}

package com.xwy.one.wangwenjun.two.chapter16;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 12:19 PM 2020/5/23
**/

public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        Thread.sleep(10_000L);
        counterIncrement.close();
    }
}
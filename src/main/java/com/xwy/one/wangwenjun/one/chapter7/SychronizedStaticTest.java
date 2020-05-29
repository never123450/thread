package com.xwy.one.wangwenjun.one.chapter7;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:03 PM 2020/5/12
**/

public class SychronizedStaticTest {
    public static void main(String[] args) {
        new Thread("T1") {
            @Override
            public void run() {
                SychronizedStatic.m1();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                SychronizedStatic.m2();
            }
        }.start();

        new Thread("T3") {
            @Override
            public void run() {
                SychronizedStatic.m3();
            }
        }.start();
    }
}

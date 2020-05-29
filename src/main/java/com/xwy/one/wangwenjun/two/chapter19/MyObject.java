package com.xwy.one.wangwenjun.two.chapter19;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 9:37 PM 2020/5/26
**/

public class MyObject {

    static {
        System.out.println("My object static block");
    }

    public String hello(){
        return "hello world";
    }
}
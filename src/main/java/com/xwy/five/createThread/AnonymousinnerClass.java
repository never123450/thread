package com.xwy.five.createThread;

/**
 *
 * @description: 创建线程的方法三：使用匿名内部类
 *
 * @author: xwy
 *
 * @create: 9:42 PM 2020/4/9
**/

public class AnonymousinnerClass {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("thread is running...")).start();
    }
}
package com.xwy.one.wangwenjun.two.chapter10;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 10:51 PM 2020/5/21
**/

public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "xxx";
        }
    };

    //JVM start main thread
    public static void main(String[] args) throws InterruptedException {
//        threadLocal.set("xxx");
        Thread.sleep(1000);
        String value = threadLocal.get();
        System.out.println(value);
    }
}
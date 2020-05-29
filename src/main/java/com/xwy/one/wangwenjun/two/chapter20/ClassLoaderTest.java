package com.xwy.one.wangwenjun.two.chapter20;

import com.xwy.one.wangwenjun.two.chapter19.MyClassLoader;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setDir("/Users/xuwenyan/Downloads");
        Class<?> aClass = classLoader.loadClass("Test");
        System.out.println(aClass);
    }
}
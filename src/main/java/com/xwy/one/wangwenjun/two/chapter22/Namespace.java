package com.xwy.one.wangwenjun.two.chapter22;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 6:53 AM 2020/5/28
**/

public class Namespace {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = Namespace.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        Class<?> bClass = classLoader.loadClass("java.lang.String");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());

    }
}

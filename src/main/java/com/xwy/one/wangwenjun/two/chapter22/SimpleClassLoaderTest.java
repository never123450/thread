package com.xwy.one.wangwenjun.two.chapter22;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 6:53 AM 2020/5/28
**/

public class SimpleClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("java.lang.String");
//        System.out.println(aClass.getClassLoader());
    }
}

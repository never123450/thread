package com.xwy.one.wangwenjun.two.chapter21;



/**
 *
 * @description: 打破双亲委托机制
 *
 * @author: xwy
 *
 * @create: 8:46 PM 2020/5/27
**/

public class SimpleCLassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        SimpleCLassLoader classLoader = new SimpleCLassLoader();
        Class<?> aClass = classLoader.loadClass("com.xwy.one.wangwenjun.two.chapter21.SimpleObject",false);
//        Class<?> aClass = classLoader.loadClass("java.lang.String",true);
        System.out.println(aClass.getClassLoader());
    }
}
package com.xwy.one.wangwenjun.two.chapter22;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 6:53 AM 2020/5/28
**/

public class RuntimePackage {
    //RuntimePackage
    //com.wangwenjun.concurrent.classloader.chapter5
    //Boot.Ext.App.com.wangwenjun.concurrent.classloader.chapter5

    //Boot.Ext.App.com.wangwenjun.concurrent.classloader.chapter5.SimpleClassLoaderTest
    //Boot.Ext.App.SimpleClassLoader.com.wangwenjun.concurrent.classloader.chapter5.SimpleClassLoaderTest

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("com.wangwenjun.concurrent.classloader.chapter5.SimpleObject");
        //sSystem.out.println(aClass.getClassLoader());
        SimpleObject simpleObject = (SimpleObject) aClass.newInstance();
    }
}

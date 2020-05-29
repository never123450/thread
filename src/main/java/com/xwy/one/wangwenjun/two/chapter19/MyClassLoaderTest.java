package com.xwy.one.wangwenjun.two.chapter19;

import java.lang.reflect.Method;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 9:48 PM 2020/5/26
**/

public class MyClassLoaderTest {
    public static void main(String[] args) {

        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
        try {
            Class<?> aClass = classLoader.loadClass("com.xwy.one.wangwenjun.two.chapter19.MyObject");
            System.out.println(aClass);
            System.out.println(aClass.getClassLoader());

            Object obj = aClass.newInstance();
            Method method = aClass.getMethod("hello", new Class<?>[]{});
            Object result = method.invoke(obj, new Object[]{});
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
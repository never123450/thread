package com.xwy.one.wangwenjun.two.chapter19;

/**
 * @description: 1.类加载器的委托是优先给父亲加载器先去尝试加载
 * 2.父加载器和子加载器其实是一种包装关系或者包含关系
 * @author: xwy
 * @create: 9:48 PM 2020/5/26
 **/

public class MyClassLoaderTest2 {

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader", classLoader);
        classLoader2.setDir("/Users/xuwenyan/Downloads/study/thread/src/main/java/com/xwy/one/wangwenjun/two/chapter19");
        try {
            Class<?> aClass = classLoader2.loadClass("com.xwy.one.wangwenjun.two.chapter19.MyObject");
            Class<?> aClass2 = classLoader2.loadClass("com.xwy.one.wangwenjun.two.chapter19.MyObject");
            System.out.println(aClass.hashCode());
            System.out.println(aClass2.hashCode());
            System.out.println(((MyClassLoader) aClass.getClassLoader()).getClassLoaderName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
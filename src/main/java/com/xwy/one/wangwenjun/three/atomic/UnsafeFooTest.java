package com.xwy.one.wangwenjun.three.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 9:54 PM 2020/5/31
**/

public class UnsafeFooTest {
    private static Unsafe getUnsafe(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class Simple{
        private long l = 0;

        public Simple() {
            this.l = 1;
            System.out.println("xxxxxxxxxx");
        }

        public long get(){
            return l;
        }
    }

    static class Guard{
        private int ACCESS_ALLOWED = 1;

        private boolean allow(){
            return 42 == ACCESS_ALLOWED;
        }

        public void work(){
            if (allow()){
                System.out.println("I an working by allowed");
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
//        Simple simple = new Simple();
//        System.out.println(simple.get());
//
//        Simple simple1 = Simple.class.newInstance();


//        Class.forName("com.xwy.one.wangwenjun.three.atomic.UnsafeFooTest");

        Unsafe unsafe = getUnsafe();
//        Simple simple2 = (Simple) unsafe.allocateInstance(Simple.class);
//        System.out.println(simple2.get());
//        System.out.println(simple2.getClass().getClassLoader());

        Guard guard = new Guard();
        guard.work();
        Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard,unsafe.objectFieldOffset(f),42);
        guard.work();

    }
}
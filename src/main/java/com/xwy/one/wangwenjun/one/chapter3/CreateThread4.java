package com.xwy.one.wangwenjun.one.chapter3;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 6:44 PM 2020/5/10
**/

public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {

        Thread t1 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }, "Test", 1 << 24);
        t1.start();
    }
}

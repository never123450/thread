package com.xwy.one.wangwenjun.three.utils.Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @description:
 * @author: xwy
 * @create: 6:32 PM 2020/6/4
 **/

public class ExchangerExample1 {

    /**
     * V r = exchange(V v)
     * <p>
     * v : indicate the object the current Thread wanted transfer
     * r : indicate the object the other Thread(pair) return object.
     *<p>
     *<pre>
     *     NOTE:
     *      1. if the pair thread not reached change point ,the thread will WAITING.
     *      2. use echange must be paired
     *
     */
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start.");
            try {
                String result = exchanger.exchange("I am come from A",10,TimeUnit.SECONDS);
                System.out.println(Thread.currentThread().getName() + "get value:" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
                System.out.println("time out...");
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        }, "--A--").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start.");
            try {
                TimeUnit.SECONDS.sleep(5);
                String result = exchanger.exchange("I am come from B");
                System.out.println(Thread.currentThread().getName() + "get value:" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        }, "--B--").start();


        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "start.");
            try {
                String result = exchanger.exchange("I am come from C");
                System.out.println(Thread.currentThread().getName() + "get value:" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        }, "---C--").start();

    }

}
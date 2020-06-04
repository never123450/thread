package com.xwy.one.wangwenjun.three.utils.Exchanger;

import java.util.concurrent.Exchanger;

/**
 * @description:
 * @author: xwy
 * @create: 6:58 PM 2020/6/4
 **/

public class ExchangerExample2 {

    public static void main(String[] args) {

        final Exchanger<Object> exchanger = new Exchanger<>();

        new Thread(() -> {
            Object aObj = new Object();
            System.out.println("A will be send the object : " + aObj);
            try {
                Object rObj = exchanger.exchange(aObj);
                System.out.println("A received the object : " + rObj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            Object bObj = new Object();
            System.out.println("B will be send the object : " + bObj);
            try {
                Object rObj = exchanger.exchange(bObj);
                System.out.println("B received the object : " + rObj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }

}
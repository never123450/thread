package com.xwy.three.myLock;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public void a(Exchanger<String> exchanger) {
        System.out.println("a 方法执行。。。。。。");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String res = "12345a";

        try {
            System.out.println("等待对比结果。。。");
            String exchange = exchanger.exchange(res);
            System.out.println("a:"+exchange);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void b(Exchanger<String> exchanger) {
        System.out.println("b 方法执行。。。。");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String res = "12345b";

        try {
            String value = exchanger.exchange(res);
            System.out.println("开始进行比对，比对结果为：" + value.equals(res));
            System.out.println("b:"+value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExchangerTest exchangerTest = new ExchangerTest();
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            exchangerTest.a(exchanger);
        }).start();

        new Thread(()->{
            exchangerTest.b(exchanger);
        }).start();

    }


}
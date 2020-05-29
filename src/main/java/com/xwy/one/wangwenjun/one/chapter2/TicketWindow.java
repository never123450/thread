package com.xwy.one.wangwenjun.one.chapter2;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 5:40 PM 2020/5/10
**/

public class TicketWindow extends Thread {

    private final String name;

    private static final int MAX = 50;

    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        while (index <= MAX) {

            System.out.println("柜台：" + name + "当前的号码是:" + (index++));
        }
    }
}

package com.xwy.one.wangwenjun.one.chapter7;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 8:00 PM 2020/5/12
**/

public class BankVersion2 {

    public static void main(String[] args) {

        final TicketWindowRunnable ticketWindow = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
    }
}

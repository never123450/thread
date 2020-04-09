package com.xwy.five.createThread.springThread;

import org.springframework.scheduling.annotation.Async;

/**
 * @description:
 * @author: xwy
 * @create: 10:05 PM 2020/4/9
 **/

@org.springframework.stereotype.Service
public class Service {

    @Async
    public void a() {
        while (true) {
            System.out.println("a");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async
    public void b() {
        while (true) {
            System.out.println("b");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
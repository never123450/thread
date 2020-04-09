package com.xwy.five.createThread;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @description: 方法五：定时器
 *
 * @author: xwy
 *
 * @create: 9:51 PM 2020/4/9
**/

public class TimerThread {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // 实现定时任务
                System.out.println("timeTask is running...");
            }
        },0,1000);
    }
}
package com.xwy.three.myLock;

import java.util.Base64;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    Random random = new Random();

    public void meeting(CyclicBarrier cyclicBarrier) {

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "到达会议室");

//        if ("Thread-1".equals(Thread.currentThread().getName())){
//            throw new RuntimeException("错误之后会一直等待");
//        }

        if ("Thread-7".equals(Thread.currentThread().getName())) {
//            Thread.currentThread().interrupt();
            cyclicBarrier.reset();
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "开始发言");
    }


    public static void main(String[] args) {
        CyclicBarrierTest test = new CyclicBarrierTest();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println("开始开会"));

        for (int i = 0; i < 10; i++) {
            new Thread(() -> test.meeting(cyclicBarrier)).start();
        }

        // 监控等待的线程数
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待的线程数：" + cyclicBarrier.getNumberWaiting());
        }).start();
    }
}
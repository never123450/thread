package com.xwy.one.wangwenjun.three.utils.CyclicBarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 10:29 PM 2020/6/3
**/

public class CyclicBarrierExample1 {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all finished");
            }
        });

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("T1 finfshed!");
                cyclicBarrier.await();
                System.out.println("T1 The other thread finished too");
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(6);
                System.out.println("T2 finfshed!");
                cyclicBarrier.await();
                System.out.println("T2 The other thread finished too");
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

       // cyclicBarrier.await();
//        System.out.println("all of fiished ");

    }
}
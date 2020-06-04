package com.xwy.one.wangwenjun.three.utils.CyclicBarrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: xwy
 * @create: 10:43 PM 2020/6/3
 **/

public class CyclicBarrierExample2 {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {

        final CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());

        cyclicBarrier.reset();

        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());

    }

}
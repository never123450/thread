package com.xwy.one.wangwenjun.two.chapter14;

import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @description:测试自己实现的CountDownLatch
 *
 * @author: xwy
 *
 * @create: 8:00 PM 2020/5/22
**/

public class CustomCountDownClient {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {

        final CountDown latch = new CountDown(5);

        System.out.println("准备多线程处理任务.");
        // the first phase

        IntStream.rangeClosed(1, 5).forEach(i -> {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" is working..");
                try {
                    Thread.sleep(RANDOM.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.down();
            },String.valueOf(i)).start();
        });

        latch.await();

        System.out.println("多线程任务全部结束");
        System.out.println("....................");
        System.out.println("FINISH");
    }
}
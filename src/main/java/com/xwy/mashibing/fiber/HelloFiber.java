package com.xwy.mashibing.fiber;


import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;

/**
 * @description:纤程
 * @projectName:thread
 * @see:com.xwy.mashibing.fiber
 * @author:xwy
 * @createTime:2022-07-21 上午10:01
 * @version:1.0
 */
public class HelloFiber {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                calc();
            }
        };
        for (int i = 0; i < 10000; i++) {
            // 串行化执行
//            calc();


            // 使用线程
//            Thread thread = new Thread(r);
//            thread.start();


            // 使用纤程
            Fiber<Void> fiber = new Fiber<Void>(new SuspendableRunnable() {
                @Override
                public void run() throws SuspendExecution, InterruptedException {
                    calc();
                }
            });
            fiber.start();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static void calc() {
        int result = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 2000; j++) {
                result += i;
            }
        }
    }
}

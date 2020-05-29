package com.xwy.one.wangwenjun.one.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 5:09 PM 2020/5/11
**/

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 10)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });
        Thread t2 = new Thread(() -> {
            IntStream.range(1, 10)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // 当前线程是main，当前线程会等到子线程执行完毕
        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 10)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}

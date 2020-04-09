package com.xwy.five.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @description: 方法六：使用线程池实现
 *
 * @author: xwy
 *
 * @create: 9:54 PM 2020/4/9
**/

public class ThreadPool {
    public static void main(String[] args) {
        Executors.newCachedThreadPool();// 可缓存线程池
        Executors.newFixedThreadPool(10); // 固定大小线程池
        Executors.newScheduledThreadPool(10); // 可定时线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();// 单线程池¬
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" running...");
            }
        });
        // 记得销毁
        executorService.shutdown();
    }
}
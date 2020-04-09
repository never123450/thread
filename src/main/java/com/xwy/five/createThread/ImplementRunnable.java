package com.xwy.five.createThread;

/**
 *
 * @description: 创建线程的方法二：实现Runnable接口
 *
 * @author: xwy
 *
 * @create: 9:12 PM 2020/4/9
**/

public class ImplementRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("thread is running...");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementRunnable());
        thread.start();
    }
}
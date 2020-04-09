package com.xwy.four.chapter1.demo;

/**
 * 示例3 - 线程stop强制性中止，破坏线程安全的示例
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        StopThread thread = new StopThread();
        thread.start();
        // 休眠1秒，确保i变量自增成功
        Thread.sleep(1000);
        // 暂停线程
        //  thread.stop(); // 错误的终止
        thread.interrupt(); // 正确终止
        while (thread.isAlive()) {
            // 确保线程已经终止
        } // 输出结果
        thread.print();
    }
}


/*
stop：终止线程，并且清除监控器锁的信息，但是可能导致线程安全问题，JDK不建议使用
Destroy：JDK未实现该方法
 */
package com.xwy.five.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: 创建线程的方法四：有返回值的线程
 * @author: xwy
 * @create: 9:46 PM 2020/4/9
 **/

public class HaveReturn implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行计算...");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HaveReturn haveReturn = new HaveReturn();
        FutureTask<Integer> task = new FutureTask<>(haveReturn);
        Thread t = new Thread(task);
        t.start();
        Integer integer = task.get();
        System.out.println("线程执行的结果为：" + integer);
    }
}
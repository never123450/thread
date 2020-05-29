package com.xwy.three.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Integer> {

    private int begin;
    private int end;

    public ForkJoinTest(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName()+"------------------");
        int sum = 0;
        // 拆分任务
        if (end - begin <= 2) {
            //计算
            for (int i = begin; i <= end; i++) {
                System.out.println("begin:" + begin + "  " + Thread.currentThread().getName());
                System.out.println("end:" + end + "  " + Thread.currentThread().getName());
                sum += i;
            }
        } else {
            ForkJoinTest forkJoinTest1 = new ForkJoinTest(begin, (begin + end) / 2);
            ForkJoinTest forkJoinTest2 = new ForkJoinTest((begin + end) / 2 + 1, end);
            forkJoinTest1.fork();
            forkJoinTest2.fork();

            Integer a = forkJoinTest1.join();
            Integer b = forkJoinTest2.join();
            sum = a + b;
            System.out.println("sum:" + sum + "  " + Thread.currentThread().getName());
        }

        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new ForkJoinTest(1, 10));
        System.out.println("...");
        System.out.println("计算的值为：" + future.get());

    }
}
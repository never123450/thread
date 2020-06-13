package com.xwy.one.wangwenjun.three.utils.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: xwy
 * @create: 9:15 PM 2020/6/10
 **/

public class ForkJoinRecursiveTask {

    private final static int MAX_THRWSHOLD = 3;

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> future = forkJoinPool.submit(new ClaculatedRecursiveTask(0, 10));
        try {
            Integer integer = future.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static class ClaculatedRecursiveTask extends RecursiveTask<Integer> {

        private final int start;

        private final int end;

        private ClaculatedRecursiveTask(int start, int end) {
            this.end = end;
            this.start = start;
        }

        @Override
        protected Integer compute() {
            if (end - start <= MAX_THRWSHOLD) {
                return IntStream.rangeClosed(start, end).sum();
            } else {
                int middle = (start + end) / 2;
                ClaculatedRecursiveTask leftTask = new ClaculatedRecursiveTask(start, middle);
                ClaculatedRecursiveTask rightTask = new ClaculatedRecursiveTask(middle + 1, end);

                leftTask.fork();
                rightTask.fork();

                return leftTask.join() + rightTask.join();
            }
        }


    }
}
package com.xwy.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @description: 自己实现线程池
 * @projectName:thread
 * @see:com.xwy.test
 * @author:xwy
 * @createTime:12/2/2022 上午9:14
 * @version:1.0
 */
public class MyExecotor {
    private List<WorkerThread> workerThreads;
    // 缓存线程任务
    private BlockingDeque<Runnable> runnables;
    private boolean isRun = true;

    public MyExecotor(int maxThreadCount, int dequeSize) {
        // 限制队列容量缓存
        runnables = new LinkedBlockingDeque<Runnable>(dequeSize);
        // 提前创建好固定的下次一直在运行状态---死循环实现
        workerThreads = new ArrayList<WorkerThread>(maxThreadCount);
        for (int i = 0; i < maxThreadCount; i++) {
            new WorkerThread().start();
        }
    }

    class WorkerThread extends Thread {
        @Override
        public void run() {
            while (isRun || runnables.size()>0) {
                Runnable runnable = runnables.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public boolean execute(Runnable command) {
        return runnables.offer(command);
    }

    public static void main(String[] args) {
        MyExecotor myExecotor = new MyExecotor(2, 2);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            myExecotor.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+","+finalI);
                }
            });
        }
        myExecotor.isRun = false;
    }
}

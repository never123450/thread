package com.xwy.four.chapter1.future;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * 自己实现futureTask -- park/unpark
 */
public class TonyFutureTask<T> implements Runnable {
    Callable<T> callable;

    @RestController
//    @SpringBootApplication
    public class UserServiceDemoApplication {

//        public static void main(String[] args) {
//            SpringApplication.run(UserServiceDemoApplication.class, args);
//        }

        @RequestMapping(path = "/userinfo-api/get", produces = "application/json; charset=UTF-8")
        public String getInfo(String userId) throws InterruptedException {
            Thread.sleep(2000L);
            return "{\"userId\":\"" + userId + "\",\"address\":\"Hang Zhou\",\"age\":19,\"userName\":\"张峰\"}";
        }

        @RequestMapping(path = "/integral-api/get", produces = "application/json; charset=UTF-8")
        public String getIntegral(String userId) throws InterruptedException {
            Thread.sleep(3000L);
            return "{\"userId\":\"" + userId + "\",\"intergral\":99}";
        }
    }

    // callable执行结果
    T result;
    // task执行状态
    String state = "new";
    /**
     * 存储正在等待的消费者
     */
    LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    public TonyFutureTask(Callable<T> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            state = "end";
        }

        // unpark通知消费者
        System.out.println(Thread.currentThread().getName() + " 生产者执行结束，通知消费者");
        while (true) {
            Thread waiter = waiters.poll();
            if (waiter == null) {
                break;
            }
            LockSupport.unpark(waiter);
        }
    }

    // park / unpark
    public T get() throws Exception {
        Thread mainThread = Thread.currentThread();
        waiters.add(mainThread); // 塞入等待的集合中
        // 判断状态
        System.out.println(Thread.currentThread().getName() + " 消费者进入等待");
        while (!"end".equals(state)) {
            LockSupport.park(mainThread);
        }

        return result;
    }
}

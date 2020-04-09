package com.xwy.three.myLock;

public class ThreadLocalTest {

    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };

    public int getNext() {
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        newThread(threadLocalTest);
        newThread(threadLocalTest);
        newThread(threadLocalTest);
        newThread(threadLocalTest);

    }

    private static void newThread(ThreadLocalTest threadLocalTest) {
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + threadLocalTest.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
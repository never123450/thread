package com.xwy.one.wangwenjun.two.chapter7;

/**
 * @description:
 * @author: xwy
 * @create: 9:04 PM 2020/5/19
 **/

public class ImmutablePreformance {

    //sync 3699    3590
    public static void main(String[] args) throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();
        SyncObj syncObj = new SyncObj();
        syncObj.setName("xxx");

        ImmutableObj immutableObj = new ImmutableObj("xxx");

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (long i = 0L; i < 1000000; i++) {
                    System.out.println(immutableObj.toString());
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (long i = 0L; i < 1000000; i++) {
                    System.out.println(immutableObj.toString());
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long enTimestamp = System.currentTimeMillis();
        System.out.println("Elapsed time " + (enTimestamp - startTimestamp));
    }
}

class ImmutableObj {
    private final String name;

    public ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }
}

class SyncObj {
    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SyncObj{" +
                "name='" + name + '\'' +
                '}';
    }
}
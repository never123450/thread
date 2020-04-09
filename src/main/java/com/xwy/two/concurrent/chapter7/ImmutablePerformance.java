package com.xwy.two.concurrent.chapter7;

/***************************************
 * @author:xwy
 * @Date:2019年09月18日15:42:50
 ***************************************/
public class ImmutablePerformance {
    public static void main(String[] args) throws InterruptedException {

        //36470 sync
        //35857 immutable
        long startTimestamp = System.currentTimeMillis();
        SyncObj synObj = new SyncObj();
        synObj.setName("Alex");

        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (long l = 0L; l < 1000000; l++) {
                    System.out.println(Thread.currentThread().getName() + "=" + synObj.toString());
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (long l = 0L; l < 1000000; l++) {
                    System.out.println(Thread.currentThread().getName() + "=" + synObj.toString());
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();


        long endTimestamp = System.currentTimeMillis();
        System.out.println("Elapsed time " + (endTimestamp - startTimestamp));
    }
}

final class ImmutableObj {
    private final String name;

    ImmutableObj(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "]";
    }
}

class SyncObj {

    private String name;

    public synchronized void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized String toString() {
        return "[" + name + "]";
    }
}
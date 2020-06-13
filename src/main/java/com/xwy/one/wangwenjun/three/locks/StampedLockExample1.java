package com.xwy.one.wangwenjun.three.locks;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: xwy
 * @create: 8:27 PM 2020/6/10
 **/

public class StampedLockExample1 {

    private final static StampedLock LOCK = new StampedLock();

    private final static List<Long> DATA = new ArrayList<>();

    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable readTask = ()->{
            for(;;){
                read();
            }
        };

        Runnable writeTask = ()->{
            for(;;){
                write();
            }
        };

        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(writeTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
        executorService.submit(readTask);
    }

    private static void read() {
        long stamped = LOCK.tryOptimisticRead();
        if (LOCK.validate(stamped)){
            stamped = LOCK.readLock();
        }
        try {
            stamped = LOCK.readLock();
            Optional.of(DATA.stream().map(String::valueOf).collect(Collectors.joining("#", "R-", ""))
            ).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlockRead(stamped);
        }
    }

    private static void write() {
        long stamped = -1;
        try {
            stamped = LOCK.writeLock();
            DATA.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            LOCK.unlockWrite(stamped);
        }
    }

}
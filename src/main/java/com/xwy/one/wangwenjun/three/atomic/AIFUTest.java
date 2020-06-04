package com.xwy.one.wangwenjun.three.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 *
 * @description: AtomicIntegerFieldUpdater Test
 *
 * @author: xwy
 *
 * @create: 7:59 AM 2020/5/30
**/

public class AIFUTest  {


    private volatile int i;

    private AtomicInteger j = new AtomicInteger();

    private AtomicIntegerFieldUpdater<AIFUTest> updater = AtomicIntegerFieldUpdater.newUpdater(AIFUTest.class,"i");

    public void update(int newValue){
        updater.compareAndSet(this,i,newValue);
    }

    public int get(){
        return i;
    }

    public static void main(String[] args) {
        AIFUTest test = new AIFUTest();
        test.update(10);
        System.out.println(test.get());
    }
}
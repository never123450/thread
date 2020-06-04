package com.xwy.one.wangwenjun.three.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.IntBinaryOperator;

/**
 * @description:
 * @author: xwy
 * @create: 7:48 AM 2020/5/30
 **/

public class AtomicIntegerFieldUpdaterTest {

    public static void main(String[] args) {
        AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        TestMe me = new TestMe();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    final int MAX = 20;
                    for (int j = 0; j < MAX; j++) {
                        int v = updater.getAndAccumulate(me, 1, new IntBinaryOperator() {
                            @Override
                            public int applyAsInt(int left, int right) {
                                return 0;
                            }
                        });
                        System.out.println(Thread.currentThread().getName() + "->" + v);
                    }
                }
            }.start();
        }
    }

    static class TestMe {
        volatile int i;
    }
}
package com.xwy.test;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @projectName:thread
 * @see:com.xwy.test
 * @author:xwy
 * @createTime:13/2/2022 上午10:04
 * @version:1.0
 */
public class AtomicStampedReferenceTest {
    private static final Integer INIT_NUM = 1000;
    private static final Integer UPDTE_NUM = 100;
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(INIT_NUM, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + ": 当前值为： " + atomicStampedReference.getReference() + " 版本号为：" + atomicStampedReference.getStamp());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (atomicStampedReference.compareAndSet(atomicStampedReference.getReference(), UPDTE_NUM, 1, stamp + 1)) {
                System.out.println(Thread.currentThread().getName() + ": 当前值为： " + atomicStampedReference.getReference() + " 版本号为：" + atomicStampedReference.getStamp());
            } else {
                System.out.println("版本号不通，更新失败");
            }
        }, "").start();
    }
}

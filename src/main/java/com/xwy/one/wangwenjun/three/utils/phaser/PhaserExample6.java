package com.xwy.one.wangwenjun.three.utils.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 11:01 PM 2020/6/12
**/

public class PhaserExample6 {

    /**
     * awaitAdvance can decremental the arrived patries？
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        final Phaser phaser = new Phaser(6);

        new Thread(()->phaser.awaitAdvance(0)).start();

        TimeUnit.SECONDS.sleep(3);

        System.out.println(phaser.getArrivedParties());

    }

    private static class AwaitAdviceTask extends Thread{
        private final Phaser phaser;

        public AwaitAdviceTask(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            super.run();
        }
    }
}
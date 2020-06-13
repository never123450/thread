package com.xwy.one.wangwenjun.three.utils.phaser;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: xwy
 * @create: 6:37 PM 2020/6/12
 **/

public class PhaserExample5 {

    private final static Random RANDOM = new Random();

    // arrive
    public static void main(String[] args) {
//        final Phaser phaser = new Phaser(3);
//        new Thread(phaser::arriveAndAwaitAdvance).start();

        final Phaser phaser = new Phaser(5);
        for (int i = 0; i < 4; i++) {
            new ArriveTask(phaser,i).start();
        }

        phaser.arriveAndAwaitAdvance();
        System.out.println("the phaser 1 work finished done.");

    }

    private static class ArriveTask extends Thread {
        private final Phaser phaser;

        public ArriveTask(Phaser phaser, int no) {
            super(String.valueOf(no));
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(getName() + "start working.");
            sleepSeconds();
            System.out.println(getName() + " the phase one is running");
            phaser.arrive();

            sleepSeconds();

            System.out.println(getName() + " keep to do other thing .");
        }
    }

    private static void sleepSeconds() {
        try {
            TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
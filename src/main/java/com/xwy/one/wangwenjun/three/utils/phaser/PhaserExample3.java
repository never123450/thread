package com.xwy.one.wangwenjun.three.utils.phaser;

import javax.print.attribute.standard.MediaSize;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: xwy
 * @create: 10:53 PM 2020/6/11
 **/

public class PhaserExample3 {

    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(1);

//        System.out.println(phaser.getPhase());
//
//        phaser.arriveAndAwaitAdvance();
//        System.out.println(phaser.getPhase());
//
//        phaser.arriveAndAwaitAdvance();
//        System.out.println(phaser.getPhase());
//
//        phaser.arriveAndAwaitAdvance();
//        System.out.println(phaser.getPhase());


//        System.out.println(phaser.getRegisteredParties());
//
//        phaser.register();
//        System.out.println(phaser.getRegisteredParties());
//
//        phaser.register();
//        System.out.println(phaser.getRegisteredParties());


//        System.out.println(phaser.getArrivedParties());
//        System.out.println(phaser.getUnarrivedParties());

//        phaser.bulkRegister(10);
//        System.out.println(phaser.getRegisteredParties());
//        System.out.println(phaser.getArrivedParties());
//        System.out.println(phaser.getUnarrivedParties());
//
//        new Thread(phaser::arriveAndAwaitAdvance).start();
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println("------------------");
//
//        System.out.println(phaser.getRegisteredParties());
//        System.out.println(phaser.getArrivedParties());
//        System.out.println(phaser.getUnarrivedParties());


        final Phaser phaser1 = new Phaser(2) {
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return true;
            }
        };

        new OnAdvanceTask("xwy",phaser).start();
        new OnAdvanceTask("aaa",phaser).start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(phaser.getUnarrivedParties());
        System.out.println(phaser.getArrivedParties());
    }

    static class OnAdvanceTask extends Thread {
        private final Phaser phaser;

        public OnAdvanceTask(String name, Phaser phaser) {
            super(name);
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println(getName() + " i am start and the phaser " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            System.out.println(getName() + " i am end and phaser");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (getName().equals("A")){
                System.out.println(getName() + " i am start and the phaser " + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
                System.out.println(getName() + " i am end and phaser");
            }
        }
    }

}
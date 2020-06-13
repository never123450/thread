package com.xwy.one.wangwenjun.three.utils.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: xwy
 * @create: 9:53 PM 2020/6/11
 **/

public class PhaserExample2 {

    final static Random random = new Random();
    final Phaser phaser = new Phaser(5);

    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);
        for (int i = 0; i < 6; i++) {
            new Athleteh(i, phaser).start();
        }

        new InjureAthleteh(6, phaser).start();
    }

    static class InjureAthleteh extends Thread {


        private final int no;
        private final Phaser phaser;

        public InjureAthleteh(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {

            try {
                sport(phaser, no + ": start running .", no + ": end running .");

                sport(phaser, no + ": start bicycle .", no + ": end bicycle .");

//                System.out.println("oh shit, i am injured");

                System.out.println("oh shit,i am injured ,i will be exited.");
                phaser.arriveAndDeregister();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Athleteh extends Thread {

        private final int no;
        private final Phaser phaser;

        public Athleteh(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {

            try {
                sport(phaser, no + ": start running .", no + ": end running .");

                sport(phaser, no + ": start bicycle .", no + ": end bicycle .");

                sport(phaser, no + ": start long jump .", no + ": end long jump .");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private static void sport(Phaser phaser, String s, String s2) throws InterruptedException {
        System.out.println(s);
        TimeUnit.SECONDS.sleep(random.nextInt(3));
        System.out.println(s2);
        System.out.println("getPhaser()--->" + phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
    }


}
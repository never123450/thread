package com.xwy.one.wangwenjun.three.utils.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 10:26 PM 2020/6/10
**/

public class PhaserExample {

    private final static Random RANDOM = new Random();

    public static void main(String[] args) {
        final Phaser phaser = new Phaser();

        IntStream.rangeClosed(1,5).boxed().map(i->phaser).forEach(Task::new);

        phaser.register();

        phaser.arriveAndAwaitAdvance();
        System.out.println("all of work finished the task");
    }

    static class Task extends Thread{

        private final Phaser phaser;

        Task(Phaser phaser){
            this.phaser = phaser;
            this.phaser.register();
            start();
        }

        @Override
        public void run() {
            System.out.println("The worker [ " + getName() + " ] is working...");
            try {
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            phaser.arriveAndAwaitAdvance();
        }


    }
}
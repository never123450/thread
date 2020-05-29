package com.xwy.one.wangwenjun.two.chapter12;

import java.io.IOException;
import java.util.Random;

public class WaiterThread extends Thread {
    private final BalkingData balkingData;
    private Random random = new Random();

    public WaiterThread(BalkingData balkingData) {
        super("Waiter");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                balkingData.save();
                Thread.sleep(random.nextInt(1000));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
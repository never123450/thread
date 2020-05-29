package com.xwy.one.wangwenjun.two.chapter12;

import java.io.IOException;
import java.util.Random;

/**
 * @description:
 * @author: xwy
 * @create: 5:04 PM 2020/5/22
 **/

public class ConsumerThread extends Thread {
    private final BalkingData data;
    private Random random = new Random();

    public ConsumerThread(BalkingData data) {
        super("Customer");
        this.data = data;
    }

    @Override
    public void run() {
        try {
            data.save();
            for (int i = 0; i < 20; i++) {
                data.change("No." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
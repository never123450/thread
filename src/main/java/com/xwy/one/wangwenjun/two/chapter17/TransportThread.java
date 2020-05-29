package com.xwy.one.wangwenjun.two.chapter17;

import java.util.Random;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:57 PM 2020/5/23
**/

public class TransportThread extends Thread{
 
    private final Channle channle;
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    
    public TransportThread(String name,Channle channle){
        super(name);
        this.channle = channle;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(),i);
                this.channle.put(request);
                Thread.sleep(RANDOM.nextInt(1_000));
            }
        }catch (Exception e){

        }
    }
}
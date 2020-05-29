package com.xwy.one.wangwenjun.one.chapter6;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:57 PM 2020/5/11
**/

public class ThreadCloseForce {


    public static void main(String[] args) {

        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
            //load a very heavy resource.
            /*while (true) {

            }*/
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
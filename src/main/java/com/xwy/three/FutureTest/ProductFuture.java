package com.xwy.three.FutureTest;
/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:33 AM 2020/5/2
**/

public class ProductFuture {

    private Product product;

    private boolean down;//是否生产完成

    public synchronized void setProduct(Product product) {
        if (down) {
            return;
        }
        this.product = product;
        this.down = true;
        notifyAll();
    }

    public synchronized Product get() {
        while (!down) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return product;
    }


}
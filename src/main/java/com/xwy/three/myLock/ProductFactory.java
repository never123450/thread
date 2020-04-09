package com.xwy.three.myLock;

import java.util.Random;

public class ProductFactory {

    public ProductFuture createProduct(String name) {
        ProductFuture f = new ProductFuture();//创建一个订单
        System.out.println("下单成功，你可以去上班了");

        //生产产品
        new Thread(()->{
            Product p = new Product(new Random().nextInt(), name);
            f.setProduct(p);
        }).start();

        return f;

    }
}
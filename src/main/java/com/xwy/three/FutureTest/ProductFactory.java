package com.xwy.three.FutureTest;

import java.util.Random;
/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:34 AM 2020/5/2
**/

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
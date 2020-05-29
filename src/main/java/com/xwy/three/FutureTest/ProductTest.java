package com.xwy.three.FutureTest;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 8:33 AM 2020/5/2
**/

public class ProductTest {
    public static void main(String[] args) {

        ProductFactory productFactory = new ProductFactory();
        //下单 交钱
        ProductFuture future = productFactory.createProduct("蛋糕");

        System.out.println("我去上班了，下了班再来取蛋糕。。。");
        // 拿着订单获取产品
        System.out.println("我拿着蛋糕回家" + future.get());
//        Product p = new Product(1, "蛋糕");
//        System.out.println("我去上班了，下班了来取蛋糕。。");
//        System.out.println("我拿着蛋糕回家了。。" + p);
    }
}
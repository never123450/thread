package com.xwy.one.wangwenjun.two.chapter8;

/**
 * @description:
 *
 * Future  代表的是未来的一个凭据
 * FutureTask 将你的调用逻辑进行了隔离
 * FutureService 桥接 Future和FutureTask
 *
 * @author: xwy
 * @create: 9:40 PM 2020/5/19
 **/

public class SyncInvoker {

    public static void main(String[] args) throws InterruptedException {
//        String result = get();
//        System.out.println(result);

        FutureService futureService = new FutureService();
//        Future<String> future = futureService.submit(() -> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "FINISH";
//        });

        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISH";
        },System.out::println);

        System.out.println("===============");
        System.out.println(" do other thing.");
        Thread.sleep(1000);
        System.out.println("================");

//        System.out.println(future.get());
    }

    private static String get() throws InterruptedException {
        Thread.sleep(1000);
        return "FINISH";
    }


}
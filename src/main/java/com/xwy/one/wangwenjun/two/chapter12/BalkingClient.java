package com.xwy.one.wangwenjun.two.chapter12;

/**
 * @description: balking设计模式
 * @author: xwy
 * @create: 5:40 PM 2020/5/22
 **/

public class BalkingClient {
    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("/Users/xuwenyan/Downloads/study/thread/src/main/java/com/xwy/one/wangwenjun/two/chapter12/balking.txt", "===BEGIN==", false);
        new ConsumerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}
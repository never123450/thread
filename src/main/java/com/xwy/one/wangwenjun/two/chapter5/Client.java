package com.xwy.one.wangwenjun.two.chapter5;

/**
 * @description:
 * @author: xwy
 * @create: 3:24 PM 2020/5/19
 **/

public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User(gate, "bj", "beiJing");
        User sh = new User(gate, "sh", "shangHai");
        User gz = new User(gate, "gz", "guanZhou");
        bj.start();
        sh.start();
        gz.start();
    }
}
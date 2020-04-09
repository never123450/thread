package com.xwy.two.concurrent.chapter5;

/***************************************
 * @author:xwy
 * @Date:2019年09月15日09:22:50
 ***************************************/
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baobao", "Beijing", gate);
        User sh = new User("ShangLao", "ShangHai", gate);
        User gz = new User("GuangLao", "GuangZhou", gate);

        bj.start();
        sh.start();
        gz.start();
    }
}

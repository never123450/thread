package com.xwy.five.createThread.springThread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 方法七：Spring对多线程的支持
 * @author: xwy
 * @create: 10:09 PM 2020/4/9
 **/

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        Service service = ac.getBean(Service.class);
        service.a();
        service.b();
    }
}
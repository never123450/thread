package com.xwy.one.wangwenjun.two.chapter16;

import java.io.IOException;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 8:11 PM 2020/5/23
**/

public class AppServerClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server = new AppServer(13345);
        server.start();

        Thread.sleep(3_000L);
        server.shutdown();
    }
}
package com.xwy.three.httpServer;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: xwy
 * @create: 9:54 AM 2020/5/5
 **/

public class HttpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动，监听:8888端口");

        while (!Thread.interrupted()) {
            Socket client = serverSocket.accept();

            InputStream ins = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int len = 0;
            byte[] b = new byte[1024];
            while ((len = ins.read(b)) != -1) {
                System.out.println(new String(b, 0, len));
            }
        }
    }
}
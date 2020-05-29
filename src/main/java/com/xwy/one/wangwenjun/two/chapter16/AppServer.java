package com.xwy.one.wangwenjun.two.chapter16;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: xwy
 * @create: 7:49 PM 2020/5/23
 **/

public class AppServer extends Thread {
    private final int port;

    private static final int DEFAULT_PORT = 12722;

    private volatile boolean start = true;

    private List<ClientHandler> clientHandlers = new ArrayList<>();

    private final ExecutorService exechtor = Executors.newFixedThreadPool(10);

    private ServerSocket serverSocket;

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (start) {
                Socket client = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(client);
                exechtor.submit(clientHandler);
                this.clientHandlers.add(clientHandler);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            this.dispose();
        }
    }

    private void dispose() {
//        clientHandlers.stream().forEach(c -> c.stop());
        System.out.println("dispose");
        clientHandlers.stream().forEach(ClientHandler::stop);
        this.exechtor.shutdown();
    }

    public void shutdown() throws IOException {
        System.out.println("shutdown");
        this.start = false;
        this.interrupt();
        this.serverSocket.close();
    }


}
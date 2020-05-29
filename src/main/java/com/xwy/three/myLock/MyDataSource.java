package com.xwy.three.myLock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 自定义数据库连接池
 * @author: xwy
 * @create: 5:33 PM 2020/4/28
 **/

public class MyDataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int INIT_CONNECTION = 5;//初始连接数

    private static final String URL = "";

    private static final String USER_NAME = "";

    private static final String PASSWORD = "";

    private Lock lock = new ReentrantLock();


    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyDataSource() {

        for (int i = 0; i < INIT_CONNECTION; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                pool.addLast(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public Connection getConnection() {
        Connection result = null;
        lock.lock();
        try {
            while (pool.size() <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!pool.isEmpty()) {
                result = pool.removeFirst();
            }
            return result;
        } finally {
            lock.unlock();
        }

    }

    public void release(Connection connection) {
        try {
            lock.lock();
            if (connection == null) {
                pool.addLast(connection);
                notifyAll();
            }
        } finally {
            lock.unlock();
        }

    }

}
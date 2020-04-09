package com.xwy.three.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 简易数据库连接池
 * @author: xwy
 * @create: 3:48 PM 2019/9/24
 **/

public class MyDataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int INIT_CONNECTION = 10;

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private static final String USER = "";

    private static final String PASSWORD = "";

    private static final String URL = "";


    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化连接池
     */
    public MyDataSource() {
        for (int i = 0; i < INIT_CONNECTION; i++) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.addLast(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取连接 使用wait
     *
     * @return
     */
//    public Connection getConnection() {
//        Connection result = null;
//        synchronized (pool) {
//            while (pool.size() <= 0) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (!pool.isEmpty()) {
//                result = pool.removeFirst();
//            }
//        }
//        return result;
//    }

    /**
     * 释放连接 使用notify
     *
     * @param connection
     */
//    public void release(Connection connection) {
//        if (connection != null) {
//            synchronized (pool) {
//                pool.addLast(connection);
//                notifyAll();
//            }
//        }
//    }

    /**
     * 使用lock获取连接
     * @return
     */
    public Connection getConnection() {
        Connection result = null;
        lock.lock();
        try {
            while (pool.size() <= 0) {
                try {
                    c1.wait();
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

    /**
     * 使用lock是否连接
     * @param connection
     */
    public void release(Connection connection) {
        if (connection != null) {
            lock.lock();
            try {
                synchronized (pool) {
                    pool.addLast(connection);
                    c1.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
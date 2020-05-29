package com.xwy.one.wangwenjun.two.chapter22;



import com.xwy.one.wangwenjun.two.chapter19.MyClassLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 6:54 AM 2020/5/28
**/

public class ThreadContextClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());


        Class.forName("com.mysql.jdbc.Driver");//(---)
        Connection conn = DriverManager.getConnection("");
    }
}

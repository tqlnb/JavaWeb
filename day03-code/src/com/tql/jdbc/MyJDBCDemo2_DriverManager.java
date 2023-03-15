package com.tql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBCDemo2_DriverManager {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*
        *
        * DriverManager详解
        *
        * */
        //注册驱动-在5.几版本后可以省略
        //Class aClass = Class.forName("com.mysql.jdbc.Driver");

        //获取连接 - 如果获取的是本地连接,并且端口是默认3306 可以把ip和端口省略
        String url = "jdbc:mysql:///db1?useSSL=false&verifyServerCertificate=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql语句
        String sql = "update account set money = 1200 where name = '张三';";

        //获取执行sql得到对象
        Statement stmt = conn.createStatement();

        //执行sql
        int count = stmt.executeUpdate(sql);

        //处理结果
        System.out.println(count);

        //释放资源
        stmt.close();
        conn.close();

    }
}

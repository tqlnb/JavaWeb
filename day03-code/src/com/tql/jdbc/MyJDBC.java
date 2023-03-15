package com.tql.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //注册驱动
        //Class aClass = Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false&verifyServerCertificate=false";
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

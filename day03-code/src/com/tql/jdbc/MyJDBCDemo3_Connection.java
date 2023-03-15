package com.tql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBCDemo3_Connection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*
        *
        * Connection详解
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
        String sql1 = "update account set money = 2000 where name = '张三';";
        String sql2 = "update account set money = 2000 where name = '李四';";

        //开启事务
        Statement stmt = conn.createStatement();


        try {
            //开启事务
            conn.setAutoCommit(false);

            //获取执行sql的对象
            stmt = conn.createStatement();

            //执行sql1,返回值是处理的结果
            int count1 = stmt.executeUpdate(sql1);
            //处理结果
            System.out.println(count1);

            //执行sql2,返回值是处理的结果
            int count2 = stmt.executeUpdate(sql2);
            //处理结果
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            e.printStackTrace();
        }


        //释放资源
        stmt.close();
        conn.close();

    }
}

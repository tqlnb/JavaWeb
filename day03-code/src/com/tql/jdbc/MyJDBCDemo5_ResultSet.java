package com.tql.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MyJDBCDemo5_ResultSet {
    /*
     *
     * Result测试
     * 执行DQL查询语句
     *
     * */
    @Test
    public void testResult() throws SQLException {

        //注册驱动-在5.几版本后可以省略
        //Class aClass = Class.forName("com.mysql.jdbc.Driver");

        //获取连接 - 如果获取的是本地连接,并且端口是默认3306 可以把ip和端口省略
        String url = "jdbc:mysql:///db1?useSSL=false&verifyServerCertificate=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql语句
        String sql1 = "select id,name,money from account;";

        //获取statement对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql1);

        //处理结果
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(id +"--"+ name +"--"+ money);
        }

        //释放资源
        rs.close();
        stmt.close();
        conn.close();

    }
}

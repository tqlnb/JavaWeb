package com.tql.test;

import java.sql.*;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws SQLException {
        //把数据库里的数据存入account并存入数组

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

        //创建集合
        ArrayList<Account> list = new ArrayList<>();

        //处理结果
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            list.add(new Account(id , name ,money));
        }

        System.out.println(list);

    }
}

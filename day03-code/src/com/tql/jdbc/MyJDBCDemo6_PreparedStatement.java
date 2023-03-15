package com.tql.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MyJDBCDemo6_PreparedStatement {
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
        String url = "jdbc:mysql:///test?useSSL=false&verifyServerCertificate=false&useServerPrepStmts=true";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);


        //接收用户名和密码
        String name = "lisi";
        String pwd = "12334 'or '1' = '1";

        //定义sql语句
        String sql1 = "select id,username,password from user where username = ? and password = ? ";

        //获取statement对象
        PreparedStatement ps = conn.prepareStatement(sql1);

        ps.setString( 1 , name);
        ps.setString(2 , pwd);

        ResultSet resultSet = ps.executeQuery();

        if(resultSet.next()){
            System.out.println("登陆成功");
        }else
            System.out.println("登陆失败");

        resultSet.close();
        ps.close();
        conn.close();
    }
}

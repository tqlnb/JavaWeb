package com.tql.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MyJDBCDemo7_UserLogin {
    /*
     *
     *    用户登录
     *
     * */
    @Test
    public void testLogin() throws SQLException {

        //注册驱动-在5.几版本后可以省略
        //Class aClass = Class.forName("com.mysql.jdbc.Driver");

        //获取连接 - 如果获取的是本地连接,并且端口是默认3306 可以把ip和端口省略
        String url = "jdbc:mysql:///test?useSSL=false&verifyServerCertificate=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //接收用户名和密码
        String name = "lisi";
        String pwd = "12334 'or '1' = '1";


        //定义sql语句
        String sql1 = "select id,username,password from user where username = '"+name+"' and password = '" + pwd+ "' ";

        //获取statement对象
        Statement stmt = conn.createStatement();

        //执行sql
        try {
            conn.setAutoCommit(false);
            ResultSet resultSet = stmt.executeQuery(sql1);

            if(resultSet.next()){
                System.out.println("登陆成功");
            }else {
                System.out.println("登陆失败");
            }

            conn.commit();
            resultSet.close();
        } catch (SQLException e) {
            conn.rollback();
            throw new RuntimeException(e);
        }
        stmt.close();
        conn.close();
    }
}

package com.tql.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBCDemo4_Statement {

    /*
     *
     * DML执行
     *
     * */
    @Test
    public void testDML() throws SQLException {

        //注册驱动-在5.几版本后可以省略
        //Class aClass = Class.forName("com.mysql.jdbc.Driver");

        //获取连接 - 如果获取的是本地连接,并且端口是默认3306 可以把ip和端口省略
        String url = "jdbc:mysql:///db1?useSSL=false&verifyServerCertificate=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql语句
        String sql1 = "update account set money = 2000 where name = '赵六';";
        //获取statement对象
        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);

            //获取执行sql的对象
            stmt = conn.createStatement();

            //执行sql1,返回值是受影响的的行数
            int count1 = stmt.executeUpdate(sql1);
            //处理结果
            if(count1 > 0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }

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

    /*
     *
     * DDL执行
     *
     * */
    @Test
    public void testDDL() throws SQLException {

        //注册驱动-在5.几版本后可以省略
        //Class aClass = Class.forName("com.mysql.jdbc.Driver");

        //获取连接 - 如果获取的是本地连接,并且端口是默认3306 可以把ip和端口省略
        String url = "jdbc:mysql:///db1?useSSL=false&verifyServerCertificate=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //定义sql语句
        String sql1 = "drop database if exists db3 ";
        //获取statement对象
        Statement stmt = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);

            //获取执行sql的对象
            stmt = conn.createStatement();

            //执行sql1,返回值是受影响的的行数
            int count1 = stmt.executeUpdate(sql1);//执行完DDL语句,可能返回是0
            //处理结果
            if(count1 > 0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }

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

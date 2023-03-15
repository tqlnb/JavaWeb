package com.tql.Test1;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("day03-code/druid.properties"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取Connection
        Connection connection = dataSource.getConnection();

        //定义sql
        String sql = "select id,brand_name,company_name,ordered,description,status from tb_brand";

        //获取Statement对象
        Statement statement = connection.createStatement();

        //执行sql语句,获取返回
        ResultSet rs = statement.executeQuery(sql);

        //创建集合存brand
        ArrayList<Brand> list = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String brand_name = rs.getString("brand_name");
            String company_name = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            list.add(new Brand(id, brand_name , company_name , ordered , description , status));
        }
        System.out.println(list);

        //释放资源
        rs.close();
        statement.close();
        connection.close();
    }
}

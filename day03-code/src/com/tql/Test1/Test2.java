package com.tql.Test1;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("day03-code/druid.properties"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取Connection
        Connection connection = dataSource.getConnection();

        //定义sql
        String sql = "insert into tb_brand (brand_name,company_name,ordered,description,status) values (?,?,?,?,?);";

        PreparedStatement ps = connection.prepareStatement(sql);
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 300;
        String description = "卖三亿杯";
        int status = 1;
        ps.setString( 1 , brandName);
        ps.setString( 2 , companyName);
        ps.setInt( 3 , ordered);
        ps.setString( 4 , description);
        ps.setInt( 5 , status);

        int count = ps.executeUpdate();

        System.out.println(count > 0);

        //释放资源

        ps.close();
        connection.close();
    }
}

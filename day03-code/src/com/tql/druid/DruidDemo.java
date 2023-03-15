package com.tql.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid数据库连接池演示
 *
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //导包

        //定义配置文件

        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("day03-code/druid.properties"));

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}

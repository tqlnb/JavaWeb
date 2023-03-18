package com.tql;

import com.tql.mapper.UserMapper;
import com.tql.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBaitsDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        * MyBaits 代理开发
        *
        * */

        //加载MyBaits的核心配置文件,获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSessionFactory对象,用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
/*        List<User> users = sqlSession.selectList("test.selectAll");
        sqlSession.update("test.updateZhangsan");*/

        //获取UserMapper接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();

        System.out.println(users);

        //释放资源
        sqlSession.close();
    }
}

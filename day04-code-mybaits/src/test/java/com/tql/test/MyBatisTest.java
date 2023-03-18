package com.tql.test;

import com.tql.mapper.BrandMapper;
import com.tql.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {

        //获取SqlSessionFactory
        //加载MyBaits的核心配置文件,获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //执行方法
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

        //释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {

        //获取SqlSessionFactory
        //加载MyBaits的核心配置文件,获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int id = 2;

        //执行方法
        Brand brand = mapper.selectById(id);
        System.out.println(brand);


        //释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectByCondition() throws IOException {

        //获取SqlSessionFactory
        //加载MyBaits的核心配置文件,获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int status = 0;
        String companyName = "三只";
        String brandName = "三只";

        companyName = "%" + companyName +"%";
        brandName = "%" + brandName +"%";

        Map<String , String> map = new HashMap<>();

        map.put("status" , String.valueOf(status));
        map.put("companyName" , companyName);
        map.put("brandName" , brandName);


        //执行方法
        Brand brand = mapper.selectByCondition(map);
        System.out.println(brand);


        //释放资源
        sqlSession.close();

    }

    @Test
    public void testSelectByConditionSingle() throws IOException {

        //获取SqlSessionFactory
        //加载MyBaits的核心配置文件,获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int status = 1;
        String companyName = "三只";
        String brandName = "三只";

        companyName = "%" + companyName +"%";
        brandName = "%" + brandName +"%";

        Brand brand = new Brand();
        //brand.setBrandName(brandName);
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);


        //执行方法
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        System.out.println(brands);


        //释放资源
        sqlSession.close();

    }

    /*
    * 添加
    * */
    @Test
    public void add() throws IOException {

        //获取SqlSessionFactory
        //加载MyBaits的核心配置文件,获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int status = 1;
        String companyName = "三只";
        String brandName = "三只";
        int ordered = 120;
        String description = "哈哈哈";

        Brand brand = new Brand(null,brandName,companyName, ordered ,description,status);



        //执行方法
        mapper.add(brand);

        //提交事务
        sqlSession.commit();


        //释放资源
        sqlSession.close();

    }

    /*
     * 修改
     * */
    @Test
    public void testUpdate() throws IOException {

        //获取SqlSessionFactory
        //加载MyBaits的核心配置文件,获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取Mapper接口代理对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int id = 7;
        int status = 1;
        String companyName = "三只11";
        String brandName = "三只22";
        int ordered = 120;
        String description = "哈哈哈11";

        Brand brand = new Brand(id,brandName,companyName, ordered ,description,status);

        //执行方法
        int update = mapper.update(brand);

        System.out.println(update);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }
}

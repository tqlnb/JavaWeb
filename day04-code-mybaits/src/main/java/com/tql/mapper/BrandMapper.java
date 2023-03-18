package com.tql.mapper;

import com.tql.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /*
    * 查询所有
    * */

    public List<Brand> selectAll();

    /*
    * 查看详情 根据ID查询
    * */
    Brand selectById(int id);

    /*
    * 多条件查询
    * */
    Brand selectByCondition(Map<String , String> map );

    /*
    * 单条件动态查询
    * */
    List<Brand> selectByConditionSingle(Brand brand);

    /*
    * 添加
    * */
    void add(Brand brand);

    /*
    * 修改
    * */
    int update(Brand brand);

    /*
    * 删除 按id
    * */
    void deleteById(int id);

    /*
    * 批量删除
    * */
    void deleteByIds(@Param("ids") int[] ids);

}

package com.tql.mapper;

import com.tql.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);


}

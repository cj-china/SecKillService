package com.lasttime.lasttime.dao;

import com.lasttime.lasttime.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from sys_user")
    public List<User> selectAll();
}

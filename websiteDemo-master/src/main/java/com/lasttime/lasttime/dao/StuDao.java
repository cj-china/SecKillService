package com.lasttime.lasttime.dao;

import com.lasttime.lasttime.entity.Student;
import com.lasttime.lasttime.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StuDao {


    @Select("select * from stu_score")
    List<Student> selectAll();

    @Select("insert into stu_score values()")
    int insertScore();
}

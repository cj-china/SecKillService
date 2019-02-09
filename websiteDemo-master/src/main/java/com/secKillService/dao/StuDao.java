package com.secKillService.dao;

import com.secKillService.entity.Student;

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

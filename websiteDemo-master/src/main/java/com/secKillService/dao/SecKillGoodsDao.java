package com.secKillService.dao;

import com.secKillService.entity.SecKillGoods;
import com.secKillService.entity.Student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SecKillGoodsDao {


    @Select("select * from miaosha_goods")
    List<SecKillGoods> selectAll();

}

package com.secKillService.dao;

import com.secKillService.entity.SecKillGoods;
import com.secKillService.entity.Student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SecKillGoodsDao {

    String TABLE = "miaosha_goods";

    @Select("select * from miaosha_goods")
    List<SecKillGoods> selectAll();

    @Update(" update "
        + TABLE
        + " set "
        + " stock_count = stock_count - 1 "
        + " where "
        + " id = #{id} "
    )
    int updateStock(@Param("id") long id);

    @Select("select * from "
        + TABLE
        + " where "
        + "id = #{id} ")
    SecKillGoods selectById(@Param("id") long id);
}

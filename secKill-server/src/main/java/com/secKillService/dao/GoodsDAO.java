package com.secKillService.dao;

import com.secKillService.entity.Goods;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDAO {
  String TABLE = "goods";

  @Select("select * from goods")
  List<Goods> selectAll();

  @Update(" update "
      + TABLE
      + " set "
      + " goods_stock=100 "
      + " where "
      + " id = #{id} "
  )
  int updateStock(@Param("id") long id);

  @Select("select * from "
      + TABLE
      + " where "
      + "id = #{id} ")
  Goods selectById(@Param("id") long id);

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert(" insert into "
      + TABLE
      + " set "
      + " goods_name = #{goods_name}, "
      + " goods_title= #{goods_title}, "
      + " goods_img= #{goods_img}, "
      + " goods_detail = #{goods_detail}, "
      + " goods_price = #{goods_price}, "
      + " goods_stock = #{goods_stock}, "
  )
  int insertByOrderInfo(@Param("goods") Goods goods);

  @Delete("delete from "
  +TABLE
  +"where id=#{id}")
  int deleteGoodsById(@Param("id") long id);
}

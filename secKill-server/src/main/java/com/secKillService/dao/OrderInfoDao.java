package com.secKillService.dao;

import com.secKillService.entity.OrderInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderInfoDao {

  String TABLE_NAME = "order_info";

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert(" insert into "
      + TABLE_NAME
      + " set "
      + " user_id=#{user_id}, "
      + " goods_id=#{goods_id}, "
      + " Delivery_addr_id=#{Delivery_addr_id}, "
      + " goods_name=#{goods_name}, "
      + " order_channel=#{order_channel}, "
      + " staus=#{staus}, "
      + " create_date=#{create_date}, "
      + " pay_date=#{pay_date} "
  )
  int insertByOrderInfo(@Param("orderString") OrderInfo orderInfo);
}

package com;

import com.base.BaseDaoTest;
import com.secKillService.dao.OrderInfoDao;
import com.secKillService.entity.OrderInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Date;


public class OrderInfoDaoTest extends BaseDaoTest {


  @Autowired
  OrderInfoDao orderInfoDao;

  @Test
  @Rollback(false)
  public void insetTest(){
    OrderInfo orderInfo = new OrderInfo();
    orderInfo.setUser_id(1);
    orderInfo.setGoods_id(1);
    orderInfo.setCreate_date(new Date());
    orderInfo.setDelivery_addr_id(1);
    orderInfo.setGoods_count(1);
    orderInfo.setGoods_name("123");

    int n = orderInfoDao.insertByOrderInfo(orderInfo);
    System.out.println(n);
  }

}

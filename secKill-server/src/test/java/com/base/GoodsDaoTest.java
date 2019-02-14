package com.base;

import com.secKillService.dao.GoodsDAO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GoodsDaoTest extends BaseDaoTest{
  @Autowired
  GoodsDAO goodsDAO;
  @Test
  public void updateTest(){
    int a=goodsDAO.updateStock(1);
    System.out.println(a);
  }

}

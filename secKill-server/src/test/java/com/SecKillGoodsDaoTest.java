package com;

import com.base.BaseDaoTest;
import com.secKillService.dao.SecKillGoodsDao;
import com.secKillService.entity.SecKillGoods;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

public class SecKillGoodsDaoTest extends BaseDaoTest {


  @Autowired
  SecKillGoodsDao secKillGoodsDao;

  @Test
  public void SecKillGoodsDaoTest(){
    List<SecKillGoods> secKillGoods =  secKillGoodsDao.selectAll();
    System.out.println(secKillGoods);
  }

  @Test
  @Rollback(false)
  public void updateStockTest(){
    int id = 1;
    secKillGoodsDao.updateStock(id);
  }

}

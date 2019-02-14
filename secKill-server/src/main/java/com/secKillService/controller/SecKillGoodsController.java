package com.secKillService.controller;

import com.secKillService.dao.OrderInfoDao;
import com.secKillService.dao.SecKillGoodsDao;
import com.secKillService.entity.OrderInfo;
import com.secKillService.entity.SecKillGoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@RestController
public class SecKillGoodsController {

  @Autowired
  private SecKillGoodsDao secKillGoodsDao;

  @Autowired
  private OrderInfoDao orderInfoDao;

  @RequestMapping(value="index")
  public ModelAndView listSeckillgoods(){
    List<SecKillGoods> secKillGoods = secKillGoodsDao.selectAll();
    ModelAndView modelAndView =  new ModelAndView("index");
    modelAndView.addObject("secKillGoods", secKillGoods);
    return modelAndView;
  }

  @RequestMapping(value="seckill")
  public int seckill(@RequestParam("id") int id ){
      //判断库存数量  上面的是对的，判断语句
      if(secKillGoodsDao.selectById(id).getStock_count()>0){
        secKillGoodsDao.updateStock(id);
        Date date=new Date();
        OrderInfo orderInfo=new OrderInfo();
        orderInfoDao.insertByOrderInfo(orderInfo);
      }
     return secKillGoodsDao.selectById(id).getStock_count();
  }
}

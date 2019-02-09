package com.secKillService.controller;

import com.secKillService.dao.SecKillGoodsDao;
import com.secKillService.entity.SecKillGoods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SecKillGoodsController {

  @Autowired
  private SecKillGoodsDao secKillGoodsDao;

  @RequestMapping(value="seckillgoods")
  public ModelAndView show(){
    List<SecKillGoods> secKillGoods = secKillGoodsDao.selectAll();
    ModelAndView modelAndView =  new ModelAndView("seckillgoodsinfo");
    modelAndView.addObject("secKillGoods", secKillGoods);
    return modelAndView;
  }
}

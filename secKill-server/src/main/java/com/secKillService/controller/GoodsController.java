package com.secKillService.controller;

import com.secKillService.dao.GoodsDAO;
import com.secKillService.dao.SecKillGoodsDao;
import com.secKillService.entity.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GoodsController {
  @Autowired
  GoodsDAO goodsDAO;

  @Autowired
  SecKillGoodsDao secKillGoodsDao;

  @RequestMapping(value="goods")
  public ModelAndView listgoods(){
    List<Goods> goods = goodsDAO.selectAll();
    System.out.println("goods"+","+goods);
    ModelAndView modelAndView =  new ModelAndView("goods");
    modelAndView.addObject("goods", goods);
    return modelAndView;
  }


}

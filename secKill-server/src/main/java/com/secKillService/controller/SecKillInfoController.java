package com.secKillService.controller;

import com.secKillService.dao.GoodsDAO;
import com.secKillService.dao.SecKillGoodsDao;
import com.secKillService.entity.Goods;
import com.secKillService.entity.SecKillGoods;
import com.secKillService.entity.SecKillInfo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
public class SecKillInfoController {
  @Autowired
  GoodsDAO goodsDAO;

  @Autowired
  SecKillGoodsDao secKillGoodsDao;

  @RequestMapping(value = "seckillinfo")
  public ModelAndView listSeckillInfo(){
    List<SecKillInfo> listSecKillInfo=new ArrayList<SecKillInfo>() ;
    List<Goods> listGoods=goodsDAO.selectAll();
    List<SecKillGoods> listSeckillGoods=secKillGoodsDao.selectAll();
    for(SecKillGoods secKillGoods:listSeckillGoods){
        for(Goods goods:listGoods){
          if(secKillGoods.getGoods_id()==goods.getId()){
            SecKillInfo secKillInfo=new SecKillInfo();
            secKillInfo.setGoods_name(goods.getGoods_name());
            System.out.println("goods_name"+","+goods.getGoods_name());
            secKillInfo.setGoods_price(goods.getGoods_price());
            secKillInfo.setMiaosha_price(secKillGoods.getMiaosha_price());
            secKillInfo.setStock_count(secKillGoods.getStock_count());
            listSecKillInfo.add(secKillInfo);
          }
        }
    }

    ModelAndView modelAndView =  new ModelAndView("seckillinfo");
    System.out.println("listSeckillInfo"+":"+listSecKillInfo);
    modelAndView.addObject("secKillInfo", listSecKillInfo);
    return modelAndView;
  }

}

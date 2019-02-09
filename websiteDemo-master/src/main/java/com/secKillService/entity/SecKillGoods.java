package com.secKillService.entity;

import java.util.Date;

import lombok.Data;

@Data
public class SecKillGoods {
  private int id;
  private int goodsId;
  private double miaoshaPrice;
  private int stockCount;
  private Date startDate;
  private Date endDate;

  @Override
  public String toString() {
    return "SecKillGoods{" +
        "id=" + id +
        ", goodsId=" + goodsId +
        ", miaoshaPrice=" + miaoshaPrice +
        ", stockCount=" + stockCount +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        '}';
  }
}

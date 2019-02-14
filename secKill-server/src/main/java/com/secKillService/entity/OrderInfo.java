package com.secKillService.entity;

import java.util.Date;

public class OrderInfo {
  private int id;
  private int userId;
  private int goodsId;
  private int DeliveryAddrId;
  private String goodsName;
  private double goodsPrice;
  private int orderChannel;
  private int staus;
  private Date createDate;
  private Date payDate;

  public OrderInfo(int id, int userId, int goodsId, int deliveryAddrId, String goodsName,
                   double goodsPrice, int orderChannel, int staus, Date createDate, Date payDate) {
    this.id = id;
    this.userId = userId;
    this.goodsId = goodsId;
    DeliveryAddrId = deliveryAddrId;
    this.goodsName = goodsName;
    this.goodsPrice = goodsPrice;
    this.orderChannel = orderChannel;
    this.staus = staus;
    this.createDate = createDate;
    this.payDate = payDate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(int goodsId) {
    this.goodsId = goodsId;
  }

  public int getDeliveryAddrId() {
    return DeliveryAddrId;
  }

  public void setDeliveryAddrId(int deliveryAddrId) {
    DeliveryAddrId = deliveryAddrId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public double getGoodsPrice() {
    return goodsPrice;
  }

  public void setGoodsPrice(double goodsPrice) {
    this.goodsPrice = goodsPrice;
  }

  public int getOrderChannel() {
    return orderChannel;
  }

  public void setOrderChannel(int orderChannel) {
    this.orderChannel = orderChannel;
  }

  public int getStaus() {
    return staus;
  }

  public void setStaus(int staus) {
    this.staus = staus;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getPayDate() {
    return payDate;
  }

  public void setPayDate(Date payDate) {
    this.payDate = payDate;
  }

  @Override
  public String toString() {
    return
        id +","+
        + userId +","
        + goodsId +","
       + DeliveryAddrId +","
        + goodsName +"," +
        + orderChannel +","
        + staus +","
        + createDate +","
        + payDate
       ;
  }
}

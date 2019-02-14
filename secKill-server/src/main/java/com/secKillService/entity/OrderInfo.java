package com.secKillService.entity;


import java.util.Date;

public class OrderInfo {
  private int id;
  private int user_id;
  private int goods_id;
  private int delivery_addr_id;
  private String goods_name;
  private int goods_count;
  private double goods_price;
  private int order_channel;
  private int status;
  private Date create_date;
  private Date pay_date;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getGoods_id() {
    return goods_id;
  }

  public void setGoods_id(int goods_id) {
    this.goods_id = goods_id;
  }

  public int getDelivery_addr_id() {
    return delivery_addr_id;
  }

  public void setDelivery_addr_id(int delivery_addr_id) {
    this.delivery_addr_id = delivery_addr_id;
  }

  public String getGoods_name() {
    return goods_name;
  }

  public void setGoods_name(String goods_name) {
    this.goods_name = goods_name;
  }

  public int getGoods_count() {
    return goods_count;
  }

  public void setGoods_count(int goods_count) {
    this.goods_count = goods_count;
  }

  public double getGoods_price() {
    return goods_price;
  }

  public void setGoods_price(double goods_price) {
    this.goods_price = goods_price;
  }

  public int getOrder_channel() {
    return order_channel;
  }

  public void setOrder_channel(int order_channel) {
    this.order_channel = order_channel;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Date getCreate_date() {
    return create_date;
  }

  public void setCreate_date(Date create_date) {
    this.create_date = create_date;
  }

  public Date getPay_date() {
    return pay_date;
  }

  public void setPay_date(Date pay_date) {
    this.pay_date = pay_date;
  }

  public OrderInfo(int id, int user_id, int goods_id, int delivery_addr_id, String goods_name,
                   int goods_count, double goods_price, int order_channel, int status, Date
                       create_date, Date pay_date) {
    this.id = id;
    this.user_id = user_id;
    this.goods_id = goods_id;
    this.delivery_addr_id = delivery_addr_id;
    this.goods_name = goods_name;
    this.goods_count = goods_count;
    this.goods_price = goods_price;
    this.order_channel = order_channel;
    this.status = status;
    this.create_date = create_date;
    this.pay_date = pay_date;
  }

  public OrderInfo() {
  }
}

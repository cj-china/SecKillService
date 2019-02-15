package com.secKillService.entity;

public class SecKillInfo {
  private String goods_name;
  private double goods_price;
  private double miaosha_price;
  private int stock_count;

  public String getGoods_name() {
    return goods_name;
  }

  public void setGoods_name(String goods_name) {
    this.goods_name = goods_name;
  }

  public double getGoods_price() {
    return goods_price;
  }

  public void setGoods_price(double goods_price) {
    this.goods_price = goods_price;
  }

  public double getMiaosha_price() {
    return miaosha_price;
  }

  public void setMiaosha_price(double miaosha_price) {
    this.miaosha_price = miaosha_price;
  }

  public int getStock_count() {
    return stock_count;
  }

  public void setStock_count(int stock_count) {
    this.stock_count = stock_count;
  }
}

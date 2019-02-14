package com.secKillService.entity;

public class Goods {
  private int id;
  private String goods_name;
  private String goods_title;
  private String goods_img;
  private String goods_detail;
  private double goods_price;
  private int goods_stock;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGoods_name() {
    return goods_name;
  }

  public void setGoods_name(String goods_name) {
    this.goods_name = goods_name;
  }

  public String getGoods_title() {
    return goods_title;
  }

  public void setGoods_title(String goods_title) {
    this.goods_title = goods_title;
  }

  public String getGoods_img() {
    return goods_img;
  }

  public void setGoods_img(String goods_img) {
    this.goods_img = goods_img;
  }

  public String getGoods_detail() {
    return goods_detail;
  }

  public void setGoods_detail(String goods_detail) {
    this.goods_detail = goods_detail;
  }

  public double getGoods_price() {
    return goods_price;
  }

  public void setGoods_price(double goods_price) {
    this.goods_price = goods_price;
  }

  public int getGoods_stock() {
    return goods_stock;
  }

  public void setGoods_stock(int goods_stock) {
    this.goods_stock = goods_stock;
  }
}

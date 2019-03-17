package web;

import util.DBUtils;

public class Test {
  public static void main(String[] args){
    try {
      System.out.println(DBUtils.getConn());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

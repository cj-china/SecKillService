package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Utils.DBUtil;
import entity.A;

public class DAO {
  public static List<A> select(){
    List<A> as=new ArrayList<A>();
    Connection conn=null;
    Statement ps=null;
    ResultSet rs=null;
    try {
      conn=DBUtil.getConnection();
      String sql="select tab1.*, CONCAT(tm.first_name, ' ', tm.last_name) as creatorName, tab2" +
          ".leadName from \n" +
          "(select ltd.team_id, ltd.transaction_name, ltd.close_time, ltd.home_price, ltd.lead_id" +
          " from lead_transaction_detail ltd \n" +
          "left join lead_v2 lv on ltd.lead_id = lv.id \n" +
          "where ltd.type =1 and ltd.status = 6 and ltd.delete_flag = 0 ) tab1\n" +
          "left join \n" +
          "team_member tm on tab1.team_id = tm.team_id\n" +
          "left join \n" +
          "(select lv.id, CONCAT(uv.first_name, ' ', uv.last_name) as leadName from lead_v2 lv " +
          "left join user_v2 uv on lv.lead_user_id = uv.id \n" +
          "where lv.id in (select distinct(lead_id) from lead_transaction_detail where " +
          "delete_flag = 0 ) )\n" +
          "tab2 on tab1.lead_id = tab2.id\n" +
          "where tm.team_id = tm.member_user_id order by tab1.team_id, tab1.close_time desc";
      ps=conn.createStatement();
      rs=ps.executeQuery(sql);
      System.out.println("成功：……………………"+rs);
      while (rs.next()){
        A a=new A();
        a.setId(rs.getInt(1));
        a.setLeadName(rs.getString(2));
        a.setTeamID((Long) rs.getObject("team_id"));
        a.setHomePrice((Long) rs.getObject("home_price"));
        as.add(a);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return as;
  }
}

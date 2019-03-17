import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo11 {
  public static void main(String[] args){
      String sql1="update person set money=money+2000 where id=1";
      String sql2="update person set money=money-2000 where id=2";
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      conn.setAutoCommit(false);
      stat.addBatch(sql1);
      stat.addBatch(sql2);
      stat.executeBatch();
      rs=stat.executeQuery("select money from person where id=2");
      while (rs.next()){
        int money=rs.getInt("money");
        if(money>0){
          conn.commit();
          System.out.println("转账成功");
        }else{
          conn.rollback();
          System.out.println("钢铁侠的钱不够");
        }
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

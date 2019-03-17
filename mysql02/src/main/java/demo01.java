import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo01 {
  @Test
  public void select(){
    Connection conn =null;
    Statement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      rs=stat.executeQuery("select * from emp");
      while (rs.next()){
        int id=rs.getInt(1);
        String name=rs.getString(2);
        int age=rs.getInt(3);
        System.out.println(id+","+name+","+age);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      try {
        DBUtils.close(conn,stat,rs);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}

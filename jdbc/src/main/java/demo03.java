import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo03 {
  @Test
  public void insert() throws SQLException, ClassNotFoundException, IOException {
    Connection conn=null;
    Statement stat=null;
    conn=DBUtils.getConnection();
    stat=conn.createStatement();
    String sql="insert into jdbc values(1,'Tom')";
    stat.executeUpdate(sql);
    System.out.println("执行完毕");
    stat.close();
    conn.close();
  }

  @Test
  public void select() throws SQLException, IOException {
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      String sql="select * from emp";
      rs=stat.executeQuery(sql);
      while (rs.next()){
        int id=rs.getInt("id");
        String name=rs.getString("name");
        System.out.println(id+","+name);
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      DBUtils.close(conn,stat,rs);

    }
  }
}

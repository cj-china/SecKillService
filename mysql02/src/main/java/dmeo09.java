import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dmeo09 {
  @Test
  public void test01(){
    String sql1="insert into user values(null,'悟空','aaa')";
    String sql2="insert into user values(null,'八戒','bbb')";
    String sql3="insert into user values(null,'沙僧','ccc')";
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      stat.addBatch(sql1);
      stat.addBatch(sql2);
      stat.addBatch(sql3);
      stat.executeBatch();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test02(){
    String sql="insert into user values(null,?,?)";
    Connection conn=null;
    PreparedStatement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.prepareStatement(sql);
      stat.setString(1,"刘备");
      stat.setString(2,"aaa");
      stat.addBatch();
      stat.setString(1,"关羽");
      stat.setString(2,"bbb");
      stat.addBatch();
      stat.setString(1,"张飞");
      stat.setString(2,"ccc");
      stat.addBatch();
      stat.executeBatch();

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

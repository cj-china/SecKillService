import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo12 {
  public static void main(String[] args){
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      String sql="insert into user values(null,'刘德华','abc')";
      stat.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
      rs=stat.getGeneratedKeys();
      while (rs.next()){
        int id=rs.getInt(1);
        System.out.println("自增主键："+id);
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

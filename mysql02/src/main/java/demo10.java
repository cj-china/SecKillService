import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo10 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("请输入页数");
    int page=sc.nextInt();
    System.out.println("请输入条数");
    int count=sc.nextInt();
    String sql="select * from user limit ?,?";
    Connection conn=null;
    PreparedStatement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.prepareStatement(sql);
      stat.setInt(1,(page-1)*count);
      stat.setInt(2,count);
      rs=stat.executeQuery();
      while (rs.next()){
        int id=rs.getInt("id");
        String username=rs.getString("username");
        System.out.println(id+","+username);
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

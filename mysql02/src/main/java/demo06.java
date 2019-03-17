import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo06 {
  public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.println("请输入名字");
    String name=scanner.nextLine();
    System.out.println("请输入年龄");
    int age=scanner.nextInt();
    String sql="insert into jdbcuser values(?,?)";
    System.out.println(sql);
    Connection conn=null;
    PreparedStatement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.prepareStatement(sql);
      stat.setString(1,name);
      stat.setInt(2,age);
      System.out.println("保存成功");
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

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo05 {
  public static void main(String[] args){
      System.out.println("请输入名字");
    Scanner scanner=new Scanner(System.in);
    String name= scanner.nextLine();
    System.out.println("请输入年龄");
    int age=scanner.nextInt();
    String sql="insert into jdbcuser values('"+name+"',"+age+")";
    System.out.println(sql);
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      stat.executeUpdate(sql);
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

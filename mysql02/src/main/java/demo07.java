import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo07 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("请输入姓名");
    String username=sc.nextLine();
    System.out.println("请输入密码");
    String password=sc.nextLine();
    boolean a=demo07.login(username,password);
    if(a){
      System.out.println("正确");
    }else{
      System.out.println("错误");
    }

  }

  private static boolean login(String username,String password) {
    String sql = "select count(*) from user where username='" + username + "' and password='" + password + "'";
    System.out.println(sql);
    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      rs=stat.executeQuery(sql);
      while (rs.next()){
        int count=rs.getInt(1);
        if(count>0){
          return true;
        }
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
    return false;
  }
}

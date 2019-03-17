import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo13 {
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("请输入球队名称");
    String teamName=sc.nextLine();
    System.out.println("请输入球员名称");
    String playerName=sc.nextLine();
    Connection conn=null;
    PreparedStatement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      String sql1="select id from team where name=?";
      stat=conn.prepareStatement(sql1);
      stat.setString(1,teamName);
      rs=stat.executeQuery();
      int teamid=-1;
      while (rs.next()){
        teamid=rs.getInt(1);
      }
      if(teamid==-1){
        String sql2="insert into team values (null,?) ";
        stat.close();
        stat=conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
        stat.setString(1,teamName);
        stat.executeUpdate();
        rs.close();
        rs=stat.getGeneratedKeys();
        while (rs.next()){
          teamid=rs.getInt("id");
        }
      }
      String sql3="insert into player values(null,?,?)";
      stat.close();
      stat=conn.prepareStatement(sql3);
      stat.setString(1,playerName);
      stat.setInt(2,teamid);
      stat.executeUpdate();
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

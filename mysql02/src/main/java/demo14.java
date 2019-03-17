import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class demo14 {
  public static void main(String[] args){
      Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;
    try {
      conn=DBUtils.getConnection();
      stat=conn.createStatement();
      //得到数据库的元数据
      DatabaseMetaData dbData=conn.getMetaData();
      System.out.println("驱动版本："+dbData.getDriverVersion());
      System.out.println("用户名："+dbData.getUserName());
      System.out.println("连接地址："+dbData.getURL());
      System.out.println("数据库名称："+dbData.getDatabaseProductName());

      //获取表相关
      rs=stat.executeQuery("select * from emp");
      ResultSetMetaData rsData=rs.getMetaData();
      int count=rsData.getColumnCount();
      for(int i=0;i<count;i++){
        String name=rsData.getColumnName(i+1);
        String type=rsData.getColumnTypeName(i+1);
        System.out.println(name+","+type);
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

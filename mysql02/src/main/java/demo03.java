import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class demo03 {
public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
  Connection c1=DBUtils.getConnection();
  System.out.println("获取到连接1"+c1);
  Connection c2=DBUtils.getConnection();
  System.out.println("获取到连接2"+c2);
  Connection c3=DBUtils.getConnection();
  System.out.println("获取到连接3"+c3);
  //归还连接并断开连接

  Connection c4=DBUtils.getConnection();
  System.out.println("获取到连接4"+c4);
}
}

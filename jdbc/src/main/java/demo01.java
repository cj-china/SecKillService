import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo01 {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.jdbc.Driver");
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db3",
        "root", "123456");
    Statement stat=conn.createStatement();
    String sql="drop table if exists jdbc";
    stat.execute(sql);
    System.out.println("执行完毕");
  }
}

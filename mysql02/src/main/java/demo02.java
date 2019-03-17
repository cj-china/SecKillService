import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class demo02 {
  BasicDataSource dataSource=new BasicDataSource();
  public static void main(String[] args) throws SQLException {
    //创建数据源对象
    BasicDataSource dataSource=new BasicDataSource();
    //设置数据库的连接信息
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/db3");
    dataSource.setUsername("root");
    dataSource.setPassword("123456");
    //设置初始连接数量
    dataSource.setInitialSize(3);
    //设置最大连接数量
    dataSource.setMaxActive(5);
    //从数据池中获取连接
    Connection conn=dataSource.getConnection();
    System.out.println(conn);

  }
}

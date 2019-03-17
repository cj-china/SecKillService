package util;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
  private static String driver;
  private static String url;
  private static String username;
  private static String password;

  private static BasicDataSource dataSource;
  static {
    Properties properties=new Properties();
    InputStream ips= DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
    try {
      properties.load(ips);
      driver=properties.getProperty("driver");
      url=properties.getProperty("url");
      username=properties.getProperty("username");
      password=properties.getProperty("password");

      dataSource=new BasicDataSource();
      dataSource.setDriverClassName(driver);
      dataSource.setUrl(url);
      dataSource.setUsername(username);
      dataSource.setPassword(password);
      dataSource.setInitialSize(3);
      dataSource.setMaxActive(5);

    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      try {
        ips.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  public static Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

  public static void close(Connection conn,
                           Statement stat, ResultSet rs) {
    try {
      if(rs!=null) {
        rs.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if(stat!=null) {
        stat.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    try {
      if(conn!=null) {
        //打开自动提交
        conn.setAutoCommit(true);
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}

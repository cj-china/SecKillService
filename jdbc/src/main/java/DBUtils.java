import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
  Connection conn=null;
  Statement stat=null;
  ResultSet rs=null;
  public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
    Properties properties=new Properties();
    InputStream ips=DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
    properties.load(ips);
    String driver=properties.getProperty("driver");
    String url=properties.getProperty("url");
    String username=properties.getProperty("username");
    String password=properties.getProperty("password");
    Class.forName(driver);
    return DriverManager.getConnection(url,username,password);
  }

  public static void close(Connection c,Statement s,ResultSet r) throws SQLException {
    if(r!=null){
      r.close();
    }
    if(s!=null){
      s.close();
    }
    if(c!=null){
      c.close();
    }
  }
}

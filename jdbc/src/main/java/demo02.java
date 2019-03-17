import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo02 {
  @Test
  public void test01(){
    System.out.println("方法1执行了");
  }

  @Test
  public void test02(){
    System.out.println("方法2执行了");
  }

  @Test
  public void insert() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","123456");
    Statement stat=conn.createStatement();
    String table="create table jdbc(id int,name varchar(10)) engine=innodb charset=utf8";
    String sql="insert into jdbc values(1,'Tom')";
    stat.execute(table);
    int count=stat.executeUpdate(sql);
    System.out.println("插入"+count+"条数据");
    stat.close();
    conn.close();
  }

  @Test
  public void upadate() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","123456");
    Statement stat=conn.createStatement();
    String sql="update jdbc set name='Jerry' where id=1";
    int count=stat.executeUpdate(sql);
    System.out.println(count);
    stat.close();
    conn.close();
  }

  @Test
  public void delete() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","123456");
    Statement stat=conn.createStatement();
    String sql="delete from jdbc where id=1";
    int count=stat.executeUpdate(sql);
    System.out.println(count);
    stat.close();
    conn.close();
  }

  @Test
  public void select() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","123456");
    Statement stat=conn.createStatement();
    String sql="select * from emp";
    ResultSet rs=stat.executeQuery(sql);
    while (rs.next()){
      int id=rs.getInt("id");
      String name=rs.getString("name");
      int age=rs.getInt("age");
      System.out.println(id+name+age);
    }
    System.out.println("执行完毕");
    rs.close();
    stat.close();
    conn.close();

  }
}

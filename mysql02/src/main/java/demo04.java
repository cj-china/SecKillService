import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class demo04 {
  public static void main(String[] args){
      DemoThread d1=new DemoThread();
    d1.start();
    DemoThread d2=new DemoThread();
    d2.start();
    DemoThread d3=new DemoThread();
    d3.start();
    DemoThread d4=new DemoThread();
    d4.start();
  }
}
class DemoThread extends Thread{
  public void run(){
    try {
      Connection conn=DBUtils.getConnection();
      System.out.println("得到连接");
      Thread.sleep(5000);
      conn.close();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

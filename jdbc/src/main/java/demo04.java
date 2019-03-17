import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class demo04 {
  public static void main(String[] args){
    Properties prop=new Properties();
    InputStream ips=demo04.class.getClassLoader().getResourceAsStream("jdbc.properties");
    try {
      prop.load(ips);
      String name=prop.getProperty("name");
      String age=prop.getProperty("age");
      System.out.println(name+","+age);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

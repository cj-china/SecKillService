import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie c=new Cookie("username","Sallly");
    resp.addCookie(c);
    String city= URLEncoder.encode("北京","utf-8");
    Cookie c2=new Cookie("city","city");
    resp.addCookie(c2);
  }
}

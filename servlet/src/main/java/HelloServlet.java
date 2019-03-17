import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
  public HelloServlet(){
    System.out.println("构造方法执行");
  }
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String number=req.getParameter("number");
    String name=req.getParameter("name");
    resp.setContentType("text/html");
    PrintWriter out=resp.getWriter();
    out.println("<h1>hell:"+name+"<h1>");
    out.close();
  }
}

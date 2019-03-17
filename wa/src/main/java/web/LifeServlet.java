package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {
  public LifeServlet(){
    System.out.println("LifeServlet的构造器");
  }

  @Override
  public void init() throws ServletException {
    System.out.println("LifeServlet的init方法");
  }

  @Override
  public void destroy() {
    System.out.println("LifeServlet的destroy方法");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException
      , IOException {
    doGet(req,resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    System.out.println("LifeServlet的doGet方法");
    ServletConfig config=getServletConfig();
    String company=config.getInitParameter("company");
    System.out.println("company:"+company);
  }


}

package web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.UserDAO;
import entity.User;

public class CacheListener implements ServletContextListener {
  /*
  容器启动后，会立即创建Servlet上下文，
  就会产生相应的时间，容器就会调用此方法
   */
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    System.out.println("contextInitalized...");
    UserDAO dao=new UserDAO();
    try {
      List<User> users=dao.findAll();
      ServletContext sctx=servletContextEvent.getServletContext();
      sctx.setAttribute("users",users);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}

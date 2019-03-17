package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener {
  @Override
  public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    System.out.println("sessionCreated...");
    HttpSession session=httpSessionEvent.getSession();
    ServletContext sctx=session.getServletContext();
    Integer count=(Integer) sctx.getAttribute("count");
    if(count==null){
      count=1;
    }else {
      count++;
    }
    sctx.setAttribute("count",count);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    System.out.println("sessionDestroyed..");
    ServletContext sctx=httpSessionEvent.getSession().getServletContext();
    Integer count=(Integer) sctx.getAttribute("count");
    count--;
    sctx.setAttribute("count",count);
  }
}

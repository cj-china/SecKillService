package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //获取session对象
    HttpSession session=req.getSession();
    String sessionId=session.getId();
    System.out.println("sessionId:"+sessionId);
    Integer count=(Integer)session.getAttribute("count");
    if(count==null){
      //第一次访问
      count=1;
    }else {
      count++;
    }
    //将访问次数绑定到session对象上
    session.setAttribute("count",count);
    resp.setContentType("text/html;charset=utf-8");
    resp.getWriter().println("你是第"+count+"次访问");

  }
}

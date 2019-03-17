package web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SomeServlet2 extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session=req.getSession();
    Date date=(Date)session.getAttribute("date");
    resp.setContentType("text/html;charset=utf-8");
    if(date==null){
      resp.getWriter().println("你是第一次访问");
      date=new Date();
    }else {
      resp.getWriter().println("你上次的访问是在："+date);
      date=new Date();
    }
    session.setAttribute("date",date);
  }
}

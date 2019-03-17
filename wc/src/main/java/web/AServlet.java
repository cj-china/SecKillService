package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext sctx=getServletContext();
    System.out.println("sctc:"+sctx);
    sctx.setAttribute("username","Sally");

    HttpSession session=req.getSession();
    session.setAttribute("music","光年之外");
  }
}

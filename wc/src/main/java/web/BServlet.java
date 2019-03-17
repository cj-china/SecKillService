package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out=resp.getWriter();
    ServletContext sctx=getServletContext();
    String username=(String)sctx.getAttribute("username");
    out.println("username:"+username);
    HttpSession session=req.getSession();
    String music=(String)session.getAttribute("music");
    out.println("music:"+music);

    String company=sctx.getInitParameter("company");
    out.println("company:"+company);
  }
}

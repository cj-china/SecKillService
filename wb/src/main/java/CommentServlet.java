import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("CommentServlet的service方法");
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out=resp.getWriter();
    String content=req.getParameter("content");
    out.println("你的看法是："+content);

  }
}

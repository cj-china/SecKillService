import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import util.DBUtil;

public class DelUserServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf8");
    PrintWriter out=resp.getWriter();
    int id=Integer.parseInt(req.getParameter("id"));
    UserDAO dao=new UserDAO();
    dao.delete(id);
    resp.sendRedirect("listUser");
  }
}

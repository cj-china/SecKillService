import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtil;

public class ListUserServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf8");
    PrintWriter out=resp.getWriter();

    UserDAO dao=new UserDAO();
    List<User> users=dao.findAll();
    req.setAttribute("users",users);
    req.getRequestDispatcher("listUser.jsp").forward(req,resp);
  }
}

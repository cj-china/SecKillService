import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
import util.DBUtil;

public class AddUserServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //处理表单中文参数值的问题
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out=resp.getWriter();
    String username=req.getParameter("username");
    String pwd=req.getParameter("pwd");
    String email=req.getParameter("email");

    UserDAO dao=new UserDAO();
    try {
      User user=dao.findByUsername(username);
      if(user!=null){
        req.setAttribute("msg","用户名已存在");
        req.getRequestDispatcher("addUser.jsp").forward(req,resp);
      }else{
        user=new User();
        user.setUsername(username);
        user.setPwd(pwd);
        user.setEmail(email);
        dao.save(user);
        resp.sendRedirect("listUser");

      }
    } catch (SQLException e) {
      e.printStackTrace();
      out.println("系统繁忙，请稍后再试！");
    }

  }
}

package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class LoginServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out=resp.getWriter();
    String username=req.getParameter("username");
    String pwd=req.getParameter("pwd");
    System.out.println(username+":"+pwd);
    /*
     * 查询数据库，看是否有匹配的记录,
     * 如果有，则登录成功，重定向到success.jsp。
     * 如果没有，则登录失败，转发到login.jsp,
     * 并提示"用户名或密码错误"。
     */
    UserDAO dao=new UserDAO();
    try {
      User user=dao.findByUsername(username);
      System.out.println(user);
      if(user!=null&&user.getPwd().equals(pwd)){
        /*
         * 登录成功,将一些数据绑订到
         * session对象上，为session验证
         * 做准备。
         */
        HttpSession session=req.getSession();
        session.setAttribute("user",user);
        resp.sendRedirect("success.jsp");
      }else {
        //登录失败
        req.setAttribute("login_failed","用户名或密码错误");
        req.getRequestDispatcher("login.jsp").forward(req,resp);

      }
    } catch (Exception e) {
      e.printStackTrace();
      out.println("fail");
    }
  }
}

package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;

public class ActionServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String uri=req.getRequestURI();
    String path=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
    if("/login".equals(path)){
      processLogin(req,resp);
    }else if("/list".equals(path)){
      try {
        processList(req,resp);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }else if("/add".equals(path)){
      processAdd(req,resp);
    }else if ("/del".equals(path)){
      proceessDel(req,resp);
    }
  }

  private void proceessDel(HttpServletRequest req,HttpServletResponse resq){
    int id=Integer.parseInt(req.getParameter("id"));
    UserDAO dao=new UserDAO();

    try {
      dao.delete(id);
      resq.sendRedirect("list.do");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void processAdd(HttpServletRequest req,HttpServletResponse resq) throws UnsupportedEncodingException {
        req.setCharacterEncoding("ut-8");
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        String email=req.getParameter("email");

        UserDAO dao=new UserDAO();
    try {
      User user=dao.findByUsername(username);
      if(user!=null){
        req.setAttribute("msg","用户名已存在");
        req.getRequestDispatcher("addUser.jsp").forward(req,resq);
      }else {
        user=new User();
        user.setUsername(username);
        user.setPwd(pwd);
        user.setEmail(email);
        dao.save(user);
        resq.sendRedirect("list.do");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void processList(HttpServletRequest req,HttpServletResponse resq) throws Exception {
    /*
     * 先做session验证, 如果没有登录，则重定向到登录 页面，不再向下执行。
     */
    HttpSession session=req.getSession();
    Object obj=session.getAttribute("user");
    if(obj==null){
      try {
        resq.sendRedirect("login.jsp");
      } catch (IOException e) {
        e.printStackTrace();
      }
      return;
    }

    UserDAO dao=new UserDAO();
    List<User> users=dao.findAll();
    req.setAttribute("users",users);
    req.getRequestDispatcher("listUser.jsp").forward(req,resq);
  }

  private void processLogin(HttpServletRequest req,HttpServletResponse resq){
    String username=req.getParameter("username");
    String pwd=req.getParameter("pwd");
    UserDAO dao=new UserDAO();
    try {
      User user=dao.findByUsername(username);
      if(user!=null&&user.getPwd().equals(pwd)){
        HttpSession session=req.getSession();
        session.setAttribute("user",user);
        resq.sendRedirect("list.do");
      }else {
        req.setAttribute("login_fail","用户名或密码错徐");
        req.getRequestDispatcher("login.jsp").forward(req,resq);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

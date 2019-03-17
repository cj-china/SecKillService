import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.CookieUtil;

public class CountServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset+utf-8");
    PrintWriter out=resp.getWriter();
    /*
     * 先查看有没有一个名称为"count"的
     * cookie,如果没有(该用户是第1次访问),
     * 则添加一个名称为"count"的cookie,
     * 值设置为1。
     * 如果有(该用户已经访问过),则将cookie
     * 的值加1,然后重新添加该cookie。
     */
    String count= CookieUtil.findCookie("count",req);
    if(count==null){
      CookieUtil.addCookie("count","1",30*24*60*60,"/servlet",resp);
      out.println("你是第一次访问");
    }else {
      int v1=Integer.parseInt(count)+1;
      CookieUtil.addCookie("count",v1+"",30*24*60*60,"/servlet",resp);
      out.println("你是第"+v1+"次访问");
    }
  }
}

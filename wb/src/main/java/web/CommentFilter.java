package web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentFilter implements Filter {

  public CommentFilter(){
    System.out.println("CommentFilter的构造器");
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("CommentFilter的init方法");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    System.out.println("CommentFilter的doFilter方法开始执行");
    HttpServletRequest request=(HttpServletRequest) servletRequest;
    HttpServletResponse response=(HttpServletResponse) servletResponse;
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    String content=request.getParameter("content");
    if(content.indexOf("狗")!=-1){
      //包含了敏感词，不再向后调用
      //返回处理结果。
      out.println("评论包含了违禁词");
    }else {
      filterChain.doFilter(request,response);
    }
    System.out.println("CommentFilter的doFilter方法执行完毕");
  }

  @Override
  public void destroy() {

  }
}

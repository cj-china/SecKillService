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

public class CommentFilter2 implements Filter {
  private FilterConfig config;

  /**
   * 容器启动之后，会立即创建过滤器实例。
   * 注：
   * 	　只会创建一个实例!
   */

  public CommentFilter2(){
    System.out.println("CommnetFilter2的构造器");

  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    config=filterConfig;
    System.out.println("CommentFilter的init方法");
  }

  /**
   * 容器在调用完过滤器的init方法之后，
   * 会调用doFilter方法来处理请求。
   * 注:(了解)
   *    ServletRequest是HttpServletRequest
   *    的父接口，ServletResponse是
   *    HttpServletResponse的父接口。
   *
   * FilterChain(过滤器链):
   * 		如果调用了该对象的doFilter方法，
   * 表示继续向后调用；否则，中断请求，返回
   * 处理结果。
   *
   */

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    System.out.println("CommentFilter2的doFilter方法开始执行");
    HttpServletRequest request=(HttpServletRequest) servletRequest;
    HttpServletResponse response=(HttpServletResponse) servletResponse;
    request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out=response.getWriter();
    int size=Integer.parseInt(config.getInitParameter("size"));
    String content=request.getParameter("content");
    if(content.length()>size){
      out.println("评论字数过多");
    }else{
      filterChain.doFilter(request,response);
    }
    System.out.println("CommentFilter2的daoFilter方法执行完毕");
  }

  @Override
  public void destroy() {

  }
}

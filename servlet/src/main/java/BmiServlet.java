import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    String height=req.getParameter("height");
    String weight=req.getParameter("weight");
    String[] interest=req.getParameterValues("interest");
    if(interest!=null){
      for(String str:interest){
        System.out.println(str);
      }
    }
    String name=req.getParameter("name");
    System.out.println("name"+name);

    double bmi=Double.parseDouble(weight)/
        Double.parseDouble(height)/
        Double.parseDouble(height);
    resp.setContentType("text/html;charset=utf-8");
    resp.getWriter().println("你的Bmi指数是:"+bmi);
  }
}

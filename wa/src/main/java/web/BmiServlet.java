package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BmiServlet extends HttpServlet {
  private static final long serialVersionUID=1L;

  private  int min;
  private int max;

  @Override
  public void init() throws ServletException {
    ServletConfig config=getServletConfig();
    min=Integer.parseInt(config.getInitParameter("min"));
    max=Integer.parseInt(config.getInitParameter("max"));
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String height=req.getParameter("height");
    String weight=req.getParameter("weight");

    double bmi=Double.parseDouble(weight)/
        Double.parseDouble(height)/
        Double.parseDouble(height);
    String status="体重正常";
    if(bmi<min){
      status="体重过轻";
    }
    if(bmi>max){
      status="体重过重";
    }

    req.setAttribute("bmi",bmi);
    req.setAttribute("status",status);
    req.getRequestDispatcher("view.jsp").forward(req,resp);

  }
}

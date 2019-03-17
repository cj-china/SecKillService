package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
  public static void addCookie(String name,String value,int age,String path,
                               HttpServletResponse response) throws UnsupportedEncodingException {
    Cookie c=new Cookie(name, URLEncoder.encode(value,"utf-8"));
    c.setMaxAge(age);
    c.setPath(path);
    response.addCookie(c);
  }

  public static String findCookie(String name, HttpServletRequest request) throws UnsupportedEncodingException {
    String value=null;
    Cookie[] cookies=request.getCookies();
    if(cookies!=null){
      for(Cookie c:cookies){
        String name1=c.getName();
        if(name1.equals(name)){
          value= URLDecoder.decode(c.getValue(),"utf-8");
        }
      }
    }
    return value;
  }

  public static void deleteCookie(String name, String path, HttpServletResponse response){
    Cookie c=new Cookie(name,"");
    c.setMaxAge(0);
    c.setPath(path);
    response.addCookie(c);
  }
}

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/27
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
          for(Cookie c:cookies){
            out.println(c.getName()+":"+c.getValue()+"<br>");
          }
        }
    %>
</body>
</html>

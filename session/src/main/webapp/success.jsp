<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/27
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Object obj=session.getAttribute("user");
        if(obj==null){
          response.sendRedirect("login.jsp");
          return;
        }
    %>
登录成功
</body>
</html>

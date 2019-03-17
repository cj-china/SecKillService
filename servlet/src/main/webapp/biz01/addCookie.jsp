<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/27
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie c=new Cookie("interest","snooker");
        c.setPath("/servlet");
        response.addCookie(c);
    %>
</body>
</html>

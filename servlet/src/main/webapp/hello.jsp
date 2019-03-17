<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/26
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    time:<%=new Date()%>
<%
    for(int i=0;i<10;i++){
      out.println("<h1>Hello Kitty</h1>");
    }
%>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/28
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-size: 30px">
    <%
        pageContext.setAttribute("username","Giving");
    %>
    <%=pageContext.getAttribute("username")%>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/28
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bmi</title>
</head>
<body>
    BMI指数：
    <%=request.getAttribute("bmi")%><br>
    身体状态：
    <%=request.getAttribute("status")%>
</body>
</html>

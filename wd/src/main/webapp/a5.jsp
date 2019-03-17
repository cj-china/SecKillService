<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/28
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String qty =
            request.getParameter("qty");
    int total =
            Integer.parseInt(qty) + 100;
    out.println(total);
%>

</body>
</html>

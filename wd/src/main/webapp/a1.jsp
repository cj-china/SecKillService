<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/28
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="font-size:30px">
    <%!
        int i=100;
        int sum(int a1,int a2){
          return a1+a2;
        }
    %>
    <%=i+100%>
    <br>
    <%=sum(1,1)%>
</body>
</html>

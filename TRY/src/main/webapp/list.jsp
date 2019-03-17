<%@ page import="entity.A" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/27
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="green solid 1px" cellpadding="0">
        <tr>
            <td>ID</td>
            <td>Lead_ID</td>
            <td>Team_ID</td>
            <td>Home_Price</td>
        </tr>
        <%
            List<A> as=(List<A>) request.getAttribute("as");
            for(int i=0;i<as.size();i++){
              A a=as.get(i);
              %>
        <tr>
            <td><%=a.getId()%></td>
            <td><%=a.getLeadName()%></td>
            <td><%=a.getTeamID()%></td>
            <td><%=a.getHomePrice() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>

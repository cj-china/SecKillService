<%@ page import="dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/26
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    div{
        border: black solid 1px;
    }
</style>
<html>
<head>
    <title>listUsers</title>
</head>
<body>
    <div id="wrap">
        <div id="top_content">
            <div id="header">
                <div id="rightheader">
                    <p>2009/11/20</p>
                </div>
                <div id="topheader">
                    <h1 id="title">
                        <a href="#">主页</a>
                    </h1>
                </div>
                <div id="navigation">
                </div>
            </div>
            <div id="content">
                <p id="whereami"></p>
                <h1>
                    我是渣渣
                </h1>
                <table class="table">
                    <tr class="table_header">
                        <td>ID</td>
                        <td>用户名</td>
                        <td>密码</td>
                        <td>邮箱</td>
                        <td>操作</td>
                    </tr>
                    <%
                        UserDAO dao=new UserDAO();
                        List<User> users=dao.findAll();
                        for(int i=0;i<users.size();i++){
                          User user=users.get(i);
                          %>
                    <tr class="row<%=i%2+1%>">
                        <td>
                            <%=user.getId()%>
                        </td>
                        <td>
                            <%=user.getUsername()%>
                        </td>
                        <td>
                            <%=user.getPwd()%>
                        </td>
                        <td>
                            <%=user.getEmail()%>
                        </td>
                        <td><a href="#">删除</a></td>
                    </tr>
                        <%
                        }
                    %>
                </table>
                <p>
                    <input type="button" class="button" value="添加用户"
                           onclick="location='addUser.jsp'">
                </p>
            </div>
        </div>
        <div id="footer">
            <div id="footer_bg">
                ABC@123.COM
            </div>
        </div>
    </div>
</body>
</html>

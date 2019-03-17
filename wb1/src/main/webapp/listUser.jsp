<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/28
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <%
                        Date date=new Date();
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    %>
                    <%=sdf.format(date)%>
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                用户列表
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        用户名
                    </td>
                    <td>
                        密码
                    </td>
                    <td>
                        邮箱
                    </td>
                    <td>
                        操作
                    </td>
                </tr>
                <%
                    List<User> users =
                            (List<User>)request.getAttribute(
                                    "users");
                    for(int i = 0; i < users.size(); i++){
                        User user = users.get(i);
                %>
                <tr class="row<%=i % 2 + 1%>">
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
                    <td>
                        <a href="del.do?id=<%=user.getId()%>"
                           onclick="return confirm('确定删除<%=user.getUsername()%>吗?');">删除</a>&nbsp;
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <p>
                <input type="button" class="button"
                       value="注册用户"
                       onclick="location='addUser.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>

</body>
</html>

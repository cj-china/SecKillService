<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/2/28
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css"
          href="css/style.css" />
</head>
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
                    <a href="#">主页</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                登录
            </h1>
            <form action="login.do" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            用户名
                        </td>
                        <td valign="middle" align="left">
                            <input type="text"
                                   class="inputgri"
                                   name="username" />
                            <%
                                String msg =
                                        (String)request.getAttribute(
                                                "login_failed");
                            %>
                            <span style="color:red;font-size:24px;">
										<%=msg == null ? "" : msg%>
									</span>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                           密码
                        </td>
                        <td valign="middle" align="left">
                            <input type="password"
                                   class="inputgri" name="pwd" />
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit"
                           class="button" value="确定 &raquo;" />
                </p>
            </form>
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

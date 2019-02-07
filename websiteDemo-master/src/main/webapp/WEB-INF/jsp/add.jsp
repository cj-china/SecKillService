<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 18-7-9
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增学生成绩</title>
</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath }/addScore" method="post">
    <table border=1>
        <tr>
            <td>学生姓名</td>
            <td><input type="text" name="name" value="${item.name }"/></td>
        </tr>
        <tr>
            <td>课程</td>
            <td><input type="text" name="course" value="${item.course}"/></td>
        </tr>
        <tr>
            <td>分数</td>
            <td><input type="text" name="score" value="${item.score}"/></td>
        </tr
        <tr>
           <td><input type="submit" value="提交成绩"/></td>
        </tr
    </table>

</form>
</body>
</html>

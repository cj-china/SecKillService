<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 18-7-9
  Time: 上午10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->

<html>
<head>
    <title>学生信息详情页</title>
</head>
<body>
     --姓名--课程--成绩<br>
     <c:forEach items="${stuList}" var="item">
         --${item.name}--${item.course}--${item.score}<br>
     </c:forEach>
</body>
</html>

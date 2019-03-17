<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 18-7-9
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->

<html>
<head>
    <title>秒杀商品信息</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<table border="1">
    <tr>
        <td>商品名称</td>
        <td>商品单价</td>
        <td>秒杀单价</td>
        <td>商品库存</td>

    </tr>
    <c:forEach items="${secKillInfo}" var="item" varStatus="idx">
        <tr>
            <td>${item.goods_name}</td>
            <td>${item.goods_price}</td>
            <td>${item.miaosha_price}</td>
            <td>${item.stock_count}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

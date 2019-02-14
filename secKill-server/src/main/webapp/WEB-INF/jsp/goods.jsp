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
    <title>商品信息</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<table border="1">
    <tr>
        <td>id</td>
        <td>商品名称</td>
        <td>商品类型</td>
        <td>商品图片</td>
        <td>商品详情</td>
        <td>商品单价</td>
        <td>商品库存</td>
    </tr>
    <c:forEach items="${goods}" var="item" varStatus="idx">
        <tr>
            <td>${item.id}</td>
            <td>${item.goods_name}</td>
            <td>${item.goods_title}</td>
            <td>${item.goods_img}</td>
            <td>${item.goods_detail}</td>
            <td>${item.goods_price}</td>
            <td>${item.goods_stock}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

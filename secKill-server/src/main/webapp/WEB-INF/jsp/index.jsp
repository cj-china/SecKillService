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
        // $(document).ready(function () {
        //     $("#but").click(function () {
        //         $.ajax({
        //                    type: "GET",
        //                    url: "/seckill?id=1",
        //                    contentType: "application/json; charset=utf-8",
        //                    dataType: "json",//表示后台返回的数据是json对象
        //                    success: function (data) {
        //                        $("#stock").eq(0).html(data);
        //                    },
        //                    error: function (error) {
        //                        alert("error=" + error);
        //                    }
        //         });
        //     });
        // });
        function reduceStock(id, index, count){

            $.ajax({
                       type: "GET",
                       url: "/seckill?id=" + id,
                       contentType: "application/json; charset=utf-8",
                       dataType: "json",//表示后台返回的数据是json对象
                       success: function (data) {
                           if(count>=1){
                               $("#stock"+index).eq(0).html(data);
                           }else{
                               $("#stock"+index).eq(0).html(0);
                               alert(" 该商品已经售罄");
                           }


                       },
                       error: function (error) {
                           alert("error=" + error);
                       }
             });
        }
    </script>
</head>
<body>
    <table border="1">
        <tr>
            <td>id</td>
            <td>商品id</td>
            <td>秒杀价</td>
            <td>库存数量</td>
            <td>抢购</td>
            <td>开始时间</td>
            <td>结束时间</td>
        </tr>
        <c:forEach items="${secKillGoods}" var="item" varStatus="idx">
            <tr>
                <td>${item.id}</td>
                <td>${item.goods_id}</td>
                <td>${item.miaosha_price}</td>
                <td id="stock${idx.index}">${item.stock_count}</td>
                <td><input type="button" value="确定" id= "but"
                           onclick="reduceStock(${item.id}, ${idx.index},${item.stock_count})"></td>
                <td>${item.start_date}</td>
                <td>${item.end_date}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

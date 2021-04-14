<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Janus II
  Date: 2020/7/7
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
<table border="1" cellspacing="0px" cellpadding="4px">
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>价格</th>
        <th>销量</th>
        <th>库存</th>
        <th>描述</th>
    </tr>
    <%--    在网页上显示查询到的信息--%>

    <c:forEach items="${commodityList}" var="commodity">
        <tr>
            <td>${commodity.id }</td>
            <td>${commodity.name } </td>
            <td>${commodity.price }</td>
            <td>${commodity.sales }</td>
            <td>${commodity.stock }</td>
            <td>${commodity.descs }</td>
        </tr>
    </c:forEach>

</table>

<input type="button" value="返回" onclick="location.href='commodity?mode=search&keyword=全部 '">

</body>
</html>

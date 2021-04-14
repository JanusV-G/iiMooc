<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Janus II
  Date: 2020/7/6
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="UTF-8">
    <title>商品信息</title>
</head>

<body>

<script src="js/jquery-3.5.1.min.js"></script>

<form action="commodity?mode=search" method="post" id="findCommodity">
    <h1>商品查找: &nbsp;</h1>
    <select id="keyword" name="keyword" onfocus="setInputProperty()">
        <option>ID</option>
        <option>名称</option>
        <option>价格</option>
        <option>销量</option>
        <option>库存</option>
        <option>描述</option>
        <option>全部</option>
    </select>
    <input type="number" id="message" name="message" />
    <input type="button" value="查找" onclick="submitFind()" />
    <font color=red><span id="hint"></span></font>
</form>
<br />
<br />
<form action="commodity?mode=add" method="post" id="addCommodity">
    <h1>商品添加:</h1>
    <p>名称: <input type="text" id="name" name="name" />
        <font color=red><span name="addHint" id="hint1"></span></font>
    </p>
    <p>价格: <input type="number" id="price" name="price" />
        <font color=red><span name="addHint" id="hint2"></span></font>
    </p>
    <p>销量: <input type="number" id="sales" name="sales" />
        <font color=red><span name="addHint" id="hint3"></span></font>
    </p>
    <p>库存: <input type="number" id="stock" name="stock" />
        <font color=red><span name="addHint" id="hint4"></span></font>
    </p>
    <p>描述: <input type="text" id="descs" name="descs" />
        <font color=red><span name="addHint" id="hint5"></span></font>
    </p>
    <p><input type="button" value="添加" onclick="submitAdd()" /> </p>
</form>
<h1>查找到的商品信息</h1>
<table border="1" cellspacing="0px" cellpadding="4px">
    <tr>
        <th>ID</th>
        <th>名称</th>
        <th>价格</th>
        <th>销量</th>
        <th>库存</th>
        <th>描述</th>
        <th>操作</th>
    </tr>
    <%--    在网页上显示查询到的信息--%>
    <c:forEach items="${commodityList }" var="commodity">
        <tr>
            <td>${commodity.id }</td>
            <td><input type="text" name="tr${commodity.id }" value="${commodity.name }" /> </td>
            <td><input type="number" name="tr${commodity.id }" value="${commodity.price }" /></td>
            <td><input type="number" name="tr${commodity.id }" value="${commodity.sales }" /></td>
            <td><input type="number" name="tr${commodity.id }" value="${commodity.stock }" /></td>
            <td><input type="text" name="tr${commodity.id }" value="${commodity.descs }" /></td>
            <td>&nbsp;<input type="button" value="详情" id="detailsButton" name="detailsButton" onclick="location.href='commodity?mode=detail&id='+${commodity.id }"/>&nbsp;
                <input type="button" value="修改" id="editButton" name="editButton" onclick="submitUpdate(${commodity.id})" /> &nbsp;
                <input type="button" value="删除" id="deleteButton" name="deleteButton" onclick="submitDelete(${commodity.id})" /> &nbsp; </td>
        </tr>
    </c:forEach>

</table>
</body>

<script>
    //根据查找的商品属性, 实时调整输入框的type类型
    function setInputProperty() {
        console.log("set");
        var keywords = document.getElementById("keyword");
        var message = document.getElementById("message");
        switch(keywords.value) {
            case "ID":
            case "价格":
            case "销量":
            case "库存":
            {
                message.type = "number";
                break;
            }
            case "名称":
            case "描述":
            {
                message.type = "text";
            }
        }
    }
    //提交find表单
    function submitFind() {
        var keywords = document.getElementById("keyword");
        var message = document.getElementById("message");
        var findForm = document.getElementById("findCommodity");
        //清空提示
        document.getElementById("hint").innerHTML = "";
        //检测input是否为空, "全部"时例外
        if(keywords.value != "全部") {
            if(message.value == "" || message.value == null) {
                document.getElementById("hint").innerHTML = "查询的信息不能为空";
            } else {
                findForm.submit();
            }
        } else {
            findForm.submit();
        }
    }

    //提交add表单
    function submitAdd() {
        //			console.log("submitAdd");
        //获取input元素
        var hints = document.getElementsByName("addHint");
        var name = document.getElementById("name");
        var price = document.getElementById("price");
        var sales = document.getElementById("sales");
        var stock = document.getElementById("stock");
        var descs = document.getElementById("descs");

        //清空提示:
        for(var i = 0; i < hints.length; ++i) {
            hints[i].innerHTML = "";
        }
        //验证input是否为空
        if(name.value == "" || name.value == null) {
            hints[0].innerHTML = "名称不能为空";
        } else if(price.value == "" || price.value == null) {
            hints[1].innerHTML = "价格不能为空";
        } else if(sales.value == "" || sales.value == null) {
            hints[2].innerHTML = "销量不能为空";
        } else if(stock.value == "" || stock.value == null) {
            hints[3].innerHTML = "库存不能为空";
        } else if(descs.value == "" || descs.value == null) {
            hints[4].innerHTML = "描述不能为空";
        } else {
            //提交表单
            var addform = document.getElementById("addCommodity");
            addform.submit();
        }
    }

    function submitDelete(deleteId) {
        var flag = confirm("确认删除?");
        if(flag) {
            console.log(deleteId);
            window.location.href = 'commodity?mode=delete&id='+deleteId;
        }

    }

    function submitUpdate(IdUpdate){
        console.log("submitUpdate");
        var ci=document.getElementsByName("tr"+IdUpdate);
        console.log('commodity?mode=update&id='+ IdUpdate +'&name=' + ci[0].value +
            '&price=' + ci[1].value + '&sales=' + ci[2].value + '&stock=' + ci[3].value + '&descs=' + ci[4].value);
        location.href='commodity?mode=update&id='+ IdUpdate +'&name=' + ci[0].value +
            '&price=' + ci[1].value + '&sales=' + ci[2].value + '&stock=' + ci[3].value + '&descs=' + ci[4].value;
    }

</script>



</html>
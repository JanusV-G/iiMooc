<%--
  Created by IntelliJ IDEA.
  User: Janus II
  Date: 2020/7/6
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册账户</title>
</head>

<body>
<form action="user?mode=regist" method="post" id="UserForm">
    <table width="400px">
        <tr align="center">
            <td>账号:</td>
            <td><input type="text" name="name" id="name" value="" onblur="checkUName()" /></td>
            <td>
                <font color="red"><span id="CheckMSG_UName"></span></font>
            </td>
        </tr>
        <tr align="center">
            <td>密码:</td>
            <td><input type="password" name="pwd" id="pwd" value="" onblur="checkUPD()" /> </td>
            <td>
                <font color="red"><span id="CheckMSG_PD"></span></font>
            </td>
        </tr>
        <tr align="center">
            <td>确认密码:</td>
            <td><input type="password" name="pwdCheck" id="pwdCheck" value="" onblur="checkUPD2()" /> </td>
            <td>
                <font color="red"><span id="CheckMSG_PD2"></span></font>
            </td>
        </tr>
        <tr align="center">
            <td colspan="3"><input type="button" value="注册" onclick="checkBoth()" /> </td>
        </tr>
    </table>
</form>
</body>

<script>
    function checkUName() {
        var uname = document.getElementById("name");
        var unameValue = uname.value;
        document.getElementById("CheckMSG_UName").innerHTML = "";

        if(unameValue == "" || unameValue == null) {
            document.getElementById("CheckMSG_UName").innerHTML = "账号不能为空";
            return false;
        }
        return unameValue;
    }

    function checkUPD() {
        var upd = document.getElementById("pwd");
        var updValue = upd.value;
        document.getElementById("CheckMSG_PD").innerHTML = "";
        if(updValue == "" || updValue == null) {
            document.getElementById("CheckMSG_PD").innerHTML = "密码不能为空";
            return false;
        }
        return updValue;
    }

    function checkUPD2() {
        var upd = document.getElementById("pwd");
        var updCheck = document.getElementById("pwdCheck");
        document.getElementById("CheckMSG_PD2").innerHTML = "";
        if(upd.value != updCheck.value) {
            document.getElementById("CheckMSG_PD2").innerHTML = "两次密码输入不一致";
            return false;
        }
        return true;
    }

    function checkBoth() {
        var userForm = document.getElementById("UserForm");
        if(checkUName() && checkUPD() && checkUPD2()) {
            userForm.submit();
        }
    }
</script>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //获取项目名
    String path = request.getContextPath();
    //服务器根路径:
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    //后台服务器路径:
    String backgroundPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "admin/";
    //上传的图片路径
    String picPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "image/";
//    String picPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "picture/";
    //上传的视频路径:
    String videosPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "videos/";
    //上传的资料路径:
    String dataPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "data/";

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 3 | Registration Page</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=basePath%>plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="<%=basePath%>plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=basePath%>dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="<%=basePath%>index2.html"><b>I</b>MOOC</a>
    </div>

    <div class="card">
        <div class="card-body register-card-body">
            <p class="login-box-msg">注册一个新账户</p>

<%--            <p style="display: none;" id="message">--%>
<%--                WDNMD--%>
<%--            </p>--%>

            <div style="display: none" id="message" >
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <h5><i class="icon fas fa-exclamation-triangle"></i> Alert!</h5>
                <p id="detail">WDNMD</p>
            </div>


            <form id="userForm" action="<%=basePath%>UserServlet?method=register" method="post">
                <div class="input-group mb-3">
                    <input id="nameInput" type="text" name="User_name" class="form-control" placeholder="姓名">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input id="emailInput" type="text" name="User_email" class="form-control" placeholder="电子邮件">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input id="passwordInput" type="password" name="Password" class="form-control" placeholder="密码">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input id="passwordRepeatInput" type="password" class="form-control" placeholder="重复密码">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <br/>
                <div class="margin">
                    <div class="btn-group">
                        <input type="hidden" name="User_type" id="User_type">
                        <button id="selectButton" type="button" class="btn btn-default">请选择身份</button>
                        <button type="button" class="btn btn-default dropdown-toggle dropdown-icon"
                                data-toggle="dropdown">
                            <span class="sr-only">Toggle Dropdown</span>
                            <div class="dropdown-menu" role="menu">
                                <a class="dropdown-item" onclick="student_type()">学生</a>
                                <a class="dropdown-item" onclick="teacher_type()">老师</a>
                            </div>
                        </button>
                    </div>
                </div>
                <br/>
                <div class="input-group mb-3">
                    <input id="idNumberInput" name="Student_id" type="text" class="form-control" placeholder="学工号">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                            <input type="checkbox" id="agreeTerms" name="terms" value="agree">
                            <label for="agreeTerms">
                                我同意 &nbsp; <a href="#">用户使用条款</a>
                            </label>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button id="submitButton" type="button" class="btn btn-primary btn-block">注册</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <br/>

            <%--            <div class="social-auth-links text-center">--%>
            <%--                <p>- OR -</p>--%>
            <%--                <a href="#" class="btn btn-block btn-primary">--%>
            <%--                    <i class="fab fa-facebook mr-2"></i>--%>
            <%--                    Sign up using Facebook--%>
            <%--                </a>--%>
            <%--                <a href="#" class="btn btn-block btn-danger">--%>
            <%--                    <i class="fab fa-google-plus mr-2"></i>--%>
            <%--                    Sign up using Google+--%>
            <%--                </a>--%>
            <%--            </div>--%>
            <br/>
            <a href="login.jsp" class="text-center">已经有账户? 点击登录</a>


        </div>
        <!-- /.form-box -->
    </div><!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<script src="<%=basePath%>plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=basePath%>plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>dist/js/adminlte.min.js"></script>

<script type="text/javascript">
    // $(".alert").hidden();

    function student_type() {
        $("#selectButton").html("学生");
        $("#User_type").val("学生");
    }

    function teacher_type() {
        $("#selectButton").html("老师");
        $("#User_type").val("老师");
    }

    function alretMessage(msg) {
        // $("#message").html(msg).addClass("alert alert-warning alert-dismissible").show().delay(800).fadeOut();
        $("#detail").html(msg);
        $("#message").addClass("alert alert-warning alert-dismissible").show().delay(800).fadeOut();
        // alert("WDNMD").addClass("alert alert-warning alert-dismissible").show().delay(1500).fadeOut();
        // $('<div>').appendTo('body').addClass("alert alert-warning alert-dismissible").show().delay(1500).fadeOut();
    }

    function successMessage(msg) {
        $("#detail").html(msg);
        $("#message").addClass("alert alert-success alert-dismissible").show().delay(800).fadeOut();
    }

    function notNull(string) {
        if (string == null || string == "") {
            return false;
        } else {
            return true;
        }
    }

    $("#submitButton").click(function () {
        // location.href="login.jsp";
        //邮箱验证的正则表达式:
        var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        //依次验证各个input项
        if (!notNull($("#nameInput").val())) {
            alretMessage("姓名不能为空");
        } else if (!notNull($("#emailInput").val())) {
            alretMessage("邮箱不能为空");
        }else if(!reg.test($("#emailInput").val())){
            alretMessage("邮箱格式不正确");
        } else if (!notNull($("#passwordInput").val())) {
            alretMessage("密码不能为空");
        }else if($("#passwordInput").val().toString().length<8){
            alretMessage("密码至少为8位");
        } else if (!notNull($("#passwordRepeatInput").val())) {
            alretMessage("请重复输入密码");
        } else if ($("#passwordInput").val() != $("#passwordRepeatInput").val()) {
            alretMessage("两次输入的密码不一致");
        }else if($("#selectButton").html()=="请选择身份"){
            alretMessage("请选择您的身份");
        }else if (!notNull($("#idNumberInput").val())) {
            alretMessage("学工号不能为空");
        } else if($("#agreeTerms").prop("checked")!=true) {
            alretMessage("请同意用户使用条款");
        }else{
            $.ajax({
                url: "UserServlet",
                data: {"method": "checkEmail", "email": $("#emailInput").val()},
                type: "post",
                dataType: "text",
                success: function (data) {
                    if (data == "true") {
                        console.log("邮箱可用: " + $("#emailInput").val());
                        $("#userForm").submit();
                    } else if (data == "false") {
                        alretMessage("邮箱已注册");
                    } else {
                        console.log("异常data: " + data);
                    }
                }
            });
        }
    });

</script>

</body>
</html>

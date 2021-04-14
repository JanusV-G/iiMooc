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
    <title>登录页面</title>
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
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="<%=basePath%>index2.html"><b>I</b>MOOC</a>
    </div>
    <!-- /.login-logo -->
    <div class="card">
        <div class="card-body login-card-body">
            <p class="login-box-msg" id="msg">登录以开始你的学习之旅！</p>

            <form id="form" method="post" action="UserServlet?method=login_user">
                <div class="input-group mb-3">
                    <input type="email" class="form-control" placeholder="邮箱" name="email" id="email">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope" id="email_msg"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" placeholder="密码" name="password" id="password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock" id="password_msg"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="icheck-primary">
                          <!--   <input type="checkbox" id="remember">
                            <label for="remember">
                                记住我
                            </label> -->
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block" id="btn">登录</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <!-- /.social-auth-links -->

            <p class="mb-1">
                <a href="forgot-password.jsp">忘记密码</a>
            </p>
            <p class="mb-0">
                <a href="register.jsp" class="text-center">注册新用户</a>
            </p>
        </div>
        <!-- /.login-card-body -->
    </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="<%=basePath%>plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=basePath%>plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>dist/js/adminlte.min.js"></script>

<script type="text/javascript">
    var email_flag,password_flag;

    //邮箱非空，且存在
    $("#email").blur(function(){
        //清空错误提示消息
        $("#msg").html("");

        //获取邮箱文本框的值
        var email = $(this).val();

        //非空验证
        if($.trim(email).length == 0){
            $("#msg").html("邮箱不能为空！").css("color","red");
            email_flag=false;
            return;
        }
        
      	//邮箱验证的正则表达式:
        var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
        if(!reg.test(email)){
        	$("#msg").html("邮箱格式错误！").css("color","red");
        	email_flag=false;
        	return;
        }
        
        
        //判断邮箱是否存在
        $.ajax({
            url: "UserServlet",
            data: {"method": "checkEmail", "email": email},
            type: "post",
            dataType: "text",
            success: function (data) {
                if (data == "true") {
                	$("#msg").html("邮箱不存在！").css("color","red");
                	email_flag=false;
                } else if (data == "false") {
                	$("#msg").html("可用邮箱").css("color","green");
                    email_flag = true;
                } else {
                    console.log("异常data: " + data);
                    email_flag=false;
                }
            }
        });

    });

    //密码非空且不低于8位
    $("#password").blur(function(){
        //清空错误提示消息
        $("#msg").html("");

        //获取姓名文本框的值
        var password = $(this).val();

        //非空验证
        if($.trim(password).length == 0){
            $("#msg").html("密码不能为空！").css("color","red");
            password_flag=false;
            return;
        }
        
        //不低于8位
        if($.trim(password).length < 8){
            $("#msg").html("密码不能低于8位！").css("color","red");
            password_flag=false;
            return;
        }
        password_flag=true;
    });

    //单击登录按钮提交表单
    $("#btn").click(function(){
        if(email_flag&&password_flag){
            $("form").submit();
        }
    });
</script>

</body>
</html>
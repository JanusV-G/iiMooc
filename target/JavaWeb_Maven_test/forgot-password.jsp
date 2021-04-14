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
    <title>忘记密码</title>
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
            <p class="login-box-msg" id="msg">忘记密码了？在这里你可以轻松重置你的密码！</p>

            <form action="UserServlet?method=searchEmail" method="post">
                <div class="input-group mb-3">
                    <input id="email" name="email" type="email" class="form-control" placeholder="邮箱">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <button id="btn" type="submit" class="btn btn-primary btn-block">申请一个新的密码</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <p class="mt-3 mb-1">
                <a href="login.jsp">登录</a>
            </p>
            <p class="mb-0">
                <a href="register.jsp" class="text-center">注册一个新的账号</a>
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
	var email_flag;

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
	
	//单击找回按钮提交表单
    $("#btn").click(function(){
        if(email_flag){
            $("form").submit();
        }
    });
	
</script>

</body>
</html>

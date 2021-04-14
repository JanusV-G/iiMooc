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
    <title>重置密码</title>
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
            <p class="login-box-msg" id="msg">请重置你的密码</p>
            <form action="UserServlet?method=changePassword" method="post">
                <div class="input-group mb-3">
                    <input type="password" class="form-control" placeholder="密码" id="password" name="password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="input-group mb-3">
                    <input type="password" class="form-control" placeholder="确认密码" id="confirm_password">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <button type="submit" class="btn btn-primary btn-block" id="btn">重置密码</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

            <p class="mt-3 mb-1">
                <a href="login.jsp">登录</a>
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
	var password_flag,confirm_flag;
	
	//密码非空
	$("#password").blur(function(){
    	//清空错误提示消息
    	$("#msg").html("");
	
    	//获取文本框的值
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
	
	//确认密码非空且与密码一致验证
	$("#confirm_password").blur(function(){
		if(password_flag){
	    	//清空错误提示消息
	    	$("#msg").html("");
		
	    	//获取文本框的值
	    	var password = $("#password").val();
	    	var confirm_password = $(this).val();
		
	    	//非空验证
	    	if($.trim(password).length == 0){
	        	$("#msg").html("确认密码不能为空！").css("color","red");
	        	confirm_flag=false;
	        	return;
	    	}
	    	
	    	if(password != confirm_password){
	    		$("#msg").html("确认密码与密码不一致！").css("color","red");
	    		confirm_flag=false;
	        	return;
	    	}else{
	    		confirm_flag=true;
	    	}
		}else{
			confirm_flag=false;
		}

	});
	
	//单击找回按钮提交表单
    $("#btn").click(function(){
        if(password_flag&&confirm_flag){
            $("form").submit();
        }
    });
	
	
	
</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <title>添加用户 | 后台管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=basePath%>plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=basePath%>dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini layout-boxed">
<c:if test="${empty login_user}" >
                    <script>
                        alert("用户未登录!");
                        location.href="<%=basePath%>login.jsp";
                    </script>
                </c:if>
<!-- Site wrapper -->
<div class="wrapper">
    <!-- Navbar -->
    <nav class="main-header navbar navbar-expand navbar-white navbar-light">
        <!-- Left navbar links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="<%=basePath%>admin/boxed.jsp" class="nav-link">Home</a>
            </li>
        </ul>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
        </ul>
    </nav>
    <!-- /.navbar -->
   <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="<%=basePath%>admin/boxed.jsp" class="brand-link">
            <img src="<%=basePath%>dist/img/AdminLTELogo.png"
                 alt="imooc Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">imooc</span>
        </a>

        <!-- Sidebar -->
        <div class="sidebar">
            <!-- Sidebar user (optional) -->
            <div class="user-panel mt-3 pb-3 mb-3 d-flex">
                <c:if test="${!empty login_user}" >
                    <div class="image">
                        <img src="<%=picPath%>${sessionScope.login_user.user_photo}" class="img-circle elevation-2" alt="User Image">
                    </div>
                    <div class="info">
                        <a href="<%=basePath%>userProfile.jsp" class="d-block">${sessionScope.login_user.user_name}</a>
                    </div>
                </c:if>
                <c:if test="${empty login_user}" >
                    <div class="image">
                        <img src="<%=picPath%>DefaultUserAccountPictures.jpg" class="img-circle elevation-2" alt="User Image">
                    </div>
                    <div class="info">
                        <a href="<%=basePath%>login.jsp" class="d-block">未登录</a>
                    </div>
                    <script>
                        alert("用户未登录!");
                        location.href="<%=basePath%>login.jsp";
                    </script>
                </c:if>
            </div>

            <!-- Sidebar Menu -->
            <nav class="mt-2">
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>用户管理
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath%>ManagerServlet?method=findAllStudents" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>学生管理</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath%>ManagerServlet?method=findAllTeachers" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>教师管理</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath%>ManagerServlet?method=findAllUsers" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>用户管理</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="<%=basePath%>ManagerServlet?method=findAllLessons" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>课程管理
                                <!-- <span class="right badge badge-danger">New</span> -->
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=basePath %>ManagerServlet?method=manageAllLm" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>学习资料管理
                                <!-- <i class="fas fa-angle-left right"></i> -->
                               <!--  <span class="badge badge-info right">6</span> -->
                            </p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-chart-pie"></i>
                            <p>作业管理
                                <i class="right fas fa-angle-left"></i> 
                            </p>
                        </a>
                         <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath %>ManagerServlet?method=manageHomeworkTeacher" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>教师发放作业</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath %>ManagerServlet?method=manageHomeworkStudent" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>学生提交作业</p>
                                </a>
                            </li>
                        </ul> 
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="<%=basePath%>ManagerServlet?method=findAllVideos"  class="nav-link">
                            <i class="nav-icon fas fa-tree"></i>
                            <p>网课管理</p>
                        </a>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                               	 考试管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath %>ManagerServlet?method=manageEndTest" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>已结束</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath %>ManagerServlet?method=manageUnendTest" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>未结束</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath %>ManagerServlet?method=manageAllTest" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>全部</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="" class="nav-link">
                            <i class="nav-icon fas fa-table"></i>
                            <p>试卷管理
                                <i class="fas fa-angle-left right"></i> 
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath %>ManagerServlet?method=manageAllProblems" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>题目管理</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath %>ManagerServlet?method=manageAllAnswers" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>答案管理</p>
                                </a>
                            </li>
             			</ul>
                    </li>
                </ul>
            </nav>
            <!-- /.sidebar-menu -->
        </div>
        <!-- /.sidebar -->
    </aside>
<!--1111111111111111111111111111111111111111111从这里开始写 1111111111111111111111111111111111111111111111111111-->
        <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>添加用户列表</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">添加用户列表</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-8">
                        <!-- general form elements -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">添加用户</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form role="form" action="<%=basePath%>ManagerServlet?method=addUser" method="post" enctype="multipart/form-data">
                                <div class="card-body">
                                    
                                    <div class="form-group">
                                    <label>用户姓名</label><span id="user_name_msg"></span>
                                    <input name="user_name" id="user_name" type="text" class="form-control" placeholder="请输入用户姓名 ...">
                                   	</div>
									
                                    <div class="form-group">
                                        <label>用户密码</label><span id="password_msg"></span>
                                        <input type="password" class="form-control" id="password" name="password"
                                               placeholder="密码由数字，大写、小写组成，且长度在8到30位之间 ...">
                                    </div>
                                    <div class="form-group">
                                    <label>电子邮箱</label><span id="user_email_msg"></span>
                                    <input type="text" id="user_email" name="user_email" class="form-control" placeholder="请输入电子邮箱   例：user@example.com ...">
                                   	</div>
                                    <div class="form-group">
                                                <label>用户类型</label><span id="user_type_msg"></span>
                                                <select id="user_type" name="user_type" class="custom-select">
                                                    <option value="0">管理员</option>
                                                    <option value="1">教师</option>
                                                    <option value="2">学生</option>
                                                </select>
                                            </div>
                                            
                                    <div class="form-group">
                                    			<label>用户班级</label><span id="user_class_msg"></span>
                                   		 <input type="text" id="user_class" name="user_class" class="form-control" placeholder="请输入用户班级 ...">
                                   	</div>
                                  	<div class="form-group">
                                    			<label>用户编号</label><span id="student_id_msg"></span>
                                   		 <input type="text" id="student_id" name="student_id" class="form-control" placeholder="请输入学生学号/教职工工号 ...">
                                   	</div>
                                   	<div class="form-group">
                                    			<label>上传头像</label><span id="user_photo_msg"></span>
                                    			&nbsp&nbsp&nbsp&nbsp
                                    			<input type="file" name="user_photo">
                                    			<span><font color="red">${msg }</font></span>
                                   	</div>
                                <div class="card-footer">
                                    <button type="button" id="btn" class="btn btn-primary">提交</button>
                                </div>
                            </form>
                        </div>
                          <!-- /.card -->
                    </div>
                    <!--/.col (right) -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
			<!--1111111111111111111111111111111111111111111到这里结束了 1111111111111111111111111111111111111111111111111111-->

    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>版本号</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2020-∞ <a href="<%=basePath%>admin/boxed.jsp">imooc</a>.</strong> All rights
        reserved.
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="<%=basePath%>plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
$("#btn").click(function(){
	if(user_name_flag&&user_class_flag&&student_id_flag&&user_email_flag&&password_flag){
		$("form").submit();
	}else{
		alert("请检查用户数据是否填写完全！");
	}
});
var user_name_flag,user_class_flag,student_id_flag,user_email_flag,password_flag;
//验证姓名的非空
$("#user_name").blur(function(){
	$("#user_name_msg").html("");
	var name = $(this).val();
	if($.trim(name).length == 0){
		$("#user_name_msg").html("姓名不能为空！").css("color","red");
		user_name_flag = false;
		return;
	}
	$("#user_name_msg").html("√").css("color","green");
	user_name_flag = true;
});

//验证邮箱非空格式与唯一性
$("#user_email").blur(function(){
	$("#user_email_msg").html("");
	var user_email = $(this).val();
	//非空验证
	if($.trim(user_email).length == 0){
		$("#user_email_msg").html("邮箱不能为空").css("color","red");
		user_email_flag=false;
		return;
	}
	//格式验证 正则表达式
	var reg=/^\w+@[a-zA-Z0-9]{2,10}(?:\.[a-z]{2,4}){1,3}$/;
	if(!(reg.test(user_email))){ 
		$("#user_email_msg").html("邮箱格式不正确").css("color","red");
		user_email_flag=false;
		return;
    }
	//唯一验证
	$.ajax({
		url:"<%=basePath%>ManagerServlet",//向后台servlet发出请求
		data:{"method":"checkEmail","user_email":user_email},
		type:"post",
		dataType:"text",
		success:function(data){
			if(data == "true"){
				$("#user_email_msg").html("该邮箱已被注册").css("color","red");
				user_email_flag=false;
			}else{
				$("#user_email_msg").html("√").css("color","green");
				user_email_flag=true;
			}
		}
	})
});
//用户编号
$("#student_id").blur(function(){
	$("#student_id_msg").html("");
	var student_id = $(this).val();
	//非空验证
	if($.trim(student_id).length==0){
		$("#student_id_msg").html("用户编号不能为空！").css("color","red");
		student_id_flag =false;
		return;
	}
	$("#student_id_msg").html("√").css("color","green");
	student_id_flag = true;
});
//用户班级
$("#user_class").blur(function(){
	$("#user_class_msg").html("");
	var user_class = $(this).val();
	//非空验证
	if($.trim(user_class).length==0){
		$("#user_class_msg").html("用户班级不能为空！").css("color","red");
		user_class_flag =false;
		return;
	}
	$("#user_class_msg").html("√").css("color","green");
	user_class_flag = true;
});

//密码的非空验证
$("#password").blur(function(){
	$("#password_msg").html("");
	var password = $(this).val();
	if($.trim(password).length==0){
		$("#password_msg").html("密码不能为空！").css("color","red");
		password_flag=false;
		return;
	}
	var reg = new RegExp('^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\W_!@#$%^&*`~()-+=]+$)(?![a-z0-9]+$)(?![a-z\W_!@#$%^&*`~()-+=]+$)(?![0-9\W_!@#$%^&*`~()-+=]+$)[a-zA-Z0-9\W_!@#$%^&*`~()-+=]{8,30}$');
	if(!(reg.test(password))){ 
		$("#password_msg").html("密码格式不正确").css("color","red");
		password_flag=false;
		return;
    }
	$("#password_msg").html("√").css("color","green");
	password_flag = true;
});
</script>
<!-- Bootstrap 4 -->
<script src="<%=basePath%>plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=basePath%>dist/js/demo.js"></script>
</body>
</html>


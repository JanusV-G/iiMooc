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
    <title>增加考试 |后台管理</title>
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
                 alt="AdminLTE Logo"
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

  <!-- Content Wrapper. Contains page content -->
   <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-10">
                    <div class="col-sm-6">
                        <h1>考试信息修改</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">考试信息修改</li>
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
                    <div class="col-md-12">
                        <!-- general form elements -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">修改信息</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form role="form" action="<%=basePath%>ManagerServlet?method=addTestTotal" method="post" onsubmit="return subcheck()">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="test_name">考试名称</label><span id="test_name_msg"></span>
                                        <input type="text" class="form-control" name="test_name" id="test_name"
                                               placeholder="不多于30个字符且不可为空">
                                    </div>
                                    <div class="form-group">
                                        <label for="lesson_name">所属课程</label><span id="lesson_name_msg"></span>
                                        <input type="text" class="form-control" name="lesson_name" id="lesson_name" 
                                               placeholder="所属课程名字不可错字漏字">
                                    </div>
                                     <div class="form-group">
                                        <label for="teacher_name">发布教师</label><span id="teacher_name_msg"></span>
                                        <input type="text" class="form-control" name="teacher_name" id="teacher_name"
                                               placeholder="发布教师的姓名">
                                    </div>
                                     <div class="form-group">
                                        <label for="test_password">考试密码</label><span id="test_password_msg"></span>
                                        <input type="text" class="form-control" name="test_password" id="test_password"
                                               placeholder="不多于30个字符且不可为空">
                                    </div>
                                     <div class="form-group">
                                        <label for="begin_time">开始时间</label><span id="begin_time_msg"></span>
                                        <input type="text" class="form-control" name="begin_time" id="begin_time"
                                               placeholder="yyyy-MM-dd HH:mm:ss">
                                    </div>
                                     <div class="form-group">
                                        <label for="end_time">结束时间</label><span id="end_time_msg"></span>
                                        <input type="text" class="form-control" name="end_time" id="end_time"
                                               placeholder="yyyy-MM-dd HH:mm:ss">
                                    </div>
                                </div>
                                <!-- /.card-body -->

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                   
                        <!-- /.card -->

                        <!-- Form Element sizes -->
                       

                            <!-- /.card-body -->
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
<!-- Bootstrap 4 -->
<script src="<%=basePath%>plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=basePath%>dist/js/demo.js"></script>
</body>
<script>
	var test_name_flag = false;
	var lesson_name_flag = false;
	var teacher_name_flag = false;
	var test_password_flag = false;
	var begin_time = false;
	var end_time = false;
	$("#test_name").blur(function(){
		$("#test_name_msg").html("");
		var test_name=$(this).val();
		if($.trim(test_name).length == 0){
			$("#test_name_msg").html(" 考试名称不能为空").css("color","red");
			test_name_flag = false;
			return ;
		}else if($.trim(test_name).length > 30){
			$("#test_name_msg").html(" 考试名称必须小于30个字符").css("color","red");
			test_name_flag = false;
			return ;
		}else{
			test_name_flag = true;
		}
	});
	$("#lesson_name").blur(function(){
		$("#lesson_name_msg").html("");
		var lesson_name=$(this).val();
		if($.trim(lesson_name).length == 0){
			$("#lesson_name_msg").html(" 所属课程名称不能为空").css("color","red");
			lesson_name_flag = false;
			return ;
		}else if($.trim(lesson_name).length > 30){
			$("#lesson_name_msg").html(" 所属课程名字必须小于30个字符").css("color","red");
			lesson_name_flag = false;
			return ;
		}else{
			lesson_name_flag = true;
		}
	});
	$("#teacher_name").blur(function(){
		$("#teacher_name_msg").html("");
		var teacher_name=$(this).val();
		if($.trim(teacher_name).length == 0){
			$("#teacher_name_msg").html(" 教师姓名不能为空").css("color","red");
			teacher_name_flag = false;
			return ;
		}else if($.trim(teacher_name).length > 30){
			$("#teacher_name_msg").html(" 教师姓名必须小于30个字符").css("color","red");
			teacher_name_flag = false;
			return ;
		}else{
			teacher_name_flag = true;
		}
	});
	$("#test_password").blur(function(){
		$("#test_password_msg").html("");
		var test_password=$(this).val();
		if($.trim(test_password).length == 0){
			$("#test_password_msg").html(" 考试密码不能为空").css("color","red");
			test_password_flag = false;
			return ;
		}else if($.trim(test_password).length > 30){
			$("#test_password_msg").html(" 考试密码必须小于30个字符").css("color","red");
			test_password_flag = false;
			return ;
		}else{
			test_password_flag = true;
		}
	});
	$("#begin_time").blur(function(){
		$("#begin_time_msg").html("");
		var begin_time=$(this).val();
		if($.trim(begin_time).length == 0){
			$("#begin_time_msg").html(" 开始时间不能为空").css("color","red");
			begin_time_flag = false;
			return ;
		}
		 var regex=/^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;
		 if(!regex.test(begin_time)){
			 $("#begin_time_msg").html(" 时间格式不正确需为yyyy-MM-dd HH:mm:ss").css("color","red");
				begin_time_flag = false;
				return ;
		 }
		 begin_time_flag = true;
	});
	$("#end_time").blur(function(){
		$("#end_time_msg").html("");
		var end_time=$(this).val();
		if($.trim(end_time).length == 0){
			$("#end_time_msg").html(" 结束时间不能为空").css("color","red");
			end_time_flag = false;
			return ;
		}
		 var regex=/^(?:19|20)[0-9][0-9]-(?:(?:0[1-9])|(?:1[0-2]))-(?:(?:[0-2][1-9])|(?:[1-3][0-1])) (?:(?:[0-2][0-3])|(?:[0-1][0-9])):[0-5][0-9]:[0-5][0-9]$/;
		 if(!regex.test(end_time)){
			 $("#end_time_msg").html(" 时间格式不正确需为yyyy-MM-dd HH:mm:ss").css("color","red");
			 	end_time_flag = false;
				return ;
		 }
		 end_time_flag = true;
	});
	function subcheck(){
		if(!test_name_flag){
			alert("请正确填写考试名称");
			return false;
		}else if(!lesson_name_flag){
			alert("请正确填写所属课程名称");
			return false;
		}else if(!teacher_name_flag){
			alert("请正确填写教师姓名");
			return false;
		}else if(!test_password_flag){
			alert("请正确填写考试密码");
			return false;
		}else if(!begin_time_flag){
			alert("请正确填写开始时间");
			return false;
		}else if(!end_time_flag){
			alert("请正确填写结束时间");
			return false;
		}else{
			return true;
		}
	}
</script>
</html>


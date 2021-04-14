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
    <title>修改课程 | 后台管理</title>
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
<!--1111111111111111111111111111111111111111111从这里开始写 1111111111111111111111111111111111111111111111111111-->
        <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>修改课程</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">修改课程</li>
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
                                <h3 class="card-title">修改课程</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <form role="form" action="<%=basePath%>ManagerServlet?method=updateLesson" method="post" enctype="multipart/form-data">
                                <div class="card-body">
                                    <div class="form-group">
                                    <label>课程名称</label><span id="lesson_name_msg"></span>
                                    <input name="lesson_name" id="lesson_name" type="text" class="form-control"  value="${lesson.lesson_name }" placeholder="请输入课程名称 ...">
                                   	</div>
                                   	<input type="hidden" name="lesson_id" value="${lesson.lesson_id }"/>
                                   	<input type="hidden" name="lesson_create_time " value="${lesson.lesson_create_time }"/>
									<div class="form-group">
                                                <label>授课教师姓名</label><span id="teacher_name_msg"></span>
                                                <select id="teacher_name" name="teacher_name" class="custom-select">
                                                    <option value="">==请选择教师==</option>          
                                                    <c:forEach items="${name}" var="name">
                                                    <option value="${name}">${name}
                                                    </option>
                                                    </c:forEach>
                                                </select>
                                    </div>
                                   <div class="form-group">
                                    <label>学生数量</label><span id="students_number_msg"></span>
                                    <input name="students_number" id="students_number" type="text" class="form-control" value="${lesson.students_number }" placeholder="请输入学生数量 ...">
                                   	</div>
                                    
                                    <div class="form-group">
                                    			<label>修改课程封面图片</label><span id="lesson_photo_msg"></span>
                                    			&nbsp&nbsp&nbsp&nbsp
                                    			<input type="file" name="lesson_photo">
                                    			<span><font color="red">${msg }</font></span>
                                   	</div>
                                   	<div class="form-group">
                                    <label>课程描述</label><span id="description_msg"></span>
                                    <input name="description" id="description" type="text" value="${lesson.description }"  class="form-control" placeholder="请输入课程描述 ...">
                                   	</div>
                                   <div class="form-group">
                                                <label>课程状态</label><span id="flag_msg"></span>
                                                <select id="flag" name="flag" class="custom-select">
                                                    <option value="">==请选择结课状态==</option>
                                                    <option value="0">未结课</option>     
                                                    <option value="1">已结课</option>
                                                </select>
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
	if(teacher_name_flag&&students_number_flag&&description_flag&&lesson_name_flag){
		$("form").submit();
	}else{
		alert("请检查网课视频数据是否填写完全！");
	}
});
var teacher_name_flag,students_number_flag,description_flag,lesson_name_flag,videos_number_flag,flag_flag;
$("#students_number").blur(function(){
	$("#students_number_msg").html("");
	var num = $(this).val();
	if($.trim(num).length == 0){
		$("#students_number_msg").html("学生数量不能为空！").css("color","red");
		students_number_flag = false;
		return;
	}
	$("#students_number_msg").html("√").css("color","green");
	students_number_flag = true;
});
//teacher
$("#teacher_name").blur(function(){
	$("#teacher_name_msg").html("");
	var teacher_name = $(this).val();
	//非空验证
	if($.trim(teacher_name).length==0){
		$("#teacher_name_msg").html("教师姓名不能为空！").css("color","red");
		teacher_name_flag =false;
		return;
	}
	$("#teacher_name_msg").html("√").css("color","green");
	teacher_name_flag = true;
});
//课程
$("#lesson_name").blur(function(){
	$("#lesson_name_msg").html("");
	var lesson_name = $(this).val();
	//非空验证
	if($.trim(lesson_name).length==0){
		$("#lesson_name_msg").html("课程名称不能为空！").css("color","red");
		lesson_name_flag =false;
		return;
	}
	$("#lesson_name_msg").html("√").css("color","green");
	lesson_name_flag = true;
});
//描述
$("#description").blur(function(){
	$("#description_msg").html("");
	var description= $(this).val();
	//非空验证
	if($.trim(description).length==0){
		$("#description_msg").html("描述不能为空！").css("color","red");
		description_flag =false;
		return;
	}
	$("#description_msg").html("√").css("color","green");
	description_flag = true;
});
//状态
$("#flag").blur(function(){
	$("#flag_msg").html("");
	var flag = $(this).val();
	//非空验证
	if($.trim(flag).length==0){
		$("#flag_msg").html("课程状态不能为空！").css("color","red");
		flag_flag =false;
		return;
	}
	$("#flag_msg").html("√").css("color","green");
	flag_flag = true;
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


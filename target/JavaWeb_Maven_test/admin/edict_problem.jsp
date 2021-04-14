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
    String iconPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/xmpic/";
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>题目修改 | 后台管理</title>
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
                        <h1>题目修改</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">首页</a></li>
                            <li class="breadcrumb-item active">题目修改</li>
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
                            <form role="form" action="<%=basePath%>ManagerServlet?method=edictProblem&test_id=${problem.test_id }&problem_number=${problem.problem_number }" method="post" enctype="multipart/form-data">
                                <div class="card-body">
                                	<div class="form-group">
                                        <label for="nproblem_number">题目序号</label><span id="nproblem_number_msg"></span>
                                        <input type="text" class="form-control" name="nproblem_number" id="nproblem_number"
                                               value="${problem.problem_number }">
                                    </div>
                                    <div class="form-group">
                                        <label for="problem_type">题目类别</label><span id="problem_type_msg"></span><br>
                                        <input type="radio" name="problem_type" value="1" <c:if test="${problem.problem_type == 1 }"> checked="checked" </c:if>/>选择题<br>
                                       <input type="radio" name="problem_type" value="2" <c:if test="${problem.problem_type == 2 }"> checked="checked"</c:if>/>填空题<br>
                                       <input type="radio" name="problem_type" value="3" <c:if test="${problem.problem_type == 3 }"> checked="checked"</c:if>/>大题<br>
                                    </div>
                                     <div class="form-group">
                                        <label for="problem_photo">题目照片</label><span id="problem_photo_msg"></span>
                                        <input type="file"  name="problem_photo" id="problem_photo"
                                               value="${problem.problem_photo }">
                                               <img src="<%=iconPath%>${problem.problem_photo }" width="60px" height="60px"/>
                                    </div>
                                     <div class="form-group">
                                        <label for="problem_answer">题目答案（可不填）</label><span id="problem_answer_msg"></span>
                                        <input type="text" class="form-control" name="problem_answer" id="problem_answer"
                                               value="${problem.problem_answer }">
                                    </div>
                                     <div class="form-group">
                                        <label for="problem_score">题目分值</label><span id="problem_score_msg"></span>
                                        <input type="text" class="form-control" name="problem_score" id="problem_score"
                                               value="${problem.problem_score }">
                                    </div>
                                
                                </div>
                                <!-- /.card-body -->

                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary" id="sub">Submit</button>
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
<script type="text/javascript">

</script>
</html>


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
    <title>imooc | Project Add</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=basePath%>plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- overlayScrollbars -->
    <link rel="stylesheet" href="<%=basePath%>dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
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
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Project Add</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Project Add</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-6">
                    <div class="card card-primary">
                        <div class="card-header">
                            <h3 class="card-title">General</h3>

                            <div class="card-tools">
                                <button type="button" class="btn btn-tool" data-card-widget="collapse"
                                        data-toggle="tooltip" title="Collapse">
                                    <i class="fas fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="inputName">Project Name</label>
                                <input type="text" id="inputName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="inputDescription">Project Description</label>
                                <textarea id="inputDescription" class="form-control" rows="4"></textarea>
                            </div>
                            <div class="form-group">
                                <label for="inputStatus">Status</label>
                                <select class="form-control custom-select">
                                    <option selected disabled>Select one</option>
                                    <option>On Hold</option>
                                    <option>Canceled</option>
                                    <option>Success</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="inputClientCompany">Client Company</label>
                                <input type="text" id="inputClientCompany" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="inputProjectLeader">Project Leader</label>
                                <input type="text" id="inputProjectLeader" class="form-control">
                            </div>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
                <div class="col-md-6">
                    <div class="card card-secondary">
                        <div class="card-header">
                            <h3 class="card-title">Budget</h3>

                            <div class="card-tools">
                                <button type="button" class="btn btn-tool" data-card-widget="collapse"
                                        data-toggle="tooltip" title="Collapse">
                                    <i class="fas fa-minus"></i></button>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="inputEstimatedBudget">Estimated budget</label>
                                <input type="number" id="inputEstimatedBudget" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="inputSpentBudget">Total amount spent</label>
                                <input type="number" id="inputSpentBudget" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="inputEstimatedDuration">Estimated project duration</label>
                                <input type="number" id="inputEstimatedDuration" class="form-control">
                            </div>
                        </div>
                        <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <a href="#" class="btn btn-secondary">Cancel</a>
                    <input type="submit" value="Create new Porject" class="btn btn-success float-right">
                </div>
            </div>
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
</html>

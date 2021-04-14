<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>

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
    <title>IMOOC | 我的</title>
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
<body class="hold-transition sidebar-mini layout-navbar-fixed">
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
                <a href="<%=basePath%>StudentServlet?method=searchAllActiveLesson" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">

            </li>
        </ul>

        <!--         SEARCH FORM
                <form class="form-inline ml-3">
                    <div class="input-group input-group-sm">
                        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                        <div class="input-group-append">
                            <button class="btn btn-navbar" type="submit">
                                <i class="fas fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form> -->

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">

                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">

                            <div class="media-body">

                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">

                            <div class="media-body">

                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">

                            <div class="media-body">

                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>

                </div>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">

                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">

                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
                    <i class="fas fa-th-large"></i>
                </a>
            </li>
        </ul>
    </nav>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <aside class="main-sidebar sidebar-dark-primary elevation-4">
        <!-- Brand Logo -->
        <a href="<%=basePath%>main.jsp" class="brand-link elevation-4">
            <img src="<%=basePath%>dist/img/AdminLTELogo.png"
                 alt="AdminLTE Logo"
                 class="brand-image img-circle elevation-3"
                 style="opacity: .8">
            <span class="brand-text font-weight-light">IMOOC</span>
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
                <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu"
                    data-accordion="false">
                    <!-- Add icons to the links using the .nav-icon class
                         with font-awesome or any other icon font library -->
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link active">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                我的课程
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath%>StudentServlet?method=searchAllActiveLesson" class="nav-link active">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>进行中</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath%>StudentServlet?method=searchAllStopLesson" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>已结课</p>
                                </a>
                            </li>

                        </ul>
                    </li>
                    <li class="nav-item">
                        <a href="StudentServlet?method=showAllLesson" class="nav-link">
                            <i class="nav-icon fas fa-th"></i>
                            <p>
                                全部课程
                                <span class="right badge badge-danger">New</span>
                            </p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=basePath%>userProfile.jsp" class="nav-link">
                            <i class="nav-icon fas fa-copy"></i>
                            <p>
                                我的
                            </p>
                        </a>
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
                        <h1>课程详情 :</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">课程详情</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">

                        <!-- Profile Image -->
                        <div class="card card-primary card-outline">
                            <div class="card-body box-profile">
                                <div class="text-center">
                                    <img class="profile-user-img img-fluid img-circle"
                                         src="<%=picPath%>${lesson.lesson_photo}"
                                         alt="User profile picture">
                                </div>

                                <h3 class="profile-username text-center">${lesson.lesson_name }</h3>

                                <p class="text-muted text-center">${lesson.teacher_name }</p>

                                <ul class="list-group list-group-unbordered mb-3">
                                    <li class="list-group-item">
                                        <b>课容量</b> <a class="float-right">1,322</a>
                                    </li>
                                    <li class="list-group-item">
                                        <b>已选人数</b> <a class="float-right">543</a>
                                    </li>
                                    <li class="list-group-item">
                                        <b>剩余容量</b> <a class="float-right">13,287</a>
                                    </li>
                                </ul>

                                <!-- <a href="#" class="btn btn-primary btn-block"><b>Follow</b></a> -->
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->

                        <!-- About Me Box -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">关于</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <strong><i class="fas fa-book mr-1"></i> 授课时间</strong>

                                <p class="text-muted">
                                    输入时间
                                </p>

                                <hr>

                                <strong><i class="fas fa-map-marker-alt mr-1"></i> 教师地址</strong>

                                <p class="text-muted">中国地质大学，北京</p>

                                <hr>

                                <strong><i class="fas fa-pencil-alt mr-1"></i> 授课要求</strong>

                                <p class="text-muted">
                                    <span class="tag tag-danger">无</span>
                                    <!--  <span class="tag tag-success">Coding</span>
                                     <span class="tag tag-info">Javascript</span>
                                     <span class="tag tag-warning">PHP</span>
                                     <span class="tag tag-primary">Node.js</span> -->
                                </p>

                                <hr>

                                <strong><i class="far fa-file-alt mr-1"></i> 授课环境</strong>

                                <p class="text-muted">IMOOC</p>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                    <div class="col-md-9">
                        <div class="card">
                            <div class="card-header p-2">
                                <ul class="nav nav-pills">

                                    <li class="nav-item"><a class="nav-link" href="#settings"
                                                            data-toggle="tab">课程详情</a></li>
                                </ul>
                            </div><!-- /.card-header -->
                            <div class="card-body">
                                <div class="tab-content">
                                    <input type="hidden" id="lessonID" value="${lesson.lesson_id}" >
                                    <div class="active tab-pane" id="settings">
                                        <form action="UserServlet?method=changeUserInfo" method="post" id="userForm"
                                              class="form-horizontal" role="form" enctype="multipart/form-data">
                                            <div class="form-group row">
                                                <label for="inputName" class="col-sm-2 col-form-label"
                                                       align="center">课程名称</label>
                                                <div class="col-sm-10">
                                                    <input type="email" class="form-control" id="inputName"
                                                           placeholder="Name" disabled="disabled"
                                                           value="${lesson.lesson_name }">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="inputEmail" class="col-sm-2 col-form-label"
                                                       align="center">授课老师</label>
                                                <div class="col-sm-10">
                                                    <input type="email" class="form-control" id="inputEmail"
                                                           placeholder="Email" disabled="disabled"
                                                           value="${lesson.teacher_name }">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="inputEmail" class="col-sm-2 col-form-label"
                                                       align="center">学生数量</label>
                                                <div class="col-sm-10">
                                                    <input type="email" class="form-control" id="studentNumber"
                                                           placeholder="Email" disabled="disabled"
                                                           value="${lesson.students_number }">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="inputName2" class="col-sm-2 col-form-label"
                                                       align="center">网课视频数量</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputName2"
                                                           placeholder="Name" disabled="disabled"
                                                           value="${lesson.videos_number }">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="inputExperience"
                                                       class="col-sm-2 col-form-label" align="center">课程描述</label>
                                                <div class="col-sm-10">
                                                    <textarea class="form-control" id="inputExperience"
                                                              placeholder="Experience" disabled="disabled"
                                                              >${lesson.description }</textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="inputSkills" class="col-sm-2 col-form-label"
                                                       align="center">创建时间</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputSkills"
                                                           placeholder="Skills" disabled="disabled"
                                                           value="${lesson.lesson_create_time }">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <div  class="offset-sm-2 col-sm-10">
                                                    <button id="selectButton" type="button" onclick="location.href='StudentServlet?method=courseSelection&lesson_id=${lesson.lesson_id}'" ></button>
<%--                                                    <button type="submit" class="btn btn-block btn-success">确定选课</button>--%>
                                                </div>
                                            </div>

                                        </form>
                                    </div>
                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div><!-- /.card-body -->
                        </div>

                        <!-- /.nav-tabs-custom -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <footer class="main-footer">
        <div class="float-right d-none d-sm-block">
            <b>Version</b> 3.0.5
        </div>
        <strong>Copyright &copy; 2014-2019 <a href="http://adminlte.io">AdminLTE.io</a>.</strong> All rights
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

<script>
    $.ajax({
        url:"Lesson_selectedServlet",
        data: {"method": "checkSelect","lesson_id":$("#lessonID").val()},
        type:"post",
        dataType: "text",

        success: function (data) {
            if(data=="selected"){
                $("#selectButton").addClass("btn btn-block btn-secondary disabled").html("已选课");
            }else if(data=="finished"){
                $("#selectButton").addClass("btn btn-block btn-secondary disabled").html("已结课");
            }else if(data=="unselected"){
                $("#selectButton").addClass("btn btn-block btn-success").html("选课");
            }else{
                console.log("异常data: "+data);
            }
        }
    });
</script>

</body>
</html>

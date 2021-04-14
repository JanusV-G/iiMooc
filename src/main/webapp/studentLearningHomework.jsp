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
    <title>IMOOC | 我的课程</title>
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
<%--这里是使用ionicon图标所必须的东西, 如果icon未显示, 则需要下载一下--%>
<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>

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
        </ul>



        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">

            <%--            todo: 添加菜单:--%>

            <li class="nav-item d-none d-sm-inline-block">
                <a href="<%=basePath%>StudentServlet?method=showLearningMain&lessonID=${sessionScope.lessonNow.lesson_id}"
                   class="nav-link">首页</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="<%=basePath%>StudentServlet?method=showLearningMaterial" class="nav-link">资料</a>
            </li>
            <%--            <li class="nav-item d-none d-sm-inline-block">--%>
            <%--                <a href="<%=basePath%>studentLearningMessage.jsp" class="nav-link">通知</a>--%>
            <%--            </li>--%>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="<%=basePath%>StudentServlet?method=showLearningHomework" class="nav-link">作业</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="<%=basePath%>StudentServlet?method=showLearningExam" class="nav-link">考试</a>
            </li>
            <%--            <li class="nav-item d-none d-sm-inline-block">--%>
            <%--                <a href="<%=basePath%>studentLearningDiscussion.jsp" class="nav-link">讨论</a>--%>
            <%--            </li>--%>

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
                        <h1>${sessionScope.lessonNow.lesson_name}</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="<%=basePath%>StudentServlet?method=searchAllActiveLesson">Home</a></li>
                            <li class="breadcrumb-item"><a href="<%=basePath%>StudentServlet?method=searchAllActiveLesson">我的课程</a></li>
                            <li class="breadcrumb-item active">作业</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <!-- /.card -->

                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">作业</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
<%--                                todo: --%>
<%--                                <button type="button" class="btn btn-block btn-success" onclick="batchDelete()">--%>
<%--                                <ion-icon name="cloud-download"></ion-icon>--%>
<%--                                下载选中的文件--%>
<%--                            </button>--%>
                                <table id="example1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
<%--                                        <th><input name="chkall" type="checkbox" value="" id="chkall"/></th>--%>
                                        <th>作业名称</th>
                                        <th>上传者</th>
                                        <th>在线预览</th>
                                        <th>文件描述</th>
                                        <th>上传时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${homework_teacherList }" var="homework">
                                        <tr>
<%--                                            <th><input name="chk" type="checkbox" value="${homework.lm_id }"--%>
<%--                                                       id="chk" class="chk"/></th>--%>
                                            <td>${homework.homework_name }</td>
                                            <td>${homework.teacher_name }</td>
                                            <td><img src="<%=picPath%>${homework.homework_file }"
                                                     width="30px" height="30px"/></td>
                                            <td>${homework.homework_description }</td>
                                            <td>${homework.homework_create_time }</td>
                                            <td>
													<a href="<%=basePath %>Homework_studentServlet?method=showHomeworkById&homework_id=${homework.homework_id }">作业详情</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.card-body -->

                        </div>
                        <!-- /.card -->
<%--                        &nbsp;&nbsp;&nbsp;&nbsp;--%>
                        <div class="btn-group" >
                            <button type="button" class="btn btn-default">首页</button>
                            <button type="button" class="btn btn-default">上一页</button>
                            <button type="button" class="btn btn-default">下一页</button>
                            <button type="button" class="btn btn-default">尾页</button>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>

<%--        <a href="<%=basePath%>Learning_materialsServlet?method=findmaterial&currentPage=1">首页</a>--%>
<%--        <a href="<%=basePath%>Learning_materialsServlet?method=findmaterial&currentPage=${tool.prePage }">上一页</a>--%>
<%--        <a href="<%=basePath%>Learning_materialsServlet?method=findmaterial&currentPage=${tool.nextPage }">下一页</a>--%>
<%--        <a href="<%=basePath%>Learning_materialsServlet?method=findmaterial&currentPage=${tool.totalPages }">尾页</a>--%>
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
    //全选全部选
    $("#chkall").click(function () {
        $(".chk").prop("checked", $(this).prop("checked"));
    });
    $(".chk").click(function () {
        var flag = $(this).prop("checked");
        if (!flag) {
            $("#chkall").prop("checked", false);
        }
    });




</script>

</body>
</html>

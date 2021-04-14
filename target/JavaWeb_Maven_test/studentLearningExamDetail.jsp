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
    <title>考试详情</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="<%=basePath%>plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=basePath%>dist/css/adminlte.min.css">
    <!-- summernote -->
    <link rel="stylesheet" href="<%=basePath%>plugins/summernote/summernote-bs4.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
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
                            <li class="breadcrumb-item active">考试</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>


        <!-- ////////////////////////////////////////////////////////////////////// -->
        <table id="preNex">
            <!-- 这里写域 然后后面的图片要替换！！！ -->
            <c:forEach items="${testList }" var="test">
                <form id="form_${test.problem_id}" action="Test_paperServlet?method=submitTest" method="post"
                      enctype="multipart/form-data">
                    <input type="hidden" name="test_id" value="${test.test_id}">
                    <div class="col-md-9">
                        <div class="card card-primary card-outline">
                            <div class="card-header">
                                <h3 class="card-title">
                                    <c:if test="${test.problem_type==1}">选择题</c:if>
                                    <c:if test="${test.problem_type==2}">填空题</c:if>
                                    <c:if test="${test.problem_type==3}">简答题</c:if>

                                </h3>
                            </div>

                            <input type="hidden" name="problem_number" value="${test.problem_number}">
                            <!-- /.card-header -->
                            <div class="card-body">

                                <div class="form-group">
                                    <img src="<%=picPath%>${test.problem_photo}" width=100% height=100%>
                                </div>

                                <div class="form-group">
                                    <textarea name="string_answer" id="text_${test.problem_id}"
                                              class="form-control"></textarea>
                                </div>
                                <div class="form-group">
                                    <div class="btn btn-default btn-file">
                                        <i class="fas fa-paperclip"></i> 添加附件
                                        <input id="attachment_${test.problem_id}" type="file" name="pic_answer">
                                    </div>
                                    <p class="help-block">最大32MB</p>
                                </div>
                            </div>
                            <!-- /.card-body -->
                            <div class="card-footer">
                                <div class="float-right">
                                        <%--                                        <button type="button" class="btn btn-default"><i class="fas fa-pencil-alt"></i>--%>
                                        <%--                                            保存草稿--%>
                                        <%--                                        </button>--%>
                                    <button type="submit" class="btn btn-primary" name="btn" id="btn_${test.problem_id}"
                                            onclick="changeButton($(this).prop('id'))"><i
                                            class="far fa-envelope"></i> 提交
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </c:forEach>
        </table>
        <!-- /////////////////////////////////////////////////////////////////////////// -->

        <!-- /.card-footer -->
    </div>
    <!-- /.card -->
    <%--</div>--%>
    <%--<!-- /.col -->--%>
    <%--</div>--%>
    <%--<!-- /.row -->--%>
    <%--</div><!-- /.container-fluid -->--%>
    <%--</section>--%>
    <%--<!-- /.content -->--%>
    <%--</div>--%>
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
<%--<script src="<%=basePath%>plugins/jquery/jquery.min.js"></script>--%>
<!-- Bootstrap 4 -->
<script src="<%=basePath%>plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=basePath%>dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=basePath%>dist/js/demo.js"></script>
<!-- Summernote -->
<script src="<%=basePath%>plugins/summernote/summernote-bs4.min.js"></script>
<!-- Page Script -->
<script>
    $(function () {
        //Add text editor
        $('#compose-textarea').summernote()
    })
</script>
<script src="/static/js/jquery.dataTables.min.js">

    $(function () {
        $('#preNex').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });


</script>

<%--添加最新的jQuery包--%>
<script type="text/javascript" src="plugins/jQuery3.3.1/jquery-3.1.1.js"></script>
<%--添加jQueryForm插件, 用于表单的异步提交--%>
<script type="text/javascript" src="plugins/jQueryForm/jquery.form.js"></script>

<script>
    //按钮点击函数
    function changeButton(buttonID) {
        console.log("buttonID:" + buttonID);
        //点击提交后时按钮变灰, 限制只能提交一次
        document.getElementById(buttonID).setAttribute("disabled", true);
        $("#" + buttonID).html("已提交");
        //从buttonID中截取出testID
        var testID = buttonID.substring(4);
        //获取到当前题目的表单, 并执行异步提交
        $("#form_" + testID).ajaxSubmit(function () {
            }
        );

    }
</script>

</body>
</html>
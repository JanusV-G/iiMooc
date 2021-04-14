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
    <title>IMOOC | 我的题目</title>
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
                <a id="click" class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="<%=basePath%>index3.html" class="nav-link">Home</a>
            </li>
            <li class="nav-item d-none d-sm-inline-block">
                <a href="#" class="nav-link">Contact</a>
            </li>
        </ul>

        <!-- SEARCH FORM -->
        <form class="form-inline ml-3">
            <div class="input-group input-group-sm">
                <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
                <div class="input-group-append">
                    <button class="btn btn-navbar" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>

        <!-- Right navbar links -->
        <ul class="navbar-nav ml-auto">
            <!-- Messages Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-comments"></i>
                    <span class="badge badge-danger navbar-badge">3</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="<%=basePath%>dist/img/user1-128x128.jpg" alt="User Avatar"
                                 class="img-size-50 mr-3 img-circle">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Brad Diesel
                                    <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">Call me whenever you can...</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="<%=basePath%>dist/img/user8-128x128.jpg" alt="User Avatar"
                                 class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    John Pierce
                                    <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">I got your message bro</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <!-- Message Start -->
                        <div class="media">
                            <img src="<%=basePath%>dist/img/user3-128x128.jpg" alt="User Avatar"
                                 class="img-size-50 img-circle mr-3">
                            <div class="media-body">
                                <h3 class="dropdown-item-title">
                                    Nora Silvester
                                    <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                                </h3>
                                <p class="text-sm">The subject goes here</p>
                                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
                            </div>
                        </div>
                        <!-- Message End -->
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
                </div>
            </li>
            <!-- Notifications Dropdown Menu -->
            <li class="nav-item dropdown">
                <a class="nav-link" data-toggle="dropdown" href="#">
                    <i class="far fa-bell"></i>
                    <span class="badge badge-warning navbar-badge">15</span>
                </a>
                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
                    <span class="dropdown-item dropdown-header">15 Notifications</span>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-envelope mr-2"></i> 4 new messages
                        <span class="float-right text-muted text-sm">3 mins</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-users mr-2"></i> 8 friend requests
                        <span class="float-right text-muted text-sm">12 hours</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item">
                        <i class="fas fa-file mr-2"></i> 3 new reports
                        <span class="float-right text-muted text-sm">2 days</span>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
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
<%--        todo: 点击后跳转到主页(主页还没做)--%>
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
                        <a href="" class="nav-link">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                            <p>
                                  		课程管理
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath%>insertcourse.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>添加课程</p>
                                </a>
                            </li>
                            
                                <li class="nav-item">
                                <a href="<%=basePath%>LessonServlet?method=findLesson&teacher_name=${login_user.user_name }" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>我的课程</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                  
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link ">
                            <i class="nav-icon fas fa-tachometer-alt"></i>
                             <p>
                                	资料管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath %>insertlm.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>上传资料</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath %>Learning_materialsServlet?method=findmaterial&teacher_name=${login_user.user_name }" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>我的资料</p>
                                </a>
                            </li>                  
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-chart-pie"></i>
                            <p>
                               	 考试管理
                                <i class="right fas fa-angle-left"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath%>inserttest_total.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>新建考试</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath%>Test_totalServlet?method=findTesk_Total&teacher_name=${login_user.user_name }" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>我的试题</p>
                                </a>
                            </li>
                                <li class="nav-item">
                                <a href="<%=basePath%>Homework_teacherServlet?method=findexambytname" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>试卷批改</p>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-tree"></i>
                            <p>
                                	视频管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                <a href="<%=basePath%>insertvideo.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>新建视频</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath%>VideoServlet?method=findVideo&teacher_name=${login_user.user_name }" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>我的视频</p>
                                </a>
                            </li>                                                                   
                        </ul>
                    </li>
                    <li class="nav-item has-treeview">
                        <a href="#" class="nav-link">
                            <i class="nav-icon fas fa-edit"></i>
                            <p>
                            		    作业管理
                                <i class="fas fa-angle-left right"></i>
                            </p>
                        </a>
                        <ul class="nav nav-treeview">
                            <li class="nav-item">
                                  <a href="<%=basePath %>uploadhomework.jsp" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>上传作业</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath%>Homework_teacherServlet?method=findhomework" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>我的作业</p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="<%=basePath%>Homework_teacherServlet?method=findstuhomeworkbytname" class="nav-link">
                                    <i class="far fa-circle nav-icon"></i>
                                    <p>作业批改</p>
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
                        <h1>我的题目:</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="index_teacher.jsp">主页</a></li>
                            <li class="breadcrumb-item active">我的题目</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="card card-solid">
                <div class="card-body pb-0">
                    <div class="row d-flex align-items-stretch">
		<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>
              <button type="button" class="btn btn-block btn-success" onclick="batchDelete()">
    		   <ion-icon name="trash-outline"></ion-icon>
                                    	删除题目
                </button>               
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                   <th><input name="chkall" type="checkbox" value=""  id="chkall"/></th>
                    <th>题目编号</th>
                    <th>题目类型</th>
                    <th>题目内容</th>
                    <th>题目答案</th>
                    <th>题目分数</th>
                  </tr>                 
                  </thead>
                  <tbody>
                    <c:forEach items="${tests }" var="test">              
                  	<tr>
                  	 <th><input name="chk" type="checkbox" value="${test.problem_number }"  id="chk" class="chk"/></th>
                  	 <td>${test.problem_number }</td>
                    <td>
                    <c:if test="${test.problem_type==1 }">选择题</c:if>
                    <c:if test="${test.problem_type==2 }">填空题</c:if>
                    <c:if test="${test.problem_type==3 }">简答题</c:if>
  					 </td>
  					 <td>${test.problem_photo }</td>
  					 <td>${test.problem_answer }</td>
  					 <td>${test.problem_score }</td>              
                  </tr>
                  </c:forEach>  
                 </tbody>
                </table>
                </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                    <nav aria-label="Contacts Page Navigation">
                        <ul class="pagination justify-content-center m-0">
                            <ul class="pagination justify-content-center m-0">
                            <li class="page-item active"><a href="<%=basePath%>TestServlet?method=findTesk&currentPage=1">首页&nbsp&nbsp</a></li>
                            <li class="page-item"><a href="<%=basePath%>TestServlet?method=findTesk&currentPage=${tool.prePage }">上一页&nbsp&nbsp</a></li>
                            <li class="page-item"><a href="<%=basePath%>TestServlet?method=findTesk&currentPage=${tool.nextPage }">下一页&nbsp&nbsp</a></li>
                            <li class="page-item"><a href="<%=basePath%>TestServlet?method=findTesk&currentPage=${tool.totalPages }">尾页&nbsp&nbsp</a></li>                 
                        </ul>
                    </nav>
                </div>
                <!-- /.card-footer -->
            </div>
            <!-- /.card -->

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
<script type="text/javascript">
setTimeout(function() {
	if(document.all) {
	document.getElementById("click").click();
	}
	else {
	var e = document.createEvent("MouseEvents");
	e.initEvent("click", true, true);
	document.getElementById("click").dispatchEvent(e);
	}
	}, 0);
function tempFun() {
    alert("WDNMD");
	}
  $(function () {
    $("#example1").DataTable({
      "responsive": true,
      "autoWidth": false,
    });
 
  });
//全选全部选
  $("#chkall").click(function(){
  	$(".chk").prop("checked",$(this).prop("checked"));
  })	
  $(".chk").click(function(){
  	var flag=$(this).prop("checked")
  	if(!flag){
  		$("#chkall").prop("checked",false);
  	}
  })
  //批量删除
  function batchDelete(){
  	//拼接删除的条件
  	var tids="";
  	//冒号过滤选择器,each循环遍历
  	$(".chk:checked").each(function(){
  		tids+=","+$(this).val();
  	})
  	//非空验证
  	if(tids==""){
  		alert("请选择要删除的项");
  		//return不往下走了
  		return;
  	}
  	//截取字符串
  	tids=tids.substring(1);
  	if(confirm("是否确定删除？")){
  		window.location.href="<%=basePath%>TestServlet?method=deleteTest&tids="+tids;
  	}
  }
</script>
</body>
</html>

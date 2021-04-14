package com.cugb.servlet;

import com.cugb.entity.User;
import com.cugb.service.UserService;
import com.cugb.utils.FileUploadTool;
import com.sun.xml.internal.txw2.Document;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/UserServlet")
@MultipartConfig
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService us=new UserService();
	String email;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理中文乱码问题
		//1、请求乱码
		request.setCharacterEncoding("UTF-8");
		//2、响应乱码
		response.setContentType("text/html;charset=UTF-8");
		//获取页面提交过来的请求数据
		String method = request.getParameter("method");
		//分流:
		switch (method){
			case "checkEmail":{
				checkEmail(request,response);
				break;
			}
			case "register":{
				register(request,response);
				break;
			}
			case "login_user":{
				login_user(request,response);
				break;
			}
			case "searchEmail":{
				searchEmail(request,response);
				break;
			}
			case "changePassword":{
				changePassword(request,response);
				break;
			}
			case "changeUserInfo":{
				changeUserInfo(request,response);
				break;
			}
			case "userLogout":{
				userLogout(request,response);
			}
			default:{
				System.out.println(this.getClass().getName()+"异常method: "+method);
			}
		}
	}

	private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(this.getClass().getName()+" userLogout");
		//强制session失效, 以清除所有数据:
		request.getSession().invalidate();
		//重新跳回管理员登录界面:
		response.sendRedirect("login.jsp");
	}

	//修改用户信息,更新后存域
	private void changeUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(this.getClass().getName()+" changeUserInfo");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("login_user");
		//获取值
		int user_id=user.getUser_id();
		String user_name = request.getParameter("user_name");
		String student_id = request.getParameter("student_id");
		String user_email = request.getParameter("user_email");
		String user_photo=null;
		Part part = request.getPart("user_photo");
		if(user_name.length()==0){
			user_name=user.getUser_name();
		}
		if(student_id.length()==0){
			student_id=user.getStudent_id();
		}
		if(user_email.length()==0){
			user_email=user.getUser_email();
		}
		if(part.getSize()==0){
			user_photo=user.getUser_photo();
		}else{
			user_photo = FileUploadTool.FileUpload("profile.jsp", part, request, response);
		}

		//封装
		User newUser = new User(user_name, student_id, user_email, user_photo,user_id);

		System.out.println(this.getClass().getName()+"newUser: "+user_name+student_id+user_email+user_photo);

		//调用方法
		boolean flag = us.changeUserInfo(newUser);
		System.out.println(this.getClass().getName()+" flag="+flag);
		if(flag) {
			us.UpdateSessionById(newUser.getUser_id(),request);
			response.sendRedirect("login.jsp");
		}

	}

	//根据邮箱修改密码
	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取值
		String password = request.getParameter("password");

		//调用方法
		boolean flag = us.changePassword(email,password);

		if(flag) {
			response.sendRedirect("login.jsp");
		}else {
			System.out.println("修改密码失败");
		}

	}

	//寻找邮箱并保存
	private void searchEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取值
		email = request.getParameter("email");

		//跳转
		response.sendRedirect("recover-password.jsp");

	}

	//用户登录验证
	private void login_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取账号密码
		String user_email = request.getParameter("email");
		String password = request.getParameter("password");

		//获取session对象
		HttpSession session = request.getSession();

		//调用方法
		int flag = us.checkUser(user_email, password,session);
		switch (flag) {
			case 0:{
				response.sendRedirect("admin/boxed.jsp");
				break;
			}
			case 1:{
				response.sendRedirect("StudentServlet?method=searchAllActiveLesson");
				break;
			}
			case 2:{
				//response.sendRedirect("index_teacher.jsp");
				response.sendRedirect("LessonServlet?method=findAllLesson");
				break;
			}
			case 3:{
				response.sendRedirect("login.jsp");
				break;
			}
			default:{
				response.sendRedirect("login.jsp");
				break;
			}

		}

	}

	//新用户注册:
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//debug:
		System.out.println(this.getClass().getName()+" register");
		//获取表单数据
		String User_name=request.getParameter("User_name");
		String User_email=request.getParameter("User_email");
		String Password=request.getParameter("Password");
		int User_type=request.getParameter("User_type").equals("学生")?1:2;
		String Student_id=request.getParameter("Student_id");
		//默认的用户头像文件名:
		String User_photo="DefaultUserAccountPictures.jpg";
		//封装:
		User newUser = new User(User_name, User_type, Student_id, User_email, Password,User_photo);
		//调用service层进行添加:
		int row=us.addUser(newUser);
		//返回结果
		//如果成功添加则直接跳转到login界面, 失败则跳回register界面
		if(row==1){
			System.out.println(this.getClass().getName()+" 添加用户成功, 影响"+row+"行");
			response.sendRedirect("login.jsp");
		}else{
			System.out.println(this.getClass().getName()+" 添加用户出错, 影响"+row+"行");
			response.sendRedirect("register.jsp");
		}

	}


	//检测邮箱是否已存在:
	private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//debug:
		System.out.println(this.getClass().getName()+" checkEmail");
		//获得参数
		String email=request.getParameter("email");
		//获取标识并判断
		boolean flag=us.checkEmail(email);
		if(flag){
			System.out.println(this.getClass().getName()+" 邮箱有效");
			response.getWriter().print("true");
		}else{
			System.out.println(this.getClass().getName()+" 邮箱以被注册");
			response.getWriter().print("false");
		}

	}



}
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
		//����������������
		//1����������
		request.setCharacterEncoding("UTF-8");
		//2����Ӧ����
		response.setContentType("text/html;charset=UTF-8");
		//��ȡҳ���ύ��������������
		String method = request.getParameter("method");
		//����:
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
				System.out.println(this.getClass().getName()+"�쳣method: "+method);
			}
		}
	}

	private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(this.getClass().getName()+" userLogout");
		//ǿ��sessionʧЧ, �������������:
		request.getSession().invalidate();
		//�������ع���Ա��¼����:
		response.sendRedirect("login.jsp");
	}

	//�޸��û���Ϣ,���º����
	private void changeUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(this.getClass().getName()+" changeUserInfo");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("login_user");
		//��ȡֵ
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

		//��װ
		User newUser = new User(user_name, student_id, user_email, user_photo,user_id);

		System.out.println(this.getClass().getName()+"newUser: "+user_name+student_id+user_email+user_photo);

		//���÷���
		boolean flag = us.changeUserInfo(newUser);
		System.out.println(this.getClass().getName()+" flag="+flag);
		if(flag) {
			us.UpdateSessionById(newUser.getUser_id(),request);
			response.sendRedirect("login.jsp");
		}

	}

	//���������޸�����
	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��ȡֵ
		String password = request.getParameter("password");

		//���÷���
		boolean flag = us.changePassword(email,password);

		if(flag) {
			response.sendRedirect("login.jsp");
		}else {
			System.out.println("�޸�����ʧ��");
		}

	}

	//Ѱ�����䲢����
	private void searchEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��ȡֵ
		email = request.getParameter("email");

		//��ת
		response.sendRedirect("recover-password.jsp");

	}

	//�û���¼��֤
	private void login_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��ȡ�˺�����
		String user_email = request.getParameter("email");
		String password = request.getParameter("password");

		//��ȡsession����
		HttpSession session = request.getSession();

		//���÷���
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

	//���û�ע��:
	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//debug:
		System.out.println(this.getClass().getName()+" register");
		//��ȡ������
		String User_name=request.getParameter("User_name");
		String User_email=request.getParameter("User_email");
		String Password=request.getParameter("Password");
		int User_type=request.getParameter("User_type").equals("ѧ��")?1:2;
		String Student_id=request.getParameter("Student_id");
		//Ĭ�ϵ��û�ͷ���ļ���:
		String User_photo="DefaultUserAccountPictures.jpg";
		//��װ:
		User newUser = new User(User_name, User_type, Student_id, User_email, Password,User_photo);
		//����service��������:
		int row=us.addUser(newUser);
		//���ؽ��
		//����ɹ������ֱ����ת��login����, ʧ��������register����
		if(row==1){
			System.out.println(this.getClass().getName()+" ����û��ɹ�, Ӱ��"+row+"��");
			response.sendRedirect("login.jsp");
		}else{
			System.out.println(this.getClass().getName()+" ����û�����, Ӱ��"+row+"��");
			response.sendRedirect("register.jsp");
		}

	}


	//��������Ƿ��Ѵ���:
	private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//debug:
		System.out.println(this.getClass().getName()+" checkEmail");
		//��ò���
		String email=request.getParameter("email");
		//��ȡ��ʶ���ж�
		boolean flag=us.checkEmail(email);
		if(flag){
			System.out.println(this.getClass().getName()+" ������Ч");
			response.getWriter().print("true");
		}else{
			System.out.println(this.getClass().getName()+" �����Ա�ע��");
			response.getWriter().print("false");
		}

	}



}
package com.cugb.servlet;

import com.cugb.entity.Lesson;
import com.cugb.entity.User;
import com.cugb.service.LessonService;
import com.cugb.service.Lesson_selectedService;
import com.cugb.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Lesson_selectedServlet")
public class Lesson_selectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Lesson_selectedService lss=new Lesson_selectedService();
	private static LessonService ls=new LessonService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������������
		//1����������
		request.setCharacterEncoding("UTF-8");
		//2����Ӧ����
		response.setContentType("text/html;charset=UTF-8");
		//��ȡҳ���ύ��������������
		String method = request.getParameter("method");

		switch (method){
			case "checkSelect":{
				checkSelect(request,response);
				break;
			}
			default:{
				System.out.println(this.getClass().getName()+"�쳣method: "+method);
			}
		}

	}

	private void checkSelect(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//debug:
		System.out.println(this.getClass().getName()+" checkSelect");
		//��ȡ����:
		String lesson_id=request.getParameter("lesson_id");
		HttpSession session=request.getSession();
		User loginUser= (User) session.getAttribute("login_user");

		boolean flag=lss.checkSelected(Integer.toString(loginUser.getUser_id()),lesson_id);
		Lesson lesson=ls.findLessonById(lesson_id);
		if(lesson.getFlag().equals("0")){
			if(flag){
				System.out.println(this.getClass().getName()+" ��ѡ��");
				response.getWriter().print("selected");
			}else{
				System.out.println(this.getClass().getName()+" δѡ��");
				response.getWriter().print("unselected");
			}
		}else{
			System.out.println(this.getClass().getName()+" �ѽ��");
			response.getWriter().print("finished");
		}

	}

}

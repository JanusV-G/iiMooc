package com.cugb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.cugb.entity.Homework_student;
import com.cugb.entity.Homework_teacher;
import com.cugb.service.Homework_studentService;
import com.cugb.utils.FileUploadTool;

import jdk.nashorn.internal.ir.Flags;


@WebServlet("/Homework_studentServlet")
@MultipartConfig
public class Homework_studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Homework_studentService hs = new Homework_studentService();
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String method=request.getParameter("method");
		switch (method) {
		case "completeHomework":
			completeHomework(request,response);
			break;
		case "showHomeworkById":
			showHomeworkById(request,response);
		default:
			break;
		}
	}
	
	//ѧ���ϴ���ҵ��
	private void completeHomework(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Part part = request.getPart("answer");
		String submit_file = FileUploadTool.FileUpload("studentLearningHomeworkDetail.jsp", part, request, response);
		String homework_id = request.getParameter("homework_id");
		
		//����
		boolean flag = hs.updateAnswer(Integer.valueOf(homework_id),submit_file);
		if(flag) {
			response.sendRedirect("index_student.jsp");
		}else {
			System.out.println("�ϴ�ʧ��");
		}
		
		
	}

	//�����ҵչʾ��ҵ
	private void showHomeworkById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���id��תΪint����
		String homework_idString = request.getParameter("homework_id");
		int homework_id=Integer.valueOf(homework_idString);
		
		//��ȡ����
		String student_name = request.getParameter("name");
		System.out.println("student_name="+student_name);
		
		//Ѱ�Ҷ�Ӧ��ҵ
		Homework_teacher ht = hs.findHomeworkById(homework_id);
		
		//��װѧ����ҵ��
		String homework_name = ht.getHomework_name();
		String teacher_name = ht.getTeacher_name();
		Homework_student hstu = new Homework_student(student_name, homework_id, homework_name, teacher_name);
		
		//�������
		boolean flag = hs.addOrUpdateHomeworkInfo(hstu);
		if(flag) {
			System.out.println("��ӻ��޸ĳɹ�");
		}else {
			System.out.println("ʧ��");
		}
		
		//����
		request.setAttribute("pic", ht.getHomework_file());
		request.setAttribute("homework_student", hstu);
		
		//��ת
		request.getRequestDispatcher("studentLearningHomeworkDetail.jsp").forward(request, response);
		
	}

}

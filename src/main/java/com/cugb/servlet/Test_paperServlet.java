package com.cugb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cugb.entity.Test_paper;
import com.cugb.service.Test_paperService;
import com.cugb.service.Test_totalService;
import com.cugb.utils.FileUploadTool;


@WebServlet("/Test_paperServlet")
@MultipartConfig
public class Test_paperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Test_totalService tts = new Test_totalService();
    Test_paperService tps = new Test_paperService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String method=request.getParameter("method");
		switch (method) {
		case "submitTest":
			submitTest(request,response);
			break;
		default:
			break;
		}
	}


	private void submitTest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(this.getClass().getName()+" submitTest");

		//��ȡֵ
		String test_id = request.getParameter("test_id");
		String string_answer = request.getParameter("string_answer");
		String problem_number=request.getParameter("problem_number");
//		String pic_answer = request.getParameter("pic_answer");



		//��ȡ��
		HttpSession session = request.getSession();
		String student_name = session.getAttribute("user_name").toString();

		Part part = request.getPart("pic_answer");
		String pic_answer=null;
		if (part.getSize() != 0) {
			pic_answer = FileUploadTool.FileUpload("������ת��ַ", part, request, response);
		}

		System.out.println(this.getClass().getName()+" "+test_id+string_answer+pic_answer);

		//��װ
		Test_paper tp = new Test_paper(Integer.parseInt(test_id), Integer.parseInt(problem_number), student_name, string_answer, pic_answer);
		
		//�ж�
		boolean flag = tps.addTest_paper(tp);
		if(flag) {
			System.out.println("�ύ�ɹ�");
		}else {
			System.out.println("�ύʧ��");
		}
		
		
	}
	
	

}

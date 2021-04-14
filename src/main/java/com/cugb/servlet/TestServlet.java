package com.cugb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.cugb.entity.Test;
import com.cugb.entity.Test_total;
import com.cugb.service.TestService;
import com.cugb.utils.DateTool;
import com.cugb.utils.FileUploadTool;
import com.cugb.utils.PageTool;


@WebServlet("/TestServlet")
@MultipartConfig
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TestService ts=new TestService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//乱码处理
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method=request.getParameter("method");
		switch(method) {
		case"findTest":
			findTest(request,response);
			break;
		case"addTest":
			addTest(request,response);
			break;
		case"deleteTest":
			deleteTest(request,response);
			break;
		case"updateTest":
			updateTest(request,response);
			break;
		default:
			break;	
		}
	}
	private void updateTest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}


	private void deleteTest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String tids=request.getParameter("tids");
		boolean flag=ts.deleteProblemById(tids);
		if(flag) {
			response.sendRedirect("Test_totalServlet?method=findTesk_Total");
		}
	}

	//增加考题
	private void addTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test_id=request.getParameter("test_id");
		String problem_number=request.getParameter("problem_number");
		String problem_type=request.getParameter("problem_type");
		String problem_score=request.getParameter("problem_score");
		String problem_photo=request.getParameter("problem_photo");
		String problem_answer=request.getParameter("problem_answer");
		String type=problem_photo.substring(problem_photo.length()-3,problem_photo.length());
		String type2=problem_answer.substring(problem_answer.length()-3,problem_answer.length());
		 
		if(type=="pic"||type=="jpg") {
			Part part = request.getPart("problem_photo");
			problem_photo=FileUploadTool.FileUpload("inserttest.jsp", part, request, response);
		}
		if(type2=="pic"||type2=="jpg") {
			Part part2 = request.getPart("problem_answer");
			problem_answer=FileUploadTool.FileUpload("inserttest.jsp", part2, request, response);
		}
		
		Test t=new Test(Integer.valueOf(test_id), Integer.valueOf(problem_number), Integer.valueOf(problem_type), problem_photo, problem_answer, Double.valueOf(problem_score));
		boolean flag=ts.addTest(t);
		if(flag) {
			request.setAttribute("test_total", t);
			request.getRequestDispatcher("inserttest.jsp").forward(request, response);
		}
		
	}

	//展示一门试卷的所有试题
	private void findTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int test_id=Integer.valueOf(request.getParameter("tid"));
		//创建对象
		List<Test> tests=ts.findPaperById(test_id);
		//域对象
		request.setAttribute("tests", tests);
		request.getRequestDispatcher("mytest.jsp").forward(request, response);
		
	}

}

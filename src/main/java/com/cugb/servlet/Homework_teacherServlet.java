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

import com.cugb.entity.Homework_student;
import com.cugb.entity.Homework_teacher;
import com.cugb.entity.Learning_materials;
import com.cugb.entity.Test_paper;
import com.cugb.service.Homework_teacherService;
import com.cugb.service.Learning_materialsService;
import com.cugb.utils.DateTool;
import com.cugb.utils.FileUploadTool;
import com.cugb.utils.PageTool;


@WebServlet("/Homework_teacherServlet")
@MultipartConfig
public class Homework_teacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Homework_teacherService hs=new Homework_teacherService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method=request.getParameter("method");
		switch(method) {
		case"addhomework":
			addhomework(request,response);	
			break;
		case"findhomework":
			findhomework(request,response);	
			break;
		case"deletehomework":
			deletehomework(request,response);	
			break;
		case"updateToShow":
			updateToShow(request,response);
			break;
		case"updatehomework":
			updatehomework(request,response);
			break;
		case"findstuhomeworkbytname":
			findstuhomeworkbytname(request,response);
			break;
		case"findexambytname":
			findexambytname(request,response);
			break;
		case"updateToShowscore":
			updateToShowscore(request,response);
			break;
		case"updateToShowscore2":
			updateToShowscore2(request,response);
			break;
		case"updatescore":
			updatescore(request,response);
			break;
		case"updateexamscore":
			updateexamscore(request,response);
			break;
		default:
			break;	
		}
	}
	private void updatescore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String homework_id=request.getParameter("homework_id");
		String homework_score=request.getParameter("homework_score");
		String homework_comment=request.getParameter("homework_comment");		
		Homework_student Homework_student=new Homework_student(Integer.valueOf(homework_id),Double.parseDouble(homework_score),homework_comment);
		boolean flag=hs.updatescore(Homework_student);
		if(flag) {
			response.sendRedirect("index_teacher.jsp");
		}
	}
	private void updateexamscore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String student_name=request.getParameter("student_name");
		String test_score=request.getParameter("test_score");
		String test_comment=request.getParameter("test_comment");		
		Test_paper Test_paper=new Test_paper(student_name,Double.parseDouble(test_score),test_comment);
		boolean flag=hs.updateexamscore(Test_paper);
		if(flag) {
			response.sendRedirect("index_teacher.jsp");
		}
	}
	
	
  private void updateToShowscore(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentwork_id=request.getParameter("studentwork_id");
		Homework_student Homework_student=hs.findstuhomeworkByld(studentwork_id);
		request.setAttribute("Homework_student",Homework_student);
		request.getRequestDispatcher("uploadhomeworkscore.jsp").forward(request, response);	
}
  private void updateToShowscore2(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String student_name=request.getParameter("student_name");
		Test_paper Test_paper=hs.findexamBysn(student_name);
		request.setAttribute("Test_paper",Test_paper);
		request.getRequestDispatcher("uploadexamscore.jsp").forward(request, response);	
}
private void findstuhomeworkbytname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	  int totalCount=hs.getTotalCount();
		String currentPage=request.getParameter("currentPage");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		//创建对象
		PageTool tool=new PageTool(totalCount,currentPage);
		List<Homework_student> Homework_student=hs.findstuhomeworkbytname(tool,teacher_name);
		//域对象
		request.setAttribute("Homework_student",Homework_student);
		request.setAttribute("tool", tool);
		request.getRequestDispatcher("checkhomework.jsp").forward(request, response);	
	
}
private void findexambytname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    int totalCount=hs.getTotalCount();
		String currentPage=request.getParameter("currentPage");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		//创建对象
		PageTool tool=new PageTool(totalCount,currentPage);
		List<Test_paper> Test_paper=hs.findexambytname(tool,teacher_name);
		//域对象
		request.setAttribute("Test_paper",Test_paper);
		request.setAttribute("tool", tool);
		request.getRequestDispatcher("checkexam.jsp").forward(request, response);	
	
}
	  private void updatehomework(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String homework_id=request.getParameter("homework_id");
			String homework_name=request.getParameter("homework_name");
			String lesson_name=request.getParameter("lesson_name");
			String teacher_name=request.getParameter("teacher_name");
			String homework_description=request.getParameter("homework_description");
			String homework_create_time=request.getParameter("homework_create_time");
			Part part=request.getPart("homework_file");
			String homework_file=FileUploadTool.FileUpload("updatehomework.jsp", part, request, response);
			if(!homework_file.equals("")) {
				Homework_teacher Homework_teacher=new Homework_teacher(Integer.valueOf(homework_id),homework_name,lesson_name,teacher_name,homework_file,homework_description, DateTool.stringToDate(homework_create_time));
				boolean flag=hs.updatehomework(Homework_teacher);
				if(flag) {
					response.sendRedirect("index_teacher.jsp");
				}
			}
			
		}
	private void updateToShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String homework_id=request.getParameter("homework_id");
		Homework_teacher Homework_teacher=hs.findhomeworkByld(homework_id);
		request.setAttribute("Homework_teacher",Homework_teacher);
		request.getRequestDispatcher("updatehomework.jsp").forward(request, response);	
	}
	private void deletehomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String homeworklids=request.getParameter("lids");
		boolean flag=hs.deletehomeworkById(homeworklids);
		if(flag) {
			response.sendRedirect("index_teacher.jsp");
		}
	}
	private void findhomework(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int totalCount=hs.getTotalCount();
		String currentPage=request.getParameter("currentPage");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		//创建对象
		PageTool tool=new PageTool(totalCount,currentPage);
		List<Homework_teacher> Homework_teacher=hs.findhomeworkByPage(tool,teacher_name);
		//域对象
		request.setAttribute("Homework_teacher",Homework_teacher);
		request.setAttribute("tool", tool);
		request.getRequestDispatcher("myhomework.jsp").forward(request, response);		
	}
	
	private void addhomework(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String homework_name=request.getParameter("homework_name");
		String teacher_name=request.getParameter("teacher_name");
		String lesson_name=request.getParameter("lesson_name");
		String homework_description=request.getParameter("homework_description");
		String homework_create_time=request.getParameter("homework_create_time");
		Part part=request.getPart("homework_file");
		String homework_file=FileUploadTool.FileUpload("uploadhomework.jsp", part, request, response);
		if(!homework_file.equals("")) {
			Homework_teacher Homework_teacher=new Homework_teacher(homework_name,lesson_name,teacher_name,homework_file,homework_description, DateTool.stringToDate(homework_create_time));
			boolean flag=hs.addhomework(Homework_teacher);
			if(flag) {
				request.getRequestDispatcher("index_teacher.jsp").forward(request, response);
			}
		}
		
	}

}

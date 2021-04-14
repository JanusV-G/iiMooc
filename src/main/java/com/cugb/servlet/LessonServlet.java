package com.cugb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.cugb.entity.Lesson;
import com.cugb.service.Homework_teacherService;
import com.cugb.service.Learning_materialsService;
import com.cugb.service.LessonService;
import com.cugb.service.Test_totalService;
import com.cugb.service.VideoService;
import com.cugb.utils.DateTool;
import com.cugb.utils.FileUploadTool;
import com.cugb.utils.PageTool;

@WebServlet("/LessonServlet")
@MultipartConfig
public class LessonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LessonService ls=new LessonService();
	Learning_materialsService lms=new Learning_materialsService();
	Homework_teacherService hs=new Homework_teacherService();
	VideoService vs=new VideoService();
	Test_totalService ts=new Test_totalService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//乱码处理
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method=request.getParameter("method");
		switch(method) {
			case"findLesson":
				findLesson(request,response);
				break;
			case"addLesson":
				addLesson(request,response);
				break;
			case"deleteLesson":
				deleteLesson(request,response);
				break;
			case"updateLesson":
				updateLesson(request,response);
				break;
			case"updateToShow":
				updateToShow(request,response);
				break;
			case"lessonDetail":
				lessonDetail(request,response);
				break;
			case "findLessonById":
				findLessonById(request,response);
				break;
			case"findAllLesson":
				findAllLesson(request,response);
				break;
			default:
				break;
		}
	}
	//所有课程分类
	private void findAllLesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String name=(String)session.getAttribute("user_name");
		List<Lesson> list=ls.findAllLesson(name);
		session.setAttribute("list", list);
		request.getRequestDispatcher("index_teacher.jsp").forward(request, response);
			
	}
	//课程详情页面信息回显
	private void lessonDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName()+" lessonDetail");

		String lesson_id=request.getParameter("lid");
		System.out.println(this.getClass().getName()+" 课程lid="+lesson_id);

		Lesson lesson=ls.findLessonById(lesson_id);
		System.out.println(this.getClass().getName()+" 获取到的课程id="+lesson.getLesson_id());

		request.setAttribute("lesson", lesson);
		System.out.println(this.getClass().getName()+" WDNMD"+lesson.getLesson_name());
//		response.sendRedirect("lesson_profile.jsp");
		request.getRequestDispatcher("lesson_profile.jsp").forward(request,response);

	}
	//修改回显
	private void updateToShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lesson_id=request.getParameter("lid");
		Lesson lesson=ls.findLessonById(lesson_id);
		request.setAttribute("lesson", lesson);
		request.getRequestDispatcher("updatecourse.jsp").forward(request, response);
	}
	//修改课程
	private void updateLesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lesson_id=request.getParameter("lesson_id");
		String lesson_name=request.getParameter("lesson_name");
		String teacher_name=request.getParameter("teacher_name");
		String students_number=request.getParameter("students_number");
		String videos_number=request.getParameter("videos_number");
		String description=request.getParameter("description");
		String lesson_create_time=request.getParameter("lesson_create_time");
		String flag=request.getParameter("flag");
		String file= request.getParameter("oldpic");
		Part part=request.getPart("lesson_photo");
		if (part.getSize()!=0) {
			file=FileUploadTool.FileUpload("updatecourse.jsp", part, request, response);
		}		
		if(!file.equals("")) {
			Lesson lesson=new Lesson(Integer.valueOf(lesson_id),lesson_name, teacher_name, Integer.valueOf(students_number), Integer.valueOf(videos_number), file, description, DateTool.stringToDate(lesson_create_time),flag);
			boolean flag2=ls.updateLessonById(lesson);
			if(flag2) {
				response.sendRedirect("LessonServlet?method=findLesson");
			}
		}

	}
	//删除课程
	private void deleteLesson(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String lname=request.getParameter("lname");
		boolean flag1=lms.deleteLessonmaterialBylname(lname);
		boolean flag2=vs.deletevedioBylname(lname);
		boolean flag3=hs.deletehomeworkBylname(lname);
		boolean flag4=ts.deleteTesk_TotalBylname(lname);
		boolean flag=ls.deleteLessonBylname(lname);
		if(flag) {
			response.sendRedirect("LessonServlet?method=findLesson");
		}
	}
	//增加课程
	private void addLesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lesson_name=request.getParameter("lesson_name");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		String students_number=request.getParameter("students_number");
		String description=request.getParameter("description");
		String lesson_create_time=request.getParameter("lesson_create_time");
		String flag="0";
		Part part=request.getPart("lesson_photo");
		String lesson_photo=FileUploadTool.FileUpload("insertcourse.jsp", part, request, response);
		if(!lesson_photo.equals("")) {
			Lesson lesson=new Lesson(lesson_name, teacher_name, Integer.valueOf(students_number),0, lesson_photo, description, DateTool.stringToDate(lesson_create_time),flag);
			boolean flag2=ls.addLesson(lesson);
			if(flag2) {
				request.getRequestDispatcher("index_teacher.jsp").forward(request, response);
			}
		}
	}
	//分页显示课程
	private void findLesson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int totalCount=ls.getTotalCount();
		String currentPage=request.getParameter("currentPage");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		//创建对象
		PageTool tool=new PageTool(totalCount,currentPage);
		List<Lesson> lessons=ls.findLessonByPage(tool,teacher_name);
		//域对象
		request.setAttribute("lessons", lessons);
		request.setAttribute("tool", tool);
		request.getRequestDispatcher("mycourse.jsp").forward(request, response);
	}

	private void findLessonById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(this.getClass().getName()+" findLessonById");

		String lessonID=request.getParameter("lessonID");
		Lesson lesson = ls.findLessonById(lessonID);
//		request.setAttribute("lesson",lesson);
		HttpSession session=request.getSession();
		session.setAttribute("lessonNow",lesson);
		response.sendRedirect("studentLearningMain.jsp");
	}
}

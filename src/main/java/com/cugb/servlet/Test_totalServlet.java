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

import com.cugb.entity.Test_total;
import com.cugb.service.Test_totalService;
import com.cugb.utils.DateTool;
import com.cugb.utils.PageTool;


@WebServlet("/Test_totalServlet")
@MultipartConfig
public class Test_totalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Test_totalService ts=new Test_totalService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//���봦��
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String method=request.getParameter("method");
			switch(method) {
			case"findTesk_Total":
				findTesk_Total(request,response);
				break;
			case"addTesk_Total":
				addTesk_Total(request,response);
				break;
			case"deleteTesk_Total":
				deleteTesk_Total(request,response);
				break;
			case"updateTesk_Total":
				updateTesk_Total(request,response);
				break;
			case"updateToShow":
				updateToShow(request,response);
				break;
			case"findTesk_TotalById":
				findTesk_TotalById(request,response);
				break;
			default:
				break;	
			}
		}
	//���ձ��Ѱ��(��������ר��)
	private void findTesk_TotalById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test_id=request.getParameter("tid");
		Test_total test_total=ts.findTesk_TotalById(test_id);
		request.setAttribute("test_total", test_total);
		request.getRequestDispatcher("inserttest.jsp").forward(request, response);	
		}
	//�޸Ļ���
	private void updateToShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test_id=request.getParameter("tid");
		Test_total test=ts.findTesk_TotalById(test_id);
		request.setAttribute("test", test);
		request.getRequestDispatcher("updatetest_total.jsp").forward(request, response);	
	}
	//�޸��Ծ���Ϣ
	private void updateTesk_Total(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test_id=request.getParameter("test_id");
		String test_name=request.getParameter("test_name");
		String lesson_name=request.getParameter("lesson_name");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		String test_password=request.getParameter("test_password");
		String begin_time=request.getParameter("begin_time");
		String end_time=request.getParameter("end_time");
		Test_total test=new Test_total(Integer.valueOf(test_id), test_name, lesson_name, teacher_name, test_password, DateTool.stringToDate(begin_time), DateTool.stringToDate(end_time));
		boolean flag=ts.updateTesk_TotalById(test);
		if(flag) {
			response.sendRedirect("Test_totalServlet?method=findTesk_Total");
		}
		
	}
	//ɾ���Ծ�
	private void deleteTesk_Total(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String testids=request.getParameter("tids");
		boolean flag=ts.deleteTesk_TotalById(testids);
		if(flag) {
			//request.getRequestDispatcher("index_teacher.jsp").forward(request, response);
			response.sendRedirect("Test_totalServlet?method=findTesk_Total");
		}
	}
	//�����Ծ�
	private void addTesk_Total(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String test_name=request.getParameter("test_name");
		String lesson_name=request.getParameter("lesson_name");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		String test_password=request.getParameter("test_password");
		String begin_time=request.getParameter("begin_time");
		String end_time=request.getParameter("end_time");
		Test_total tesk=new Test_total(test_name, lesson_name, teacher_name, test_password, DateTool.stringToDate(begin_time), DateTool.stringToDate(end_time));
		boolean flag=ts.addTesk_Total(tesk);
		if(flag) {
			request.getRequestDispatcher("index_teacher.jsp").forward(request, response);
		}		
	}
	//��ҳ��ʾ�Ծ�
	private void findTesk_Total(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int totalCount=ts.getTotalCount();
		String currentPage=request.getParameter("currentPage");
		HttpSession session=request.getSession();
		String teacher_name=(String)session.getAttribute("user_name");
		//��������
		PageTool tool=new PageTool(totalCount,currentPage);
		List<Test_total> tests=ts.findTesk_TotalByPage(tool,teacher_name);
		//�����
		request.setAttribute("tests", tests);
		request.setAttribute("tool", tool);
		request.getRequestDispatcher("test_total.jsp").forward(request, response);
		}
	}

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

import com.cugb.entity.Lesson;
import com.cugb.entity.Video;
import com.cugb.service.LessonService;
import com.cugb.service.VideoService;
import com.cugb.utils.DateTool;
import com.cugb.utils.FileUploadTool;
import com.cugb.utils.PageTool;


@WebServlet("/VideoServlet")
@MultipartConfig
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    VideoService vs=new VideoService();   
    LessonService ls=new LessonService();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//乱码处理
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String method=request.getParameter("method");
		switch(method) {
		case"findVideo":
			findVideo(request,response);
			break;
		case"addVideo":
			addVideo(request,response);
			break;
		case"deleteVideo":
			deleteVideo(request,response);
			break;
		case"updateVideo":
			updateVideo(request,response);
			break;
		case"updateToShow":
			updateToShow(request,response);
			break;
		default:{
        	System.out.println(this.getClass().getName()+" 异常method: "+method);
		}
		}
	}
//修改回显
private void updateToShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String video_id=request.getParameter("vid");
	Video video=vs.findVideoById(video_id);
	request.setAttribute("video", video);
	request.getRequestDispatcher("updatevideo.jsp").forward(request, response);	
}
//修改视频信息
private void updateVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String video_id=request.getParameter("video_id");
	String video_name=request.getParameter("video_name");
	//String upload_user_name=request.getParameter("upload_user_name");
	HttpSession session=request.getSession();
	String upload_user_name=(String)session.getAttribute("user_name");
	String lesson_name=request.getParameter("lesson_name");
	String video_description=request.getParameter("video_description");
	String video_create_time=request.getParameter("video_create_time");
	Part part=request.getPart("video_file");
	String video_file=FileUploadTool.videoUpload("insertvideo.jsp", part, request, response);
	Video video=new Video(Integer.valueOf(video_id), video_name, upload_user_name, lesson_name, video_file, video_description, DateTool.stringToDate(video_create_time));
	boolean flag=vs.updateVideoById(video);
	if(flag) {
		response.sendRedirect("VideoServlet?method=findVideo");
	}
	
}
//删除视频
private void deleteVideo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	// TODO Auto-generated method stub
	String videoid=request.getParameter("vid");
	boolean flag=vs.deleteVideoById(videoid);
	if(flag) {
		response.sendRedirect("VideoServlet?method=findVideo");
	}
}
//增加视频
private void addVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String video_name=request.getParameter("video_name");
	HttpSession session=request.getSession();
	String upload_user_name=(String)session.getAttribute("user_name");
	String lesson_name=request.getParameter("lesson_name");
	String video_description=request.getParameter("video_description");
	String video_create_time=request.getParameter("video_create_time");
	Part part=request.getPart("video_file");
	String video_file=FileUploadTool.videoUpload("insertvideo.jsp", part, request, response);
	if(!video_file.equals("")) {
		Video video=new Video(video_name, upload_user_name, lesson_name, video_file, video_description, DateTool.stringToDate(video_create_time));
		Lesson lesson=new Lesson(lesson_name, upload_user_name);
		boolean flag=vs.addVideo(video);
		ls.updateLessonByName(lesson);
		if(flag) {			
			request.getRequestDispatcher("index_teacher.jsp").forward(request, response);
		}
	}
}

//分页显示视频
private void findVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int totalCount=vs.getTotalCount();
	String currentPage=request.getParameter("currentPage");
	HttpSession session=request.getSession();
	String teacher_name=(String)session.getAttribute("user_name");
	//创建对象
	PageTool tool=new PageTool(totalCount,currentPage);
	List<Video> videos=vs.findVideoByPage(tool,teacher_name);
	//域对象
	request.setAttribute("videos", videos);
	request.setAttribute("tool", tool);
	request.getRequestDispatcher("myvideo.jsp").forward(request, response);
	}
}

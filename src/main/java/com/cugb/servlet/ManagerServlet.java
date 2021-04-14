package com.cugb.servlet;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cugb.entity.Homework_student;
import com.cugb.entity.Homework_teacher;
import com.cugb.entity.Learning_materials;
import com.cugb.entity.Lesson;
import com.cugb.entity.Test;
import com.cugb.entity.Test_paper;
import com.cugb.entity.Test_total;
import com.cugb.entity.User;
import com.cugb.entity.Video;
import com.cugb.service.Homework_studentService;
import com.cugb.service.Homework_teacherService;
import com.cugb.service.Learning_materialsService;
import com.cugb.service.ManagerService;
import com.cugb.service.TestService;
import com.cugb.service.Test_paperService;
import com.cugb.service.Test_totalService;
import com.cugb.utils.FileUploadTool;

@WebServlet("/ManagerServlet")
@MultipartConfig
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManagerService ms = new ManagerService();
	Test_totalService tts = new Test_totalService();
	TestService ts = new TestService();
	Test_paperService tps = new Test_paperService();
	Homework_teacherService hts = new Homework_teacherService();// 7.17新加
	Homework_studentService hss = new Homework_studentService();
	Learning_materialsService lms = new Learning_materialsService();
	String test_id;
	String name;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 乱码处理
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/hyml;charset=utf-8");
		// 获取请求的标识
		String method = request.getParameter("method");
		switch (method) {
		// 1.用户管理
		// 查看所有用户
		case "findAllUsers":
			findAllUsers(request, response);
			break;
		// 查看所有教师
		case "findAllTeachers":
			findAllTeachers(request, response);
			break;
		// 查看所有学生
		case "findAllStudents":
			findAllStudents(request, response);
			break;
		// 添加用户
		case "addUser":
			addUser(request, response);
			break;
		// 更新用户
		case "updateUser":
			updateUser(request, response);
			break;
		// 用户信息回显
		case "updateToShow":
			updateToShow(request, response);
			break;
		// 删除用户
		case "deleteMany":
			deleteMany(request, response);
			break;
		// 核对用户邮件
		case "checkEmail":
			checkEmail(request, response);
			break;
		// 2.网课管理
		// 查看视频
		case "findAllVideos":
			findAllVideos(request, response);
			break;
		// 删除视频
		case "deleteManyVideos":
			deleteManyVideos(request, response);
			break;
		// 查询全部姓名与课程 放在数组中方便读取
		case "findAllData":
			findAllData(request, response);
			break;
		// 添加网课
		case "addVideo":
			addVideo(request, response);
			break;
		// 视频回显+查询
		case "updateVideoToShow":
			updateVideoToShow(request, response);
			break;
		// 更新视频
		case "updateVideo":
			updateVideo(request, response);
			break;
		// 查找课程
		case "findAllLessons":
			findAllLessons(request, response);
			break;
		// 删除课程
		case "deleteManyLessons":
			deleteManyLessons(request, response);
			break;
		case "updateLessonToShow":
			updateLessonToShow(request, response);
			break;
		case "updateLesson":
			updateLesson(request, response);
			break;
		case "findAllLessonData":
			findAllLessonData(request, response);
			break;
		// 添加课程
		case "addLesson":
			addLesson(request, response);
			break;
		case "manageAllTest":
			manageAllTest(request, response);
			break;
		case "manageUnendTest":
			manageUnendTest(request, response);
			break;
		case "manageEndTest":
			manageEndTest(request, response);
			break;
		case "deleteTest":
			deleteTest(request, response);
			break;
		case "showTestTotal":
			showTestTotal(request, response);
			break;
		case "edictTestTotal":
			edictTestTotal(request, response);
			break;
		case "addTestTotal":
			addTestTotal(request, response);
			break;
		case "showTestPaperById":
			showTestPaperById(request, response);
			break;
		case "deleteProblem":
			deleteProblem(request, response);
			break;
		case "edictProblemtoshow":
			edictProblemtoshow(request, response);
			break;
		case "edictProblem":
			edictProblem(request, response);
			break;
		case "transmitTestid":
			transmitTestid(request, response);
			break;
		case "addProblem":
			addProblem(request, response);
			break;
		case "viewAnswerByProblem":
			viewAnswerByProblem(request, response);
			break;
		case "deleteAnswer":
			deleteAnswer(request, response);
			break;
		case "manageAllProblems":
			manageAllProblems(request, response);
			break;
		case "manageAllAnswers":
			manageAllAnswers(request, response);
			break;
		case "manageHomeworkTeacher":
			manageHomeworkTeacher(request, response);
			break;
		case "deleteHomework":
			deleteHomework(request, response);
			break;
		case "manageHomeworkStudent":
			manageHomeworkStudent(request, response);
			break;
		case "deleteHomeworkStudent":
			deleteHomeworkStudent(request, response);
			break;
		case "manageAllLm":
			manageAllLm(request, response);
			break;
		case "deleteLm":
			deleteLm(request, response);
			break;
		case "deleteManyLm":
			deleteManyLm(request,response);
			break;
		case "deleteManyHomeworkTeacher":
			deleteManyHomeworkTeacher(request,response);
			break;
		case "deleteManyHomeworkStudent":
			deleteManyHomeworkStudent(request,response);
			break;
		case "deleteManyProblem":
			deleteManyProblem(request,response);
			break;
		case "deleteManyTest":
			deleteManyTest(request,response);
			break;
				
		default:
			break;
		}

	}

	private void deleteManyTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uids = request.getParameter("uids");
		boolean flag = tts.deleteManyTest(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageEndTest");
		}
	}

	private void deleteManyProblem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uids = request.getParameter("uids");
		boolean flag = ts.deleteManyProblem(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=showTestPaperById");
		}
	}

	private void deleteManyHomeworkStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uids = request.getParameter("uids");
		boolean flag = hss.deleteManyHomeworkStudent(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageHomeworkStudent");
		}
	}

	private void deleteManyHomeworkTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uids = request.getParameter("uids");
		boolean flag = hts.deleteManyHomeworkTeacher(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageHomeworkTeacher");
		}
	}

	private void deleteManyLm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String uids = request.getParameter("uids");
		boolean flag = lms.deleteManyLm(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageAllLm");
		}
	}

	private void findAllLessonData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> name = new ArrayList<String>();
		name = ms.findAllLessonData();
		request.setAttribute("name", name);
		request.getRequestDispatcher("admin/AddLesson.jsp").forward(request, response);
	}

	// 用户管理
	// 核对邮件
	private void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user_email = request.getParameter("user_email");
		boolean flag = ms.checkEmail(user_email);
		response.getWriter().print(flag);
	}

	// 用户信息回显 根据分类编号查询
	private void updateToShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");// 可以获取
		User user = ms.findUserById(Integer.valueOf(user_id));
		request.setAttribute("user", user);
		request.getRequestDispatcher("admin/UpdateUser.jsp").forward(request, response);
	}

	// 修改用户信息
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_type = request.getParameter("user_type");
		String user_class = request.getParameter("user_class");
		String student_id = request.getParameter("student_id");
		String user_email = request.getParameter("user_email");
		String user_number = request.getParameter("user_number");
		String password = request.getParameter("password");
		String user_photo = request.getParameter("user_photo");
		Part part = request.getPart("user_photo");
		user_photo = FileUploadTool.FileUpload("admin/AddUser.jsp", part, request, response);
		User user = new User(Integer.valueOf(user_id), user_name, Integer.valueOf(user_type),
				Integer.valueOf(user_class), student_id, user_email, user_number, password, user_photo);
		boolean flag = ms.updateUser(user);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=findAllUsers");
		}
	}

	private void updateLesson(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String lesson_id = request.getParameter("lesson_id");
		String lesson_name = request.getParameter("lesson_name");
		String teacher_name = request.getParameter("teacher_name");
		String students_number = request.getParameter("students_number");
		String description = request.getParameter("description");
		String flag = request.getParameter("flag");
		String lesson_photo = request.getParameter("lesson_photo");
		Part part = request.getPart("lesson_photo");
		lesson_photo = FileUploadTool.FileUpload("ManagerServlet?method=findAllLessonData", part, request, response);
		Lesson lesson = new Lesson(Integer.valueOf(lesson_id), lesson_name, teacher_name,
				Integer.valueOf(students_number), lesson_photo, description, flag);
		boolean falg = ms.updateLesson(lesson);
		if (falg) {
			response.sendRedirect("ManagerServlet?method=findAllLessons");
		}
	}

	// 添加用户信息
	private void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String user_type = request.getParameter("user_type");
		String user_class = request.getParameter("user_class");
		String student_id = request.getParameter("student_id");
		String user_email = request.getParameter("user_email");
		String user_number = request.getParameter("user_number");
		String password = request.getParameter("password");
		Part part = request.getPart("user_photo");
		String user_photo = FileUploadTool.FileUpload("admin/AddUser.jsp", part, request, response);
		User user = new User(user_name, Integer.valueOf(user_type), Integer.valueOf(user_class), student_id, user_email,
				user_number, password, user_photo);
		boolean flag = ms.addUser(user);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=findAllUsers");
		} else {
			response.sendRedirect("ManagerServlet?method=addUser");
		}
	}

	// 删除全部用户
	private void deleteMany(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uids = request.getParameter("uids");
		boolean flag = ms.deleteMany(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=findAllUsers");
		}
	}

	// 删除全部课程
	private void deleteManyLessons(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uids = request.getParameter("uids");
		boolean flag = ms.deleteManyLessons(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=findAllLessons");
		}
	}

	// 查询全部学生
	private void findAllStudents(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> list = ms.findAllStudents();
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/StudentManager.jsp").forward(request, response);
	}

	// 查询全部教师
	private void findAllTeachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> list = ms.findAllTeachers();
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/TeacherManager.jsp").forward(request, response);
	}

	// 查询全部用户
	private void findAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> list = ms.findAllUsers();
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/UserManager.jsp").forward(request, response);
	}

	// 网课管理
	// 查看视频
	private void findAllVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> list = ms.findAllVideos();
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/VideoManager.jsp").forward(request, response);
	}

	// 删除视频
	private void deleteManyVideos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uids = request.getParameter("uids");
		boolean flag = ms.deleteManyVideos(uids);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=findAllVideos");
		}
	}

	// 获取姓名课程数据
	private void findAllData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> name = new ArrayList<String>();
		List<String> lesson = new ArrayList<String>();
		name = ms.findAllName();
		lesson = ms.findAllLesson();
		request.setAttribute("name", name);
		request.setAttribute("lesson", lesson);
		request.getRequestDispatcher("admin/AddVideo.jsp").forward(request, response);
	}

	// 修改视频回显
	private void updateVideoToShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> name = new ArrayList<String>();
		List<String> lesson = new ArrayList<String>();
		String video_id = request.getParameter("video_id");// 可以获取
		Video video = ms.findVideoById(Integer.valueOf(video_id));
		name = ms.findAllName();
		lesson = ms.findAllLesson();
		request.setAttribute("name", name);
		request.setAttribute("lesson", lesson);
		request.setAttribute("video", video);
		request.getRequestDispatcher("admin/UpdateVideo.jsp").forward(request, response);
	}

	// 修改视频
	private void updateVideo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String video_id = request.getParameter("video_id");
		String video_name = request.getParameter("video_name");
		String upload_user_name = request.getParameter("upload_user_name");
		String lesson_name = request.getParameter("lesson_name");
		String video_description = request.getParameter("video_description");
		Part part = request.getPart("video_file");
		String video_file = FileUploadTool.videoUpload("ManagerServlet?method=findAllVideoData", part, request,
				response);
		Video video = new Video(Integer.valueOf(video_id), video_name, upload_user_name, lesson_name, video_file,
				video_description, new Date());
		boolean flag = ms.updateVideo(video);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=findAllVideos");
		}
	}

	// 上传视频
	private void addVideo(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String video_name = request.getParameter("video_name");
		String upload_user_name = request.getParameter("upload_user_name");
		String lesson_name = request.getParameter("lesson_name");
		String video_description = request.getParameter("video_description");
		Part part = request.getPart("video_file");
		String video_file = FileUploadTool.videoUpload("ManagerServlet?method=findAllData", part, request, response);
		Video video = new Video(video_name, upload_user_name, lesson_name, video_file, video_description, new Date());
		boolean flag = ms.addVideo(video);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=findAllVideos");
		} else {
			response.sendRedirect("ManagerServlet?method=findAllData");
		}

	}

	private void addLesson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lesson_name = request.getParameter("lesson_name");
		String teacher_name = request.getParameter("teacher_name");
		String students_number = request.getParameter("students_number");
		String description = request.getParameter("description");
		String flag = "0";
		Part part = request.getPart("lesson_photo");
		String lesson_photo = FileUploadTool.FileUpload("ManagerServlet?method=findAllLessonData", part, request,
				response);
		Lesson lesson = new Lesson(lesson_name, teacher_name, Integer.valueOf(students_number), 0, lesson_photo,
				description, new Date(), flag);
		boolean flag1 = ms.addLesson(lesson);
		if (flag1) {
			response.sendRedirect("ManagerServlet?method=findAllLessons");
		} else {
			response.sendRedirect("ManagerServlet?method=findAllLessonData");
		}
	}

	// 修改课程回显
	private void updateLessonToShow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> name = new ArrayList<String>();
		String lesson_id = request.getParameter("lesson_id");// 可以获取
		Lesson lesson = ms.findLessonById(Integer.valueOf(lesson_id));
		name = ms.findAllLessonData();
		request.setAttribute("name", name);
		request.setAttribute("lesson", lesson);
		request.getRequestDispatcher("admin/UpdateLesson.jsp").forward(request, response);
	}

	private void findAllLessons(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Lesson> list = ms.findAllLessons();
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/LessonManager.jsp").forward(request, response);
	}

	private void manageAllAnswers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Test_paper> answer = tps.findAllAnswers();
		request.setAttribute("answer", answer);
		request.getRequestDispatcher("admin/answer_list.jsp").forward(request, response);
	}

	private void manageAllProblems(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Test> paper = ts.findAllProblems();
		request.setAttribute("paper", paper);
		request.getRequestDispatcher("admin/paper_id.jsp").forward(request, response);
	}

	private void deleteAnswer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		test_id = request.getParameter("test_id");
		String problem_number = request.getParameter("problem_number");
		String student_name = request.getParameter("student_name");
		boolean flag = tps.deleteAnswer(Integer.valueOf(test_id), Integer.valueOf(problem_number), student_name);
		if (flag) {
			viewAnswerByProblem(request, response);
		} else {
			response.getWriter().print("删除失败");
		}
	}

	private void viewAnswerByProblem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		test_id = request.getParameter("test_id");
		String problem_number = request.getParameter("problem_number");
		List<Test_paper> answer = tps.findAnswerByProblem(Integer.valueOf(test_id), Integer.valueOf(problem_number));
		request.setAttribute("answer", answer);
		request.getRequestDispatcher("admin/answer_list.jsp").forward(request, response);
	}

	private void addProblem(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		test_id = request.getParameter("test_id");
		String problem_type = request.getParameter("problem_type");
		String problem_photo = request.getParameter("problem_photo");
		String problem_answer = request.getParameter("problem_answer");
		String problem_score = request.getParameter("problem_score");
		String problem_number = request.getParameter("problem_number");
		Part part = request.getPart("problem_photo");
		problem_photo = FileUploadTool.FileUpload("admin/problem_add.jsp", part, request, response);
		Test problem = new Test(Integer.valueOf(test_id), Integer.valueOf(problem_number),
				Integer.valueOf(problem_type), problem_photo, problem_answer, Double.valueOf(problem_score));
		boolean flag = ts.addProblem(problem);
		if (flag) {
			showTestPaperById(request, response);
		} else {
			response.getWriter().print("添加失败");
		}
	}

	private void transmitTestid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		test_id = request.getParameter("test_id");
		request.setAttribute("test_id", test_id);
		request.getRequestDispatcher("admin/problem_add.jsp").forward(request, response);
	}

	private void edictProblem(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		test_id = request.getParameter("test_id");
		String problem_number = request.getParameter("problem_number");
		String problem_type = request.getParameter("problem_type");
		String problem_answer = request.getParameter("problem_answer");
		String problem_photo = request.getParameter("problem_photo");
		String problem_score = request.getParameter("problem_score");
		String newproblem_number = request.getParameter("nproblem_number");
		Part part = request.getPart("problem_photo");
		problem_photo = FileUploadTool.FileUpload("admin/edict_problem.jsp", part, request, response);
		Test problem = new Test(Integer.valueOf(test_id), Integer.valueOf(problem_number),
				Integer.valueOf(problem_type), problem_photo, problem_answer, Double.valueOf(problem_score));
		boolean flag = ts.nedictProblem(problem, newproblem_number);
		if (flag) {
			request.getRequestDispatcher("ManagerServlet?method=showTestPaperById").forward(request, response);
		} else {
			response.getWriter().print("修改失败");
		}
	}

	private void edictProblemtoshow(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		test_id = request.getParameter("test_id");
		String problem_number = request.getParameter("problem_number");
		Test problem = ts.findProblem(Integer.valueOf(test_id), Integer.valueOf(problem_number));
		request.setAttribute("problem", problem);
		request.getRequestDispatcher("admin/edict_problem.jsp").forward(request, response);
	}

	private void deleteProblem(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		test_id = request.getParameter("test_id");
		String problem_number = request.getParameter("problem_number");
		boolean flag = ts.deleteProblem(Integer.valueOf(test_id), Integer.valueOf(problem_number));
		System.out.println(test_id);
		if (flag) {
			showTestPaperById(request, response);
		} else {
			response.getWriter().print("删除失败");
		}
	}

	private void showTestPaperById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null)
			test_id = request.getParameter("id");
		name = request.getParameter("name");
		List<Test> paper = ts.findPaperById(Integer.valueOf(test_id));
		request.setAttribute("test_id", test_id);
		request.setAttribute("paper", paper);
		request.setAttribute("test_name", name);
		request.getRequestDispatcher("admin/paper_id.jsp").forward(request, response);
	}

	private void addTestTotal(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String test_name = request.getParameter("test_name");
		String lesson_name = request.getParameter("lesson_name");
		String teacher_name = request.getParameter("teacher_name");
		String test_password = request.getParameter("test_password");
		String bt = request.getParameter("begin_time");
		String et = request.getParameter("end_time");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date begin_time = formatter.parse(bt, pos);
		ParsePosition po = new ParsePosition(0);
		Date end_time = formatter.parse(et, po);
		Test_total tt = new Test_total(test_name, lesson_name, teacher_name, test_password, begin_time, end_time);
		boolean flag = tts.addTestTotal(tt);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageAllTest");
		} else {
			response.getWriter().print("添加失败");
		}
	}

	private void edictTestTotal(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String test_name = request.getParameter("test_name");
		String lesson_name = request.getParameter("lesson_name");
		String teacher_name = request.getParameter("teacher_name");
		String test_password = request.getParameter("test_password");
		String bt = request.getParameter("begin_time");
		String et = request.getParameter("end_time");
		test_id = request.getParameter("id");
		// 将bt和et转换为date类型
		// System.out.println(bt);
		if (bt.length() >= 20) {
			bt = bt.substring(0, 20);
		}
		if (et.length() >= 20) {
			et = et.substring(0, 20);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date begin_time = formatter.parse(bt, pos);
		ParsePosition po = new ParsePosition(0);
		Date end_time = formatter.parse(et, po);
		Test_total tt = new Test_total(Integer.valueOf(test_id), test_name, lesson_name, teacher_name, test_password,
				begin_time, end_time);
		boolean flag = tts.edictTestTotal(tt);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageAllTest");
		} else {
			response.getWriter().print("修改失败");
		}
	}

	private void showTestTotal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Test_total test = tts.findTestTotalById(Integer.valueOf(id));
		request.setAttribute("test", test);
		request.getRequestDispatcher("admin/edict_test_list.jsp").forward(request, response);
	}

	private void deleteTest(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String id = request.getParameter("id");
		boolean flag = tts.deleteTest(Integer.valueOf(id));
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageAllTest");
		} else {
			response.getWriter().print("删除失败");
		}
	}

	private void manageEndTest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Test_total> test = tts.findEndtests();
		request.setAttribute("test", test);
		request.getRequestDispatcher("admin/test_end.jsp").forward(request, response);
	}

	private void manageUnendTest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Test_total> test = tts.findUnendtests();
		request.setAttribute("test", test);
		request.getRequestDispatcher("admin/test_unend.jsp").forward(request, response);
	}

	private void manageAllTest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Test_total> test = tts.findAlltests();
		request.setAttribute("test", test);
		request.getRequestDispatcher("admin/test_list.jsp").forward(request, response);
	}

	private void deleteLm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String lm_id = request.getParameter("lm_id");
		boolean flag = lms.deleteLessonmaterialById(lm_id);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageAllLm");
		} else {
			response.getWriter().print("删除失败");
		}
	}

	private void manageAllLm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Learning_materials> lm = lms.findAllLm();
		request.setAttribute("lm", lm);
		request.getRequestDispatcher("admin/lm_list.jsp").forward(request, response);
	}

	private void deleteHomeworkStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String homework_id = request.getParameter("homework_id");
		String student_name = request.getParameter("student_name");
		boolean flag = hss.deletehomeworkStudent(homework_id, student_name);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageHomeworkStudent");
		} else {
			response.getWriter().print("删除失败");
		}
	}

	private void manageHomeworkStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Homework_student> homework = hss.findAllhomeworkStudent();
		request.setAttribute("homework", homework);
		request.getRequestDispatcher("admin/homework_student.jsp").forward(request, response);
	}

	private void deleteHomework(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String homework_id = request.getParameter("homework_id");
		boolean flag = hts.deletehomeworkById(homework_id);
		if (flag) {
			response.sendRedirect("ManagerServlet?method=manageHomeworkTeacher");
		} else {
			response.getWriter().print("删除失败");
		}
	}

	private void manageHomeworkTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Homework_teacher> homework = hts.findAllhomeworkTeacher();
		request.setAttribute("homework", homework);
		request.getRequestDispatcher("admin/homework_teacher.jsp").forward(request, response);
	}

}

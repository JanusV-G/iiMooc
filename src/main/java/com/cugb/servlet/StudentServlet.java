package com.cugb.servlet;

import com.cugb.dao.Lesson_selectedDao;
import com.cugb.entity.*;
import com.cugb.service.*;
import com.cugb.utils.PageTool;

import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static StudentService ss = new StudentService();
    private static Lesson_selectedService lss = new Lesson_selectedService();
    private static LessonService ls = new LessonService();
    private static Learning_materialsService lms = new Learning_materialsService();
    private static VideoService vs = new VideoService();
    private static Homework_teacherService hts = new Homework_teacherService();
    private static Test_totalService tts = new Test_totalService();
    private static TestService ts = new TestService();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理中文乱码问题
        //1、请求乱码
        request.setCharacterEncoding("UTF-8");
        //2、响应乱码
        response.setContentType("text/html;charset=UTF-8");
        //获取页面提交过来的请求数据
        String method = request.getParameter("method");
        switch (method) {
            case "searchAllActiveLesson": {
                searchAllActiveLesson(request, response);
                break;
            }
            case "searchAllStopLesson": {
                searchAllStopLesson(request, response);
                break;
            }
            case "courseSelection": {
                courseSelection(request, response);
                break;
            }
            case "showLearningMain": {
                showLearningMain(request, response);
                break;
            }
            case "showLearningMaterial": {
                showLearningMaterial(request, response);
                break;
            }
            case "showAllLesson": {
                showAllLesson(request, response);
                break;
            }
            case "showLearningHomework": {
                showLearningHomework(request, response);
                break;
            }
            case "showLearningExam": {
                showLearningExam(request, response);
                break;
            }
            case "showLearningExamDetail": {
                showLearningExamDetail(request, response);
                break;
            }
//            case "showLearningDiscussion": {
//
//                break;
//            }
            case "studentLearningVideoDetail": {
                studentLearningVideoDetail(request, response);
                break;
            }
            default: {
                System.out.println(this.getClass().getName() + " 异常method: " + method);
            }

        }
    }

    private void showAllLesson(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showAllLesson");

//        int totalCount=ls.getTotalCount();
//        String currentPage=request.getParameter("currentPage");
//        PageTool tool=new PageTool(totalCount,currentPage);
        List<Lesson> lessonList = ls.findLessonByPage();
        System.out.println(this.getClass().getName() + " 长度:" + lessonList.size());

        request.setAttribute("lessonList", lessonList);
        request.getRequestDispatcher("studentLessonHall.jsp").forward(request,response);

    }


        private void showLearningExamDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningExam");

        String testID = request.getParameter("testID");
        System.out.println(this.getClass().getName() + " 考试ID:" + testID);
        List<Test> testList = ts.findPaperById(Integer.parseInt(testID));
        System.out.println(this.getClass().getName() + " 题目数量:" + testList.size());


        request.setAttribute("testList", testList);
        request.getRequestDispatcher("studentLearningExamDetail.jsp").forward(request, response);

    }


    private void showLearningExam(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningExam");
        //从域中获取课程名
        HttpSession session = request.getSession();
        Lesson lesson = (Lesson) session.getAttribute("lessonNow");
        String lessonName = lesson.getLesson_name();
        System.out.println(this.getClass().getName() + " 课程名: " + lessonName);

        List<Test_total> test_totalList = tts.findTest_total("lesson_name", lessonName);
        System.out.println(this.getClass().getName() + " 获取到的考试数量: " + test_totalList.size());

//        Date nowDate=new Date();
//        request.setAttribute("nowDate",nowDate);
        request.setAttribute("test_totalList", test_totalList);
        request.getRequestDispatcher("studentLearningExam.jsp").forward(request, response);

    }


    private void showLearningHomework(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningMain");

        HttpSession session = request.getSession();
        Lesson lesson = (Lesson) session.getAttribute("lessonNow");
        String lessonName = lesson.getLesson_name();
        System.out.println(this.getClass().getName() + " 课程名: " + lessonName);

        List<Homework_teacher> homework_teacherList = hts.findHomework("lesson_name", lessonName);
        System.out.println(this.getClass().getName() + " homework数量: " + homework_teacherList.size());

        request.setAttribute("homework_teacherList", homework_teacherList);
        request.getRequestDispatcher("studentLearningHomework.jsp").forward(request, response);

    }

    private void studentLearningVideoDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningMain");
        //获取课程ID并查找
        String videoID = request.getParameter("videoID");
        Video video = vs.findVideoById(videoID);
        System.out.println(this.getClass().getName() + " 视频地址:" + video.getVideo_file());

        //获取当前课程信息
        HttpSession session = request.getSession();
        Lesson lesson = (Lesson) session.getAttribute("lessonNow");
        //根据课程名查找视频:
        String lessonName = lesson.getLesson_name();
        List<Video> videoList = vs.findAllVideo("lesson_name", lessonName);
        //传递信息并跳转
        request.setAttribute("videoList", videoList);
        request.setAttribute("videoNow", video);
        request.getRequestDispatcher("studentLearningVideoDetail.jsp").forward(request, response);
    }

    //显示学生学习主页, 即课程的章节信息
    private void showLearningMain(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningMain");

        //获取数据;
        String lessonID = request.getParameter("lessonID");
        //根据ID查找指定课程
        Lesson lesson = ls.findLessonById(lessonID);
        //将课程添加到域中:
        HttpSession session = request.getSession();
        session.setAttribute("lessonNow", lesson);

        //根据课程名称查找所有相关的video, 不分页
        String lessonName = lesson.getLesson_name();
        System.out.println(this.getClass().getName() + " lessonName:" + lessonName);
        List<Video> videoList = vs.findAllVideo("lesson_name", lessonName);
        System.out.println(this.getClass().getName() + " 长度: " + videoList.size());

        //传递参数并跳转
        request.setAttribute("videoList", videoList);
        request.getRequestDispatcher("studentLearningMain.jsp").forward(request, response);

    }

    private void showLearningMaterial(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningMaterial");

        HttpSession session = request.getSession();
        Lesson lesson = (Lesson) session.getAttribute("lessonNow");

        String lessonName = lesson.getLesson_name();
        System.out.println(this.getClass().getName() + " lessonName:" + lessonName);

        int totalCount = lms.getTotalCount("lesson_name", lessonName);
        System.out.println(this.getClass().getName() + " totalCount=" + totalCount);

        String currentPage = request.getParameter("currentPage");
        PageTool tool = new PageTool(totalCount, currentPage);
        List<Learning_materials> learningMaterialsList = lms.findLMByLessonName(tool, lessonName);
        System.out.println(this.getClass().getName() + " 长度: " + learningMaterialsList.size());


        request.setAttribute("Learning_materials", learningMaterialsList);
        request.setAttribute("tool", tool);

        request.getRequestDispatcher("studentLearningMaterial.jsp").forward(request, response);

    }


    //学生选课:
    private void courseSelection(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " courseSelection");
        //获取课程ID & 学生ID
        int Lesson_id = Integer.parseInt(request.getParameter("lesson_id"));
        HttpSession session = request.getSession();
        User student = (User) session.getAttribute("login_user");
        //调用service层添加课程, 并获取结果
        boolean flag = lss.courseSelection(student.getUser_id(), Lesson_id);
        //这里前端应该使用ajax
        //将结果传回ajax
        if (flag) {
        	Lesson lesson=new Lesson(Lesson_id);
        	ls.updateLessonById2(lesson);
            System.out.println(this.getClass().getName() + " 选课成功");
            response.sendRedirect("StudentServlet?method=searchAllActiveLesson");
        } else {
            System.out.println(this.getClass().getName() + " 选课失败");
//            response.getWriter().print("false");
            response.sendRedirect("StudentServlet?method=searchAllActiveLesson");
        }
    }

    //检索所有进行中课程:
    private void searchAllActiveLesson(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug;
        System.out.println(this.getClass().getName() + " searchAllActiveLesson");
        //获取session对象
        HttpSession session = request.getSession();
        //获取储存在session中的user信息
        User student = (User) session.getAttribute("login_user");
        //debug:
        System.out.println(this.getClass().getName() + " UserID=" + student.getUser_id());
        //获取课程列表:
        List<Lesson> activeLessonList = lss.searchAllActiveLesson(student.getUser_id());
        //debug:
        System.out.println(this.getClass().getName() + " 长度:" + activeLessonList.size());

        //不分页, 直接显示:
        request.setAttribute("activeLessonList", activeLessonList);
        request.getRequestDispatcher("index_student.jsp").forward(request, response);


    }

    //检索所有已结课课程:
    private void searchAllStopLesson(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug;
        System.out.println(this.getClass().getName() + " searchAllStopLesson");
        //获取session对象
        HttpSession session = request.getSession();
        //获取储存在session中的user信息
        User student = (User) session.getAttribute("login_user");
        //debug:
        System.out.println(this.getClass().getName() + " UserID=" + student.getUser_id());
        //获取课程列表:
        List<Lesson> activeLessonList = lss.searchAllStopLesson(student.getUser_id());
        //debug:
        System.out.println(this.getClass().getName() + " 长度:" + activeLessonList.size());

        //不分页, 直接显示:
        request.setAttribute("activeLessonList", activeLessonList);
        request.getRequestDispatcher("StudentStopLesson.jsp").forward(request, response);
    }

}

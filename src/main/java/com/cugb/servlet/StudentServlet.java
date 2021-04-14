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
        //����������������
        //1����������
        request.setCharacterEncoding("UTF-8");
        //2����Ӧ����
        response.setContentType("text/html;charset=UTF-8");
        //��ȡҳ���ύ��������������
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
                System.out.println(this.getClass().getName() + " �쳣method: " + method);
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
        System.out.println(this.getClass().getName() + " ����:" + lessonList.size());

        request.setAttribute("lessonList", lessonList);
        request.getRequestDispatcher("studentLessonHall.jsp").forward(request,response);

    }


        private void showLearningExamDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningExam");

        String testID = request.getParameter("testID");
        System.out.println(this.getClass().getName() + " ����ID:" + testID);
        List<Test> testList = ts.findPaperById(Integer.parseInt(testID));
        System.out.println(this.getClass().getName() + " ��Ŀ����:" + testList.size());


        request.setAttribute("testList", testList);
        request.getRequestDispatcher("studentLearningExamDetail.jsp").forward(request, response);

    }


    private void showLearningExam(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningExam");
        //�����л�ȡ�γ���
        HttpSession session = request.getSession();
        Lesson lesson = (Lesson) session.getAttribute("lessonNow");
        String lessonName = lesson.getLesson_name();
        System.out.println(this.getClass().getName() + " �γ���: " + lessonName);

        List<Test_total> test_totalList = tts.findTest_total("lesson_name", lessonName);
        System.out.println(this.getClass().getName() + " ��ȡ���Ŀ�������: " + test_totalList.size());

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
        System.out.println(this.getClass().getName() + " �γ���: " + lessonName);

        List<Homework_teacher> homework_teacherList = hts.findHomework("lesson_name", lessonName);
        System.out.println(this.getClass().getName() + " homework����: " + homework_teacherList.size());

        request.setAttribute("homework_teacherList", homework_teacherList);
        request.getRequestDispatcher("studentLearningHomework.jsp").forward(request, response);

    }

    private void studentLearningVideoDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningMain");
        //��ȡ�γ�ID������
        String videoID = request.getParameter("videoID");
        Video video = vs.findVideoById(videoID);
        System.out.println(this.getClass().getName() + " ��Ƶ��ַ:" + video.getVideo_file());

        //��ȡ��ǰ�γ���Ϣ
        HttpSession session = request.getSession();
        Lesson lesson = (Lesson) session.getAttribute("lessonNow");
        //���ݿγ���������Ƶ:
        String lessonName = lesson.getLesson_name();
        List<Video> videoList = vs.findAllVideo("lesson_name", lessonName);
        //������Ϣ����ת
        request.setAttribute("videoList", videoList);
        request.setAttribute("videoNow", video);
        request.getRequestDispatcher("studentLearningVideoDetail.jsp").forward(request, response);
    }

    //��ʾѧ��ѧϰ��ҳ, ���γ̵��½���Ϣ
    private void showLearningMain(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " showLearningMain");

        //��ȡ����;
        String lessonID = request.getParameter("lessonID");
        //����ID����ָ���γ�
        Lesson lesson = ls.findLessonById(lessonID);
        //���γ���ӵ�����:
        HttpSession session = request.getSession();
        session.setAttribute("lessonNow", lesson);

        //���ݿγ����Ʋ���������ص�video, ����ҳ
        String lessonName = lesson.getLesson_name();
        System.out.println(this.getClass().getName() + " lessonName:" + lessonName);
        List<Video> videoList = vs.findAllVideo("lesson_name", lessonName);
        System.out.println(this.getClass().getName() + " ����: " + videoList.size());

        //���ݲ�������ת
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
        System.out.println(this.getClass().getName() + " ����: " + learningMaterialsList.size());


        request.setAttribute("Learning_materials", learningMaterialsList);
        request.setAttribute("tool", tool);

        request.getRequestDispatcher("studentLearningMaterial.jsp").forward(request, response);

    }


    //ѧ��ѡ��:
    private void courseSelection(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug:
        System.out.println(this.getClass().getName() + " courseSelection");
        //��ȡ�γ�ID & ѧ��ID
        int Lesson_id = Integer.parseInt(request.getParameter("lesson_id"));
        HttpSession session = request.getSession();
        User student = (User) session.getAttribute("login_user");
        //����service����ӿγ�, ����ȡ���
        boolean flag = lss.courseSelection(student.getUser_id(), Lesson_id);
        //����ǰ��Ӧ��ʹ��ajax
        //���������ajax
        if (flag) {
        	Lesson lesson=new Lesson(Lesson_id);
        	ls.updateLessonById2(lesson);
            System.out.println(this.getClass().getName() + " ѡ�γɹ�");
            response.sendRedirect("StudentServlet?method=searchAllActiveLesson");
        } else {
            System.out.println(this.getClass().getName() + " ѡ��ʧ��");
//            response.getWriter().print("false");
            response.sendRedirect("StudentServlet?method=searchAllActiveLesson");
        }
    }

    //�������н����пγ�:
    private void searchAllActiveLesson(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug;
        System.out.println(this.getClass().getName() + " searchAllActiveLesson");
        //��ȡsession����
        HttpSession session = request.getSession();
        //��ȡ������session�е�user��Ϣ
        User student = (User) session.getAttribute("login_user");
        //debug:
        System.out.println(this.getClass().getName() + " UserID=" + student.getUser_id());
        //��ȡ�γ��б�:
        List<Lesson> activeLessonList = lss.searchAllActiveLesson(student.getUser_id());
        //debug:
        System.out.println(this.getClass().getName() + " ����:" + activeLessonList.size());

        //����ҳ, ֱ����ʾ:
        request.setAttribute("activeLessonList", activeLessonList);
        request.getRequestDispatcher("index_student.jsp").forward(request, response);


    }

    //���������ѽ�ογ�:
    private void searchAllStopLesson(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //debug;
        System.out.println(this.getClass().getName() + " searchAllStopLesson");
        //��ȡsession����
        HttpSession session = request.getSession();
        //��ȡ������session�е�user��Ϣ
        User student = (User) session.getAttribute("login_user");
        //debug:
        System.out.println(this.getClass().getName() + " UserID=" + student.getUser_id());
        //��ȡ�γ��б�:
        List<Lesson> activeLessonList = lss.searchAllStopLesson(student.getUser_id());
        //debug:
        System.out.println(this.getClass().getName() + " ����:" + activeLessonList.size());

        //����ҳ, ֱ����ʾ:
        request.setAttribute("activeLessonList", activeLessonList);
        request.getRequestDispatcher("StudentStopLesson.jsp").forward(request, response);
    }

}

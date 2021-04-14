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

import com.cugb.entity.Learning_materials;
import com.cugb.service.Learning_materialsService;
import com.cugb.utils.DateTool;
import com.cugb.utils.FileUploadTool;
import com.cugb.utils.PageTool;


@WebServlet("/Learning_materialsServlet")
@MultipartConfig
public class Learning_materialsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Learning_materialsService ls = new Learning_materialsService();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //乱码处理
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        switch (method) {
            case "addMaterial":
                addMaterial(request, response);
                break;
            case "findmaterial":
                findmaterial(request, response);
                break;
            case "updateToShow":
                updateToShow(request, response);
                break;
            case "updatematerial":
                updatematerial(request, response);
                break;
            case "deleteLessonmaterial":{
                deleteLessonmaterial(request, response);
                break;
            }
            case "findMaterialByLessonName":{
                findMaterialByLessonName(request,response);
                break;
            }


            default:{
                System.out.println(this.getClass().getName()+" 异常method: "+method);
            }
        }
    }

    private void findMaterialByLessonName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(this.getClass().getName()+ " findMaterialByLessonName");

        //todo: 获取课程name
        String lessonName="";
        int totalCount=ls.getTotalCount("lesson_name",lessonName);
        String currentPage = request.getParameter("currentPage");
        PageTool tool=new PageTool(totalCount,currentPage);
        List<Learning_materials> learningMaterialsList = ls.findLMByLessonName(tool, lessonName);
        request.setAttribute("learningMaterialsList",learningMaterialsList);
        request.setAttribute("tool",tool);

        //todo: 跳转到指定页面
        request.getRequestDispatcher("").forward(request,response);

    }

    private void deleteLessonmaterial(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String lessonmaterialids = request.getParameter("lids");
        boolean flag = ls.deleteLessonmaterialById(lessonmaterialids);
        if (flag) {
            response.sendRedirect("Learning_materialsServlet?method=findmaterial");
        }
    }

    private void updatematerial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String Lm_id=request.getParameter("Lm_id");
    	String Lm_name = request.getParameter("Lm_name");
        HttpSession session=request.getSession();
		String Upload_user_name=(String)session.getAttribute("user_name");
        String Lesson_name = request.getParameter("Lesson_name");
        String Lm_description = request.getParameter("Lm_description");
        String Lm_create_time = request.getParameter("Lm_create_time");
        Part part = request.getPart("Lm_file");
        String Lm_file = FileUploadTool.FileUpload("updatelm.jsp", part, request, response);
        if (!Lm_file.equals("")) {
            Learning_materials Learning_materials = new Learning_materials(Integer.valueOf(Lm_id),Lm_name, Upload_user_name, Lesson_name, Lm_file, Lm_description, DateTool.stringToDate(Lm_create_time));
            boolean flag = ls.updatematerial(Learning_materials);
            if (flag) {
                response.sendRedirect("index_teacher.jsp");
            }
        }
    }

    private void updateToShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String lm_name = request.getParameter("lm_name");
        Learning_materials Learning_materials = ls.findLessonmaterialBylm(lm_name);
        request.setAttribute("Learning_materials", Learning_materials);
        request.getRequestDispatcher("updatelm.jsp").forward(request, response);
    }
	//所有资料分页查找:
    private void findmaterial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int totalCount = ls.getTotalCount();
        String currentPage = request.getParameter("currentPage");
        HttpSession session = request.getSession();
        String teacher_name = (String) session.getAttribute("user_name");
        //创建对象
        PageTool tool = new PageTool(totalCount, currentPage);
        List<Learning_materials> Learning_materials = ls.findLessonmaterialByPage(tool, teacher_name);
        //域对象
        request.setAttribute("Learning_materials", Learning_materials);
        request.setAttribute("tool", tool);
        request.getRequestDispatcher("learningmeterial.jsp").forward(request, response);
    }

    private void addMaterial(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String Lm_name = request.getParameter("Lm_name");
        HttpSession session=request.getSession();
		String Upload_user_name=(String)session.getAttribute("user_name");
        String Lesson_name = request.getParameter("Lesson_name");
        String Lm_description = request.getParameter("Lm_description");
        String Lm_create_time = request.getParameter("Lm_create_time");
        Part part = request.getPart("Lm_file");
        String Lm_file = FileUploadTool.FileUpload("insertlm.jsp", part, request, response);
        if (!Lm_file.equals("")) {
            Learning_materials Learning_materials = new Learning_materials(Lm_name, Upload_user_name, Lesson_name, Lm_file, Lm_description, DateTool.stringToDate(Lm_create_time));
            boolean flag = ls.addMaterial(Learning_materials);
            if (flag) {
                request.getRequestDispatcher("index_teacher.jsp").forward(request, response);
            }
        }

    }

}

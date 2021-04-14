package com.cugb.service;

import java.util.List;

import com.cugb.dao.Homework_teacherDao;
import com.cugb.entity.Homework_student;
import com.cugb.entity.Homework_teacher;
import com.cugb.entity.Learning_materials;
import com.cugb.entity.Test_paper;
import com.cugb.utils.PageTool;

public class Homework_teacherService {
    Homework_teacherDao hd = new Homework_teacherDao();


    public boolean addhomework(Homework_teacher homework_teacher) {

        return hd.addhomework(homework_teacher) > 0;
    }


    public int getTotalCount() {
        return hd.getTotalCount();
    }


    public List<Homework_teacher> findhomeworkByPage(PageTool tool, String teacher_name) {
        List<Homework_teacher> list = hd.findhomeworkByPage(tool, teacher_name);
        return list;
    }


    public boolean deletehomeworkById(String homeworklids) {
        return hd.deletehomeworkById(homeworklids) > 0;
    }


    public Homework_teacher findhomeworkByld(String homework_id) {
        return hd.findhomeworkByld(homework_id);
    }
    public Test_paper findexamBysn(String student_name) {
        return hd.findexamBysn(student_name);
    }
    public List<Homework_teacher> findHomework(String keyword, String message) {
        return hd.findHomework(keyword, message);
    }


    public boolean updatehomework(Homework_teacher Homework_teacher) {
        return hd.updatehomework(Homework_teacher) > 0;
    }
    public List<Homework_student> findstuhomeworkbytname(PageTool tool, String teacher_name) {
		List<Homework_student> list=hd.findstuhomeworkbytname(tool,teacher_name);
		return list;
	}
    public List<Test_paper> findexambytname(PageTool tool, String teacher_name) {
		List<Test_paper> list=hd.findexambytname(tool,teacher_name);
		return list;
	}


	public Homework_student findstuhomeworkByld(String studentwork_id) {
		return hd.findstuhomeworkByld(studentwork_id);
	}


	public boolean updatescore(Homework_student homework_student) {
		return hd.updatescore(homework_student)>0?true:false;
	}


	public boolean updateexamscore(Test_paper test_paper) {
		return hd.updateexamscore(test_paper)>0?true:false;
	}

	public List<Homework_teacher> findAllhomeworkTeacher() {
		// TODO Auto-generated method stub
		return hd.findAllhomeworkTeacher();
	}
	public boolean deleteManyHomeworkTeacher(String uids) {
		// TODO Auto-generated method stub
		return hd.deleteManyHomeworkTeacher(uids)>0?true:false;
	}
	public boolean deletehomeworkBylname(String lname) {
		 return hd.deletehomeworkBylname(lname)>0?true:false;
	}

}

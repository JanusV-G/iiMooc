package com.cugb.service;

import java.util.List;

import com.cugb.dao.Homework_studentDao;
import com.cugb.dao.Homework_teacherDao;
import com.cugb.entity.Homework_student;
import com.cugb.entity.Homework_teacher;

public class Homework_studentService {
	Homework_studentDao hd = new Homework_studentDao();
	Homework_teacherDao htd = new Homework_teacherDao();
	Homework_studentDao hsd = new Homework_studentDao();
	
	//ͨ��id������ҵ
	public Homework_teacher findHomeworkById(int homework_id) {	
		return htd.findHomeworkById(homework_id);
	}

	//���ѧ����ҵ������Ϣ
	public boolean addOrUpdateHomeworkInfo(Homework_student hstu) {
		if(hd.judgeIfExist(hstu)==null) {
			System.out.println("�������ѧ����ҵ��Ϣ");
			return hd.addHomeworkInfo(hstu)>0?true:false;
		}else {
			System.out.println("��������ѧ����ҵ��Ϣ");
			return hd.updateHomeworkInfo(hstu)>0?true:false;
		}
		
	}

	//����ѧ���ύ�Ĵ�
	public boolean updateAnswer(int homework_id, String submit_file) {
		return hd.updateAnswer(homework_id,submit_file)>0?true:false;
	}
	
	public List<Homework_student> findAllhomeworkStudent() {
		// TODO Auto-generated method stub
		return hsd.findAllhomeworkStudent();
	}
	
	
	public boolean deletehomeworkStudent(String homework_id, String student_name) {
		// TODO Auto-generated method stub
		return hsd.deletehomeworkStudent(homework_id, student_name)>0?true:false;
	}
	public boolean deleteManyHomeworkStudent(String uids) {
		// TODO Auto-generated method stub
		return hsd.deleteManyHomeworkStudent(uids)>0?true:false;
	}
}

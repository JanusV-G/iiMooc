package com.cugb.service;

import java.util.List;

import com.cugb.dao.LessonDao;
import com.cugb.entity.Lesson;
import com.cugb.utils.PageTool;

public class LessonService {
	LessonDao ld=new LessonDao();
 	//��ҳ��ѯ
	public List<Lesson> findLessonByPage(PageTool tool,String name){
		return ld.findLessonByPage(tool,name);
	}
	//��ʾ���пγ�(��ҳ):
	public List<Lesson> findLessonByPage(PageTool tool){
		return ld.findLessonByPage(tool);
	}
	//��ʾ���пγ�(����ҳ)
	public List<Lesson> findLessonByPage(){
		return ld.findLesson();
	}
	//�ܼ�¼��
	public int getTotalCount() {
		return ld.getTotalCount();
	}
	//��ӿγ�
	public boolean addLesson(Lesson lesson) {
		return ld.addLesson(lesson) > 0;
	}
	//ɾ���γ�
	public boolean deleteLessonById(String id) {
		return ld.deleteLessonById(id) > 0;
	}
	//�鿴�γ���Ϣ
	public Lesson findLessonById(String id) {
		return ld.findLessonById(id);
	}
	//�޸�
	public boolean updateLessonById(Lesson lesson) {
		return ld.updateLessonById(lesson) > 0;
	}
	//�޸���Ƶ����
	public boolean updateLessonByName(Lesson lesson) {
		return ld.updateLessonByName(lesson) > 0?true:false;
	}
	public List<Lesson> findAllLesson(String name) {
		return ld.findAllLesson(name);
	}
	//����ѧ������
	public boolean updateLessonById2(Lesson lesson) {
		// TODO Auto-generated method stub
		return ld.updateLessonById2(lesson) > 0?true:false;
	}
	public boolean deleteLessonBylname(String lname) {
		return ld.deleteLessonBylname(lname) > 0;
	}
}

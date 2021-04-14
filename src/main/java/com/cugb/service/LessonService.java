package com.cugb.service;

import java.util.List;

import com.cugb.dao.LessonDao;
import com.cugb.entity.Lesson;
import com.cugb.utils.PageTool;

public class LessonService {
	LessonDao ld=new LessonDao();
 	//分页查询
	public List<Lesson> findLessonByPage(PageTool tool,String name){
		return ld.findLessonByPage(tool,name);
	}
	//显示所有课程(分页):
	public List<Lesson> findLessonByPage(PageTool tool){
		return ld.findLessonByPage(tool);
	}
	//显示所有课程(不分页)
	public List<Lesson> findLessonByPage(){
		return ld.findLesson();
	}
	//总记录数
	public int getTotalCount() {
		return ld.getTotalCount();
	}
	//添加课程
	public boolean addLesson(Lesson lesson) {
		return ld.addLesson(lesson) > 0;
	}
	//删除课程
	public boolean deleteLessonById(String id) {
		return ld.deleteLessonById(id) > 0;
	}
	//查看课程信息
	public Lesson findLessonById(String id) {
		return ld.findLessonById(id);
	}
	//修改
	public boolean updateLessonById(Lesson lesson) {
		return ld.updateLessonById(lesson) > 0;
	}
	//修改视频数量
	public boolean updateLessonByName(Lesson lesson) {
		return ld.updateLessonByName(lesson) > 0?true:false;
	}
	public List<Lesson> findAllLesson(String name) {
		return ld.findAllLesson(name);
	}
	//增加学生数量
	public boolean updateLessonById2(Lesson lesson) {
		// TODO Auto-generated method stub
		return ld.updateLessonById2(lesson) > 0?true:false;
	}
	public boolean deleteLessonBylname(String lname) {
		return ld.deleteLessonBylname(lname) > 0;
	}
}

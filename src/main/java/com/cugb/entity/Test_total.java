package com.cugb.entity;

import java.util.Date;

//考试表
public class Test_total {
	private int test_id;//分配的id
	private String test_name;//考试的名字
	private String lesson_name;//所属课程
	private String teacher_name;//发布老师名字
	private String test_password;//进入考试输入的密码
	private Date begin_time;//开始时间
	private Date end_time;//结束时间
	
	
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public String getTest_name() {
		return test_name;
	}
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	public String getLesson_name() {
		return lesson_name;
	}
	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTest_password() {
		return test_password;
	}
	public void setTest_password(String test_password) {
		this.test_password = test_password;
	}
	public Date getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(Date begin_time) {
		this.begin_time = begin_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Test_total(int test_id,String test_name, String lesson_name, String teacher_name, String test_password, Date begin_time,
			Date end_time) {
		super();
		this.test_id = test_id;
		this.test_name = test_name;
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
		this.test_password = test_password;
		this.begin_time = begin_time;
		this.end_time = end_time;
	}
	
	public Test_total(String test_name, String lesson_name, String teacher_name, String test_password, Date begin_time,
			Date end_time) {
		super();
		this.test_name = test_name;
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
		this.test_password = test_password;
		this.begin_time = begin_time;
		this.end_time = end_time;
	}
	public Test_total() {}
	
}

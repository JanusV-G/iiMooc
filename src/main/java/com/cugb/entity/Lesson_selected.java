package com.cugb.entity;
//课程选择表，xx学生选了啥课，xx老师教了啥课
public class Lesson_selected {
	private String user_name;//学生姓名
	private String lesson_name;//课程名字
	private int finish_account;//完成视频的数量
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLesson_name() {
		return lesson_name;
	}
	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}
	public int getFinish_account() {
		return finish_account;
	}
	public void setFinish_account(int finish_account) {
		this.finish_account = finish_account;
	}
	
	
}

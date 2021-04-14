package com.cugb.entity;

import java.util.Date;

//��ʦ���õ���ҵ
public class Homework_teacher {
	private int homework_id;//�����id
	private String homework_name;//��ҵ����
	private String lesson_name;//�����γ�
	private String teacher_name;//������ҵ����ʦ����
	private String homework_file;//�ļ�
	private String homework_description;//����
	private Date homework_create_time;//����ʱ��
	
	public Homework_teacher() {}
	public Homework_teacher(int homework_id, String homework_name, String lesson_name, String teacher_name,
			String homework_file, String homework_description, Date homework_create_time) {
		super();
		this.homework_id = homework_id;
		this.homework_name = homework_name;
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
		this.homework_file = homework_file;
		this.homework_description = homework_description;
		this.homework_create_time = homework_create_time;
	}
	public Homework_teacher(String homework_name, String lesson_name, String teacher_name, String homework_file,
			String homework_description, Date homework_create_time) {
		super();
		this.homework_name = homework_name;
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
		this.homework_file = homework_file;
		this.homework_description = homework_description;
		this.homework_create_time = homework_create_time;
	}
	public int getHomework_id() {
		return homework_id;
	}
	public void setHomework_id(int homework_id) {
		this.homework_id = homework_id;
	}
	public String getHomework_name() {
		return homework_name;
	}
	public void setHomework_name(String homework_name) {
		this.homework_name = homework_name;
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
	public String getHomework_file() {
		return homework_file;
	}
	public void setHomework_file(String homework_file) {
		this.homework_file = homework_file;
	}
	public String getHomework_description() {
		return homework_description;
	}
	public void setHomework_description(String homework_description) {
		this.homework_description = homework_description;
	}
	public Date getHomework_create_time() {
		return homework_create_time;
	}
	public void setHomework_create_time(Date homework_create_time) {
		this.homework_create_time = homework_create_time;
	}
	
	
}

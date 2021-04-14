package com.cugb.entity;



//学生提交的作业
public class Homework_student {
	private String student_name;//学生名字
	private int homework_id;//作业id
	private String homework_name;//作业名字
	private String teacher_name;//批阅老师名字
	private String submit_file;//文件
	private double homework_score;//得分
	private String homework_comment;//评语
	
	public Homework_student() {}
	public Homework_student(String student_name, int homework_id, String homework_name, String teacher_name,
			String submit_file, double homework_score, String homework_comment) {
		super();
		this.student_name = student_name;
		this.homework_id = homework_id;
		this.homework_name = homework_name;
		this.teacher_name = teacher_name;
		this.submit_file = submit_file;
		this.homework_score = homework_score;
		this.homework_comment = homework_comment;
	}
	
	public Homework_student(int homework_id, double homework_score, String homework_comment) {
		super();
		this.homework_id = homework_id;
		this.homework_score = homework_score;
		this.homework_comment = homework_comment;
	}
	public Homework_student(String student_name, int homework_id, String homework_name, String teacher_name) {
		super();
		this.student_name = student_name;
		this.homework_id = homework_id;
		this.homework_name = homework_name;
		this.teacher_name = teacher_name;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
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
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getSubmit_file() {
		return submit_file;
	}
	public void setSubmit_file(String submit_file) {
		this.submit_file = submit_file;
	}
	public double getHomework_score() {
		return homework_score;
	}
	public void setHomework_score(double homework_score) {
		this.homework_score = homework_score;
	}
	public String getHomework_comment() {
		return homework_comment;
	}
	public void setHomework_comment(String homework_comment) {
		this.homework_comment = homework_comment;
	}
	
	
}

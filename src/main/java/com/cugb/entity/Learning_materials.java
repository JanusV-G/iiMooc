package com.cugb.entity;


import java.util.Date;


//�ϴ�ѧϰ���ϱ�
public class Learning_materials {
	private int lm_id;//ϵͳ�����id
	public Learning_materials(int lm_id, String lm_name, String upload_user_name, String lesson_name, String lm_file,
			String lm_description, Date lm_create_time) {
		super();
		this.lm_id = lm_id;
		this.lm_name = lm_name;
		this.upload_user_name = upload_user_name;
		this.lesson_name = lesson_name;
		this.lm_file = lm_file;
		this.lm_description = lm_description;
		this.lm_create_time = lm_create_time;
	}
	private String lm_name;//ѧϰ��������
	private String upload_user_name;//�ϴ�������
	private String lesson_name;//�����γ�����
	private String lm_file;//�ļ�
	private String lm_description;//����
	private Date lm_create_time;//����ʱ��
	
	public Learning_materials() {}
	public Learning_materials(String lm_name, String upload_user_name, String lesson_name, String lm_file,
			String lm_description, Date lm_create_time) {
		super();
		this.lm_name = lm_name;
		this.upload_user_name = upload_user_name;
		this.lesson_name = lesson_name;
		this.lm_file = lm_file;
		this.lm_description = lm_description;
		this.lm_create_time = lm_create_time;
	}
	public int getLm_id() {
		return lm_id;
	}
	public void setLm_id(int lm_id) {
		this.lm_id = lm_id;
	}
	public String getLm_name() {
		return lm_name;
	}
	public void setLm_name(String lm_name) {
		this.lm_name = lm_name;
	}
	public String getUpload_user_name() {
		return upload_user_name;
	}
	public void setUpload_user_name(String upload_user_name) {
		this.upload_user_name = upload_user_name;
	}
	public String getLesson_name() {
		return lesson_name;
	}
	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}

	public String getLm_file() {
		return lm_file;
	}

	public void setLm_file(String lm_file) {
		this.lm_file = lm_file;
	}

	public String getLm_description() {
		return lm_description;
	}
	public void setLm_description(String lm_description) {
		this.lm_description = lm_description;
	}
	public Date getLm_create_time() {
		return lm_create_time;
	}
	public void setLm_create_time(Date lm_create_time) {
		this.lm_create_time = lm_create_time;
	}
	
	
}

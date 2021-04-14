package com.cugb.entity;

import java.util.Date;

//�������α�
public class Video {
	public Video() {
	}
	public Video(String video_name, String upload_user_name, String lesson_name, String video_file,
			String video_description, Date video_create_time) {
		super();
		this.video_name = video_name;
		this.upload_user_name = upload_user_name;
		this.lesson_name = lesson_name;
		this.video_file = video_file;
		this.video_description = video_description;
		this.video_create_time = video_create_time;
	}
	public Video(int video_id, String video_name, String upload_user_name, String lesson_name, String video_file,
			String video_description, Date video_create_time) {
		super();
		this.video_id = video_id;
		this.video_name = video_name;
		this.upload_user_name = upload_user_name;
		this.lesson_name = lesson_name;
		this.video_file = video_file;
		this.video_description = video_description;
		this.video_create_time = video_create_time;
	}
	private int video_id;//ϵͳ�����id
	private String video_name;//��Ƶ����
	private String upload_user_name;//�ϴ�������
	private String lesson_name;//�����γ�����
	private String video_file;//�ļ�
	private String video_description;//����
	private Date video_create_time;//����ʱ��
	
	
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getVideo_name() {
		return video_name;
	}
	public void setVideo_name(String video_name) {
		this.video_name = video_name;
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
	public String getVideo_file() {
		return video_file;
	}

	public void setVideo_file(String video_file) {
		this.video_file = video_file;
	}

	public String getVideo_description() {
		return video_description;
	}
	public void setVideo_description(String video_description) {
		this.video_description = video_description;
	}
	public Date getVideo_create_time() {
		return video_create_time;
	}
	public void setVideo_create_time(Date video_create_time) {
		this.video_create_time = video_create_time;
	}
	
	
}

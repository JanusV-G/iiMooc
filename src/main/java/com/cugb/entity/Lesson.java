package com.cugb.entity;

import java.util.Date;

//课程表
public class Lesson {
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lesson(String lesson_name, String teacher_name, int students_number, int videos_number, String lesson_photo,
			String description, Date lesson_create_time, String flag) {
		super();
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
		this.students_number = students_number;
		this.videos_number = videos_number;
		this.lesson_photo = lesson_photo;
		this.description = description;
		this.lesson_create_time = lesson_create_time;
		this.flag = flag;
	}

	public Lesson(int lesson_id, String lesson_name, String teacher_name, int students_number, String lesson_photo,
			String description, String flag) {
		super();
		this.lesson_id = lesson_id;
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
		this.students_number = students_number;
		this.lesson_photo = lesson_photo;
		this.description = description;
		this.flag = flag;
	}

	public Lesson(int lesson_id, String lesson_name, String teacher_name, int students_number, int videos_number,
			String lesson_photo, String description, Date lesson_create_time, String flag) {
		super();
		this.lesson_id = lesson_id;
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
		this.students_number = students_number;
		this.videos_number = videos_number;
		this.lesson_photo = lesson_photo;
		this.description = description;
		this.lesson_create_time = lesson_create_time;
		this.flag = flag;
	}

	public Lesson(String lesson_name, String teacher_name) {
		super();
		this.lesson_name = lesson_name;
		this.teacher_name = teacher_name;
	}

	public Lesson(int lesson_id) {
		super();
		this.lesson_id = lesson_id;
	}

	private int lesson_id;// 系统分配的课程id
	private String lesson_name;// 课程名字
	private String teacher_name;// 授课老师名字
	private int students_number;// 学生数量
	private int videos_number;// 网课视频数量
	private String lesson_photo;// 课程封面图片
	private String description;// 课程描述
	private Date lesson_create_time;// 创建时间
	private String flag;// 代表课程状态

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getLesson_id() {
		return lesson_id;
	}

	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
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

	public int getStudents_number() {
		return students_number;
	}

	public void setStudents_number(int student_number) {
		this.students_number = student_number;
	}

	public int getVideos_number() {
		return videos_number;
	}

	public void setVideos_number(int videos_number) {
		this.videos_number = videos_number;
	}

	public String getLesson_photo() {
		return lesson_photo;
	}

	public void setLesson_photo(String lesson_photo) {
		this.lesson_photo = lesson_photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLesson_create_time() {
		return lesson_create_time;
	}

	public void setLesson_create_time(Date lesson_create_time) {
		this.lesson_create_time = lesson_create_time;
	}

}

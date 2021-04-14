package com.cugb.entity;
//�û���������ʦѧ������Ա
public class User {
	private int user_id;//ϵͳ�����id
	private String user_name;//����
	private int user_type;//�û�����
	private int user_class;//ѧ����Ҫ��д�༶
	private String student_id;//ѧ��
	private String user_email;//�����ʼ���Ϊ��ϵ��ʽ
	private String user_number;//��¼Ҫ�õ��û���
	private String password;//����
	private String user_photo;//ͷ��

	public User(){}

	public User(String user_name, String student_id, String user_email, String user_photo, int user_id) {
		this.user_name = user_name;
		this.student_id = student_id;
		this.user_email = user_email;
		this.user_photo = user_photo;
		this.user_id=user_id;
	}

	public User(String user_name, int user_type, String student_id, String user_email, String password, String user_photo) {
		this.user_name = user_name;
		this.user_type = user_type;
		this.student_id = student_id;
		this.user_email = user_email;
		this.password = password;
		this.user_photo = user_photo;
	}

	public User(String user_name, int user_type, String student_id, String user_email, String password) {
		this.user_name = user_name;
		this.user_type = user_type;
		this.student_id = student_id;
		this.user_email = user_email;
		this.password = password;
	}
	
	public User(String user_name, int user_type, int user_class, String student_id, String user_email,
			String user_number, String password, String user_photo) {
		super();
		this.user_name = user_name;
		this.user_type = user_type;
		this.user_class = user_class;
		this.student_id = student_id;
		this.user_email = user_email;
		this.user_number = user_number;
		this.password = password;
		this.user_photo = user_photo;
	}
	
	public User(int user_id, String user_name, int user_type, int user_class, String student_id, String user_email,
			String user_number, String password, String user_photo) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_type = user_type;
		this.user_class = user_class;
		this.student_id = student_id;
		this.user_email = user_email;
		this.user_number = user_number;
		this.password = password;
		this.user_photo = user_photo;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public int getUser_class() {
		return user_class;
	}
	public void setUser_class(int user_class) {
		this.user_class = user_class;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_number() {
		return user_number;
	}
	public void setUser_number(String user_number) {
		this.user_number = user_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_photo() {
		return user_photo;
	}
	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}
	
	
}

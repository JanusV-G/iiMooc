package com.cugb.entity;


//学生答题表
public class Test_paper {
	private int test_id;//考试id
	private int problem_number;//题目序号
	private String student_name;//学生的名字
	private int answer_type;//答案的种类，学生需要选择是文本类型答案还是上传的图片
	private String string_answer;//选择文本类型答案后学生的答案放在这里
	private String pic_answer;//选择图片类型答案后学生的答案放在这里
	private String teacher_name;//批阅老师名字
	private double test_score;//得分
	private String test_comment;//评语
	
	public Test_paper () {}
	
	
	
	public Test_paper(String student_name, double test_score, String test_comment) {
		super();
		this.student_name = student_name;
		this.test_score = test_score;
		this.test_comment = test_comment;
	}



	public Test_paper(int test_id, int problem_number , String student_name, String string_answer, String file_answer) {
		super();
		this.test_id = test_id;
		this.problem_number=problem_number;
		this.student_name = student_name;
		this.string_answer = string_answer;
		this.pic_answer = file_answer;
	}



	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public int getProblem_number() {
		return problem_number;
	}
	public void setProblem_number(int problem_number) {
		this.problem_number = problem_number;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getAnswer_type() {
		return answer_type;
	}
	public void setAnswer_type(int answer_type) {
		this.answer_type = answer_type;
	}
	public String getString_answer() {
		return string_answer;
	}
	public void setString_answer(String string_answer) {
		this.string_answer = string_answer;
	}
	public String getPic_answer() {
		return pic_answer;
	}
	public void setPic_answer(String file_answer) {
		this.pic_answer = file_answer;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public double getTest_score() {
		return test_score;
	}
	public void setTest_score(double test_score) {
		this.test_score = test_score;
	}
	public String getTest_comment() {
		return test_comment;
	}
	public void setTest_comment(String test_comment) {
		this.test_comment = test_comment;
	}
	
	
}

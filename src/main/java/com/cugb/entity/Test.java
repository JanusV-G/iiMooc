package com.cugb.entity;



//具体试卷题目表
public class Test {
	private int problem_id;
	private int test_id;//考试的id
	private int problem_number;//考试的序号
	private int problem_type;//题目的类别：填空，选择，大题
	private String problem_photo;//老师上传题目的照片
	private String problem_answer;//题目的答案，选择填空可以自动批阅，这个老师可以选择不上传
	private double problem_score;//题目的分值

	public int getProblem_id() {
		return problem_id;
	}

	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
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
	public int getProblem_type() {
		return problem_type;
	}
	public void setProblem_type(int problem_type) {
		this.problem_type = problem_type;
	}
	public String getProblem_photo() {
		return problem_photo;
	}
	public void setProblem_photo(String problem_photo) {
		this.problem_photo = problem_photo;
	}
	public String getProblem_answer() {
		return problem_answer;
	}
	public void setProblem_answer(String problem_answer) {
		this.problem_answer = problem_answer;
	}
	public double getProblem_score() {
		return problem_score;
	}
	public void setProblem_score(double problem_score) {
		this.problem_score = problem_score;
	}
	public Test(int test_id, int problem_number, int problem_type, String problem_photo, String problem_answer,
			double problem_score) {
		super();
		this.test_id = test_id;
		this.problem_number = problem_number;
		this.problem_type = problem_type;
		this.problem_photo = problem_photo;
		this.problem_answer = problem_answer;
		this.problem_score = problem_score;
	}
	
	public Test(int test_id, int problem_type, String problem_photo, String problem_answer, double problem_score) {
		super();
		this.test_id = test_id;
		this.problem_type = problem_type;
		this.problem_photo = problem_photo;
		this.problem_answer = problem_answer;
		this.problem_score = problem_score;
	}
	public Test() {}
	
}

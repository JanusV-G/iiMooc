package com.cugb.entity;



//�����Ծ���Ŀ��
public class Test {
	private int problem_id;
	private int test_id;//���Ե�id
	private int problem_number;//���Ե����
	private int problem_type;//��Ŀ�������գ�ѡ�񣬴���
	private String problem_photo;//��ʦ�ϴ���Ŀ����Ƭ
	private String problem_answer;//��Ŀ�Ĵ𰸣�ѡ����տ����Զ����ģ������ʦ����ѡ���ϴ�
	private double problem_score;//��Ŀ�ķ�ֵ

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

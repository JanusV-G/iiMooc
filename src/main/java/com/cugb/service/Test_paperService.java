package com.cugb.service;

import java.util.List;

import com.cugb.dao.Test_paperDao;
import com.cugb.entity.Test_paper;

public class Test_paperService {
	Test_paperDao tpd = new Test_paperDao();
	
	
	//根据test_id和problem_nubmer确定某一道试题，然后找到这道试题下所有的学生作答
	public List<Test_paper> findAnswerByProblem(int test_id,int problem_number) {
		// TODO Auto-generated method stub
		return tpd.findAnswerByProblem(test_id,problem_number);
	}

	
	//根据test_id problem_number stuent_name确定某个学生某道题的作答然后删除
	public boolean deleteAnswer(int test_id, int problem_number, String student_name) {
		// TODO Auto-generated method stub
		return tpd.deleteAnswer(test_id,problem_number,student_name)>0?true:false;
	}

	//找到所有的学生作答（不分题目）
	public List<Test_paper> findAllAnswers() {
		// TODO Auto-generated method stub
		return tpd.findAllAnswers();
	}

	//提交
	public boolean addTest_paper(Test_paper tp) {
		return tpd.addTest_paper(tp) > 0;
	}

}

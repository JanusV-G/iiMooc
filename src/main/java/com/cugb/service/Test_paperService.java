package com.cugb.service;

import java.util.List;

import com.cugb.dao.Test_paperDao;
import com.cugb.entity.Test_paper;

public class Test_paperService {
	Test_paperDao tpd = new Test_paperDao();
	
	
	//����test_id��problem_nubmerȷ��ĳһ�����⣬Ȼ���ҵ�������������е�ѧ������
	public List<Test_paper> findAnswerByProblem(int test_id,int problem_number) {
		// TODO Auto-generated method stub
		return tpd.findAnswerByProblem(test_id,problem_number);
	}

	
	//����test_id problem_number stuent_nameȷ��ĳ��ѧ��ĳ���������Ȼ��ɾ��
	public boolean deleteAnswer(int test_id, int problem_number, String student_name) {
		// TODO Auto-generated method stub
		return tpd.deleteAnswer(test_id,problem_number,student_name)>0?true:false;
	}

	//�ҵ����е�ѧ�����𣨲�����Ŀ��
	public List<Test_paper> findAllAnswers() {
		// TODO Auto-generated method stub
		return tpd.findAllAnswers();
	}

	//�ύ
	public boolean addTest_paper(Test_paper tp) {
		return tpd.addTest_paper(tp) > 0;
	}

}

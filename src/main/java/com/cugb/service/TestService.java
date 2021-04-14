package com.cugb.service;

import java.util.List;

import com.cugb.dao.TestDao;
import com.cugb.entity.Test;

public class TestService {
	TestDao td = new TestDao();

	// �ҵ�ͬһtest_id����������
	public List<Test> findPaperById(int test_id) {
		return td.findPaperById(test_id);
	}

	// ����test_id,problem_numberȷ��ĳһ������Ȼ��ɾ��
	public boolean deleteProblem(int test_id, int problem_number) {
		// TODO Auto-generated method stub
		return td.deleteProblem(test_id, problem_number) > 0 ? true : false;
	}

	// ����test_id,problem_numberȷ��ĳһ������
	public Test findProblem(int test_id, int problem_number) {
		// TODO Auto-generated method stub
		return td.findProblem(test_id, problem_number);
	}

	// problem�а���Ҫ�޸������test_id,problem_number�Լ�����Ҫ�޸ĵ���Ϣ
	public boolean edictProblem(Test problem) {
		// TODO Auto-generated method stub
		return td.edictProblem(problem) > 0 ? true : false;
	}

	// ������Ŀ
	public boolean addProblem(Test problem) {
		// TODO Auto-generated method stub
		return td.addProblem(problem) > 0 ? true : false;
	}

	// �ҵ�������Ŀ������test_id)
	public List<Test> findAllProblems() {
		// TODO Auto-generated method stub
		return td.findAllProblems();
	}

	public boolean nedictProblem(Test problem, String newproblem_number) {
		return td.nedictProblem(problem, newproblem_number) > 0 ? true : false;
	}
	
	public boolean deleteManyProblem(String uids) {
		// TODO Auto-generated method stub
		return td.deleteManyProblem(uids)>0?true:false;
	}
	//������Ŀ
		public boolean addTest(Test problem) {
			// TODO Auto-generated method stub
			return td.addTest(problem)>0?true:false;
		}
		//���ݱ��ɾ����Ŀ
		public boolean deleteProblemById(String tids) {
			// TODO Auto-generated method stub
			return td.deleteTestById(tids)>0?true:false;
		}
}

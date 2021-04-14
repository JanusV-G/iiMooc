package com.cugb.service;

import java.util.List;

import com.cugb.dao.TestDao;
import com.cugb.entity.Test;

public class TestService {
	TestDao td = new TestDao();

	// 找到同一test_id的所有试题
	public List<Test> findPaperById(int test_id) {
		return td.findPaperById(test_id);
	}

	// 根据test_id,problem_number确定某一道试题然后删除
	public boolean deleteProblem(int test_id, int problem_number) {
		// TODO Auto-generated method stub
		return td.deleteProblem(test_id, problem_number) > 0 ? true : false;
	}

	// 根据test_id,problem_number确定某一道试题
	public Test findProblem(int test_id, int problem_number) {
		// TODO Auto-generated method stub
		return td.findProblem(test_id, problem_number);
	}

	// problem中包含要修改试题的test_id,problem_number以及所有要修改的信息
	public boolean edictProblem(Test problem) {
		// TODO Auto-generated method stub
		return td.edictProblem(problem) > 0 ? true : false;
	}

	// 增加题目
	public boolean addProblem(Test problem) {
		// TODO Auto-generated method stub
		return td.addProblem(problem) > 0 ? true : false;
	}

	// 找到所有题目（不分test_id)
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
	//增加题目
		public boolean addTest(Test problem) {
			// TODO Auto-generated method stub
			return td.addTest(problem)>0?true:false;
		}
		//根据编号删除题目
		public boolean deleteProblemById(String tids) {
			// TODO Auto-generated method stub
			return td.deleteTestById(tids)>0?true:false;
		}
}

package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cugb.entity.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());

	public List<Test> findPaperById(int test_id) {
		// TODO Auto-generated method stub
		String sql = "select * from test where test_id = ?";
		try {
			return qRunner.query(sql, new BeanListHandler<Test>(Test.class), test_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int deleteProblem(int test_id, int problem_number) {
		// TODO Auto-generated method stub
		String sql = "delete  from test where test_id=? and problem_number=?";
		try {
			return qRunner.update(sql, test_id, problem_number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public Test findProblem(int test_id, int problem_number) {
		// TODO Auto-generated method stub
		String sql = "select * from test where test_id=? and problem_number=?";
		try {
			return qRunner.query(sql, new BeanHandler<Test>(Test.class), test_id, problem_number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int edictProblem(Test problem) {
		// TODO Auto-generated method stub
		String sql = "update test set problem_type=?,problem_photo=?,problem_answer=?,problem_score=? where test_id=? and problem_number=?";
		try {
			return qRunner.update(sql, problem.getProblem_type(), problem.getProblem_photo(),
					problem.getProblem_answer(), problem.getProblem_score(), problem.getTest_id(),
					problem.getProblem_number());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addProblem(Test problem) {
		// TODO Auto-generated method stub
		String sql = "insert into test (test_id,problem_type,problem_photo,problem_answer,problem_score) values (?,?,?,?,?)";
		int r = 0;
		try {
			r = qRunner.update(sql, problem.getTest_id(), problem.getProblem_type(), problem.getProblem_photo(),
					problem.getProblem_answer(), problem.getProblem_score());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	public List<Test> findAllProblems() {
		// TODO Auto-generated method stub
		String sql = "select * from test";
		try {
			return qRunner.query(sql, new BeanListHandler<Test>(Test.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int nedictProblem(Test problem, String newproblem_number) {
		// TODO Auto-generated method stub
		String sql = "update test set problem_number=?,problem_type=?,problem_photo=?,problem_answer=?,problem_score=? where test_id=? and problem_number=?";
		try {
			return qRunner.update(sql, newproblem_number, problem.getProblem_type(), problem.getProblem_photo(),
					problem.getProblem_answer(), problem.getProblem_score(), problem.getTest_id(),
					problem.getProblem_number());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteManyProblem(String uids) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM test WHERE problem_id IN (" + uids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//增加试题专用
		public int addTest(Test problem) {
			// TODO Auto-generated method stub
			String sql = "insert into test (test_id,problem_number,problem_type,problem_photo,problem_answer,problem_score) values (?,?,?,?,?,?)";
			int r = 0;
			try {
				r = qRunner.update(sql,problem.getTest_id(),problem.getProblem_number(),problem.getProblem_type(),problem.getProblem_photo(),problem.getProblem_answer(),problem.getProblem_score());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return r;
		}
		//根据编号删除题目
		public int deleteTestById(String tids) {
			// TODO Auto-generated method stub
			String sql="DELETE FROM test WHERE problem_number in ("+tids+")";
			try {
				return qRunner.update(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

}

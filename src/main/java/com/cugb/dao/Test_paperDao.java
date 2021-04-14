package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cugb.entity.Test_paper;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test_paperDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());
	
	public List<Test_paper> findAnswerByProblem(int test_id, int problem_number) {
		// TODO Auto-generated method stub
		String sql = "select * from test_paper where test_id=? and problem_number=?";
		try {
			return qRunner.query(sql, new BeanListHandler<Test_paper>(Test_paper.class),test_id,problem_number);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int deleteAnswer(int test_id, int problem_number, String student_name) {
		// TODO Auto-generated method stub
		String sql = "delete from test_paper where test_id=? and problem_number=? and student_name=?";
		int r = 0;
		try {
			r = qRunner.update(sql,test_id,problem_number,student_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	public List<Test_paper> findAllAnswers() {
		// TODO Auto-generated method stub
		String sql = "select * from test_paper";
		try {
			return qRunner.query(sql, new BeanListHandler<Test_paper>(Test_paper.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//学生提交
	public int addTest_paper(Test_paper tp) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `test_paper` (Test_id, Problem_number, Student_name, String_answer, Pic_answer) VALUES (?,?,?,?,?)";
		try {
			return qRunner.update(sql,tp.getTest_id(),tp.getProblem_number(),tp.getStudent_name(),tp.getString_answer(),tp.getPic_answer());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

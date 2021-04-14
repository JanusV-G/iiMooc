package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cugb.entity.Homework_student;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Homework_studentDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());

	//添加部分作业信息
	public int addHomeworkInfo(Homework_student hstu) {
		String sql = "INSERT INTO homework_student (Student_name, Homework_id, Homework_name, Teacher_name) VALUES (?,?,?,?)";
		try {
			return qRunner.update(sql,hstu.getStudent_name(),hstu.getHomework_id(),hstu.getHomework_name(),hstu.getTeacher_name());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//判断是否存在
	public Homework_student judgeIfExist(Homework_student hstu) {
		String sql = "SELECT * FROM homework_student WHERE Homework_id = ?";
		try {
			return qRunner.query(sql, new BeanHandler<Homework_student>(Homework_student.class),hstu.getHomework_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	//修改部分作业信息
	public int updateHomeworkInfo(Homework_student hstu) {
		String sql = "UPDATE `homework_student` SET Student_name=?, Homework_id=?, Homework_name=?, Teacher_name=? WHERE Homework_id=?";
		try {
			return qRunner.update(sql,hstu.getStudent_name(),hstu.getHomework_id(),hstu.getHomework_name(),hstu.getTeacher_name(),hstu.getHomework_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	//更新学生提交的答案
	public int updateAnswer(int homework_id, String submit_file) {
		String sql = "UPDATE `homework_student` SET Submit_file=? WHERE Homework_id=?";
		try {
			System.out.println(homework_id+"  "+submit_file);
			return qRunner.update(sql,submit_file,homework_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
	public List<Homework_student> findAllhomeworkStudent() {
		// TODO Auto-generated method stub
		String sql = "select * from homework_student";
		try {
			return qRunner.query(sql, new BeanListHandler<Homework_student>(Homework_student.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int deletehomeworkStudent(String homework_id, String student_name) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM homework_student WHERE homework_id =? and student_name =?";
		try {
			return qRunner.update(sql,homework_id,student_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteManyHomeworkStudent(String uids) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM homework_student WHERE homework_id IN (" + uids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}

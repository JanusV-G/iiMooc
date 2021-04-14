package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cugb.entity.Homework_student;
import com.cugb.entity.Homework_teacher;
import com.cugb.entity.Learning_materials;
import com.cugb.entity.Test_paper;
import com.cugb.utils.PageTool;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Homework_teacherDao {
	QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

	//通过id查找作业
	public Homework_teacher findHomeworkById(int homework_id) {
		String sql="SELECT * FROM homework_teacher where Homework_id = ?";
		try {
			return qr.query(sql, new BeanHandler<Homework_teacher>(Homework_teacher.class),homework_id);
			//return qRunner.query(sql, new BeanHandler<Homework_teacher>(Homework_teacher.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
	public int addhomework(Homework_teacher homework_teacher) {
		String sql="INSERT INTO homework_teacher(Homework_name,Lesson_name,Teacher_name,Homework_file,Homework_description,Homework_create_time) VALUES(?,?,?,?,?,?)";
		try {
			return qr.update(sql,homework_teacher.getHomework_name(),homework_teacher.getLesson_name(),homework_teacher.getTeacher_name(),homework_teacher.getHomework_file(),homework_teacher.getHomework_description(),homework_teacher.getHomework_create_time());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	public int getTotalCount() {
		int count=0;
		String sql="SELECT COUNT(*) FROM homework_teacher";
		try {
			Long l = (Long)qr.query(sql, new ScalarHandler());
			count=l.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return count;
	}


	public List<Homework_teacher> findhomeworkByPage(PageTool tool, String teacher_name) {
		String sql="SELECT *FROM homework_teacher where Teacher_name=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Homework_teacher>(Homework_teacher.class),teacher_name,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public int deletehomeworkById(String homeworklids) {
		String sql="DELETE FROM homework_teacher WHERE Homework_id in("+homeworklids+")";
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Homework_teacher> findHomework(String keyword, String message) {
		String sql="SELECT *FROM homework_teacher where "+keyword+" = ?";
		try {
			return qr.query(sql, new BeanListHandler<>(Homework_teacher.class),message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Homework_teacher findhomeworkByld(String homework_id) {
		String sql="SELECT *FROM homework_teacher where Homework_id=?";
		try {
			return qr.query(sql, new BeanHandler<Homework_teacher>(Homework_teacher.class),homework_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public int updatehomework(Homework_teacher Homework_teacher) {
		String sql="update homework_teacher set Homework_name=?,Lesson_name=?,Teacher_name=?,Homework_file=?,Homework_description=?,Homework_create_time=? where Homework_id=?";
		try {
			return qr.update(sql,Homework_teacher.getHomework_name(),Homework_teacher.getLesson_name(),Homework_teacher.getTeacher_name(),Homework_teacher.getHomework_file(),Homework_teacher.getHomework_description(),Homework_teacher.getHomework_create_time(),Homework_teacher.getHomework_id());
		} catch (SQLException e) {		
			e.printStackTrace();
			}
		return 0;
	}
	public List<Homework_student> findstuhomeworkbytname(PageTool tool, String teacher_name) {
		String sql="SELECT *FROM homework_student where Teacher_name=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Homework_student>(Homework_student.class),teacher_name,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Test_paper> findexambytname(PageTool tool, String teacher_name) {
		String sql="SELECT *FROM test_paper where Teacher_name=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Test_paper>(Test_paper.class),teacher_name,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Homework_student findstuhomeworkByld(String studentwork_id) {
		String sql="SELECT *FROM homework_student where Homework_id=?";
		try {
			return qr.query(sql, new BeanHandler<Homework_student>(Homework_student.class),studentwork_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public int updatescore(Homework_student homework_student) {
		String sql="update homework_student set Homework_score=?,Homework_comment=? where Homework_id=?";
		try {
			return qr.update(sql,homework_student.getHomework_score(),homework_student.getHomework_comment(),homework_student.getHomework_id());
		} catch (SQLException e) {		
			e.printStackTrace();
			}
		return 0;
	}

	public Test_paper findexamBysn(String student_name) {
		String sql="SELECT *FROM test_paper where Student_name=?";
		try {
			return qr.query(sql, new BeanHandler<Test_paper>(Test_paper.class),student_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int updateexamscore(Test_paper test_paper) {
		String sql="update test_paper set test_score=?,test_comment=? where student_name=?";
		try {
			return qr.update(sql,test_paper.getTest_score(),test_paper.getTest_comment(),test_paper.getStudent_name());
		} catch (SQLException e) {		
			e.printStackTrace();
			}
		return 0;
	}
	
	public List<Homework_teacher> findAllhomeworkTeacher() {
		// TODO Auto-generated method stub
		String sql = "select * from homework_teacher";
		try {
			return qr.query(sql, new BeanListHandler<Homework_teacher>(Homework_teacher.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int deleteManyHomeworkTeacher(String uids) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM homework_teacher WHERE homework_id IN (" + uids + ")";
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deletehomeworkBylname(String lname) {
		String sql="DELETE FROM homework_teacher WHERE Lesson_name=?";
		try {
			return qr.update(sql,lname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

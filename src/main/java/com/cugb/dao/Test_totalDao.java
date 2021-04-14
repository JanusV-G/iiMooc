package com.cugb.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cugb.entity.Test_total;
import com.cugb.utils.PageTool;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test_totalDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());
	QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
	
	public List<Test_total> findTest_totalByPage(PageTool tool, String name) {
		// TODO Auto-generated method stub
		String sql="SELECT *FROM test_total where teacher_name=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Test_total>(Test_total.class),name,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int getTotalCount() {
		// TODO Auto-generated method stub
		int count = 0;
		String sql = "select count(*) from test_total";
		try {
			Long l = (Long)qRunner.query(sql, new ScalarHandler());
			count = l.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public int addTest_total(Test_total t) {
		String sql="INSERT INTO test_total(test_name,lesson_name,teacher_name,test_password,begin_time,end_time) VALUES(?,?,?,?,?,?)";	
			try {
				return qr.update(sql,t.getTest_name(),t.getLesson_name(),t.getTeacher_name(),t.getTest_password(),t.getBegin_time(),t.getEnd_time());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}
	
	public int deleteTest_totalById(String tids) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM test_total WHERE test_id in ("+tids+")";
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateTest_totalById(Test_total t) {
		// TODO Auto-generated method stub
		String sql="update test_total set test_name=?,lesson_name=?,teacher_name=?,test_password=?,begin_time=?,end_time=? where test_id=?";
		try {
			return qr.update(sql,t.getTest_name(),t.getLesson_name(),t.getTeacher_name(),t.getTest_password(),t.getBegin_time(),t.getEnd_time(),t.getTest_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Test_total findTest_totalById(String id) {
		// TODO Auto-generated method stub
		String sql="SELECT *FROM test_total where test_id=?";
		try {
			return qr.query(sql, new BeanHandler<Test_total>(Test_total.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//根据指定关键词查找test_total表
	public List<Test_total> findTest_total(String keyword, String message) {
		String sql="SELECT *FROM test_total where "+keyword+" = ?";
		try {
			return qr.query(sql, new BeanListHandler<>(Test_total.class),message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Test_total> findAlltests() {
		// TODO Auto-generated method stub
		String sql = "select * from test_total";
		try {
			return qRunner.query(sql, new BeanListHandler<Test_total>(Test_total.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Test_total> findUnendtests() {
		// TODO Auto-generated method stub
		//我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        String sql = "select * from test_total where end_time>?";
        System.out.println(createdate);
        try {
			return qRunner.query(sql, new BeanListHandler<Test_total>(Test_total.class),createdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Test_total> findEndtests() {
		// TODO Auto-generated method stub
		//我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        String sql = "select * from test_total where end_time<=?";
        try {
			return qRunner.query(sql, new BeanListHandler<Test_total>(Test_total.class),createdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int deleteTest(int id) {
		// TODO Auto-generated method stub
		int r = 0;
		String sql = "delete from test_total where test_id = ?";
		try {
			r = qRunner.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public Test_total findTestTotalById(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from test_total where test_id = ?";
		Test_total tt = null;
		try {
			tt = qRunner.query(sql, new BeanHandler<Test_total>(Test_total.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tt;
	}
	public int edictTestTotal(Test_total tt) {
		// TODO Auto-generated method stub
		String sql = "update test_total set test_name=?,lesson_name=?,teacher_name=?,test_password=?,begin_time=?,end_time=? where test_id=?";
		int r = 0;
		try {
			r = qRunner.update(sql,tt.getTest_name(),tt.getLesson_name(),tt.getTeacher_name(),tt.getTest_password(),tt.getBegin_time(),tt.getEnd_time(),tt.getTest_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public int addTestTotal(Test_total tt) {
		// TODO Auto-generated method stub
		String sql = "insert into test_total (test_name,lesson_name,teacher_name,test_password,begin_time,end_time) values (?,?,?,?,?,?)";
		int r = 0;
		try {
			r = qRunner.update(sql,tt.getTest_name(),tt.getLesson_name(),tt.getTeacher_name(),tt.getTest_password(),tt.getBegin_time(),tt.getEnd_time());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public int deleteManyTest(String uids) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM test_total WHERE test_id IN (" + uids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteTesk_TotalBylname(String lname) {
		String sql="DELETE FROM test_total WHERE lesson_name=?";
		try {
			return qr.update(sql,lname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

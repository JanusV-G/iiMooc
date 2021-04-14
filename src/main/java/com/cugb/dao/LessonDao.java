package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cugb.entity.Lesson;
import com.cugb.utils.PageTool;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class LessonDao {

//	//һЩ����������:
//	private String tableName = "user";      //ָ���ı���, һ���޸�
//	private String configName = "imooc";    //��Ҫʹ�õ�C3P0������
//	private String sql = null;

	QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

	public List<Lesson> findLessonByPage(PageTool tool){
		String sql="SELECT * FROM lesson  limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<>(Lesson.class),tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//�������пγ�(����ҳ)
	public List<Lesson> findLesson(){
		String sql="SELECT * FROM lesson ";
		try {
			return qr.query(sql, new BeanListHandler<>(Lesson.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//��ҳ��ѯ
	public List<Lesson> findLessonByPage(PageTool tool,String name){
		String sql="SELECT *FROM lesson where teacher_name=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Lesson>(Lesson.class),name,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//�ܼ�¼��
	public int getTotalCount() {
		int count=0;
		String sql="SELECT COUNT(*) FROM lesson";
		try {
			Long l = (Long)qr.query(sql, new ScalarHandler());
			count=l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return count;
	}
	//��ӿγ�
	public int addLesson(Lesson lesson) {
		String sql="INSERT INTO lesson(Lesson_name,Teacher_name,Students_number,Videos_number,Lesson_photo,Description,Lesson_create_time,flag) VALUES(?,?,?,?,?,?,?,?)";
		try {
			return qr.update(sql,lesson.getLesson_name(),lesson.getTeacher_name(),lesson.getStudents_number(),lesson.getVideos_number(),lesson.getLesson_photo(),lesson.getDescription(),lesson.getLesson_create_time(),lesson.getFlag());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//ɾ���γ�
	public int deleteLessonById(String lid) {
		String sql="DELETE FROM lesson WHERE Lesson_id=?";
		try {
			return qr.update(sql, lid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//�鿴�γ���Ϣ
	public Lesson findLessonById(String id) {
		String sql="SELECT *FROM lesson where Lesson_id=?";
		try {
			return qr.query(sql, new BeanHandler<Lesson>(Lesson.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//�޸Ŀγ���Ϣ
	public int updateLessonById(Lesson lesson) {
		String sql="update lesson set Lesson_name=?,Teacher_name=?,Students_number=?,Videos_number=?,Lesson_photo=?,Description=?,Lesson_create_time=?,flag=? where Lesson_id=?";
		try {
			return qr.update(sql,lesson.getLesson_name(),lesson.getTeacher_name(),lesson.getStudents_number(),lesson.getVideos_number(),lesson.getLesson_photo(),lesson.getDescription(),lesson.getLesson_create_time(),lesson.getFlag(),lesson.getLesson_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//���ӿγ�����Ƶ��Ŀ
	public int updateLessonByName(Lesson lesson) {
		String sql="update lesson set Videos_number=videos_number+1 where Lesson_name=? and teacher_name=?";
		try {
			return qr.update(sql,lesson.getLesson_name(),lesson.getTeacher_name());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<Lesson> findAllLesson(String name) {
		String sql="SELECT *FROM lesson where teacher_name=?";
		try {
			return qr.query(sql, new BeanListHandler<Lesson>(Lesson.class),name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//���ӿγ���ѧ����Ŀ
	public int updateLessonById2(Lesson lesson) {
		// TODO Auto-generated method stub
		String sql="update lesson set students_number=students_number+1 where Lesson_id=?";
		try {
			return qr.update(sql,lesson.getLesson_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteLessonBylname(String lname) {
		String sql="DELETE FROM lesson WHERE Lesson_name=?";
		try {
			return qr.update(sql, lname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

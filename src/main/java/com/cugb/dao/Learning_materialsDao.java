package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cugb.entity.Learning_materials;
import com.cugb.utils.PageTool;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Learning_materialsDao {
	QueryRunner qr=new QueryRunner(new ComboPooledDataSource());


	//根据课程名分页查找所有有关资料
	public List<Learning_materials> findLMByLessonName(PageTool tool, String lessonName){
		String sql="SELECT *FROM learning_materials where lesson_name = ? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Learning_materials>(Learning_materials.class),lessonName,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Learning_materials> findLessonmaterialByPage(PageTool tool,String name){
		String sql="SELECT *FROM learning_materials where Upload_user_name=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Learning_materials>(Learning_materials.class),name,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//总记录数
	public int getTotalCount() {
		int count=0;
		String sql="SELECT COUNT(*) FROM learning_materials";
		try {
			Long l = (Long)qr.query(sql, new ScalarHandler());
			count=l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return count;
	}

	//根据关键字查找符合的条目数量
	public int getTotalCount(String keyword, String message) {
		int count=0;
		String sql="SELECT COUNT(*) FROM learning_materials where "+keyword+" = ?";
		try {
			Long l = (Long)qr.query(sql, new ScalarHandler(),message);
			count=l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int addMaterial(Learning_materials learning_materials) {
		String sql="INSERT INTO learning_materials(Lm_name,upload_user_name,Lesson_name,Lm_file,Lm_description,Lm_create_time) VALUES(?,?,?,?,?,?)";
		try {
			return qr.update(sql,learning_materials.getLm_name(),learning_materials.getUpload_user_name(),learning_materials.getLesson_name(),learning_materials.getLm_file(),learning_materials.getLm_description(),learning_materials.getLm_create_time());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public Learning_materials findLessonmaterialBylm(String lm_name) {
		String sql="SELECT *FROM learning_materials where Lm_name=?";
		try {
			return qr.query(sql, new BeanHandler<Learning_materials>(Learning_materials.class),lm_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int updatematerial(Learning_materials Learning_materials) {
		String sql="update learning_materials set Lm_name=?,upload_user_name=?,Lesson_name=?,Lm_file=?,Lm_description=?,Lm_create_time=? where Lm_id=?";
		try {
			return qr.update(sql,Learning_materials.getLm_name(),Learning_materials.getUpload_user_name(),Learning_materials.getLesson_name(),Learning_materials.getLm_file(),Learning_materials.getLm_description(),Learning_materials.getLm_create_time(),Learning_materials.getLm_id());
		} catch (SQLException e) {		
			e.printStackTrace();
			}
		return 0;
	}
	public int deleteLessonmaterialById(String lessonmaterialids) {
		String sql="DELETE FROM learning_materials WHERE Lm_id in("+lessonmaterialids+")";
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public List<Learning_materials> findAllLm() {
		// TODO Auto-generated method stub
		String sql = "select * from learning_materials";
		try {
			return qr.query(sql, new BeanListHandler<Learning_materials>(Learning_materials.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int deleteManyLm(String uids) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM learning_materials WHERE lm_id IN (" + uids + ")";
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteLessonmaterialBylname(String lessonmaterialids) {
		String sql="DELETE FROM learning_materials WHERE Lesson_name in("+lessonmaterialids+")";
		try {
			return qr.update(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

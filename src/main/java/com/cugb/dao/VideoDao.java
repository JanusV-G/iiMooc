package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cugb.entity.Video;
import com.cugb.utils.PageTool;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class VideoDao {
	QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
	public Video findVideoById(String id) {
		String sql="SELECT *FROM video where video_id=?";
		try {
			return qr.query(sql, new BeanHandler<>(Video.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateVideoById(Video v) {
		// TODO Auto-generated method stub
		String sql="update video set video_name=?,upload_user_name=?,lesson_name=?,video_file=?,video_description=?,video_create_time=? where video_id=?";
		try {
			return qr.update(sql,v.getVideo_name(),v.getUpload_user_name(),v.getLesson_name(),v.getVideo_file(),v.getVideo_description(),v.getVideo_create_time(),v.getVideo_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteVideoById(String vid) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM video WHERE video_id=?";
		try {
			return qr.update(sql,vid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int addVideo(Video v) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO video(video_name,upload_user_name,lesson_name,video_file,video_description,video_create_time) VALUES(?,?,?,?,?,?)";	
		try {
			return qr.update(sql,v.getVideo_name(),v.getUpload_user_name(),v.getLesson_name(),v.getVideo_file(),v.getVideo_description(),v.getVideo_create_time());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int getTotalCount() {
		int count=0;
		String sql="SELECT COUNT(*) FROM video";
		try {
			Long l = (Long)qr.query(sql, new ScalarHandler());
			count=l.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return count;
	}

	public int getTotalCount(String keyword, String message) {
		int count=0;
		String sql="SELECT COUNT(*) FROM video where "+keyword+" = ?";
		try {
			Long l = (Long)qr.query(sql, new ScalarHandler(),message);
			count=l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<Video> findVideoByPage(PageTool tool, String name) {
		String sql="SELECT *FROM video where upload_user_name=? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Video>(Video.class),name,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<Video> findVideoByPage(PageTool tool, String keyword, String message) {
		String sql="SELECT *FROM video where "+keyword+" =? limit ?,?";
		try {
			return qr.query(sql, new BeanListHandler<Video>(Video.class),message,tool.getStartIndex(),tool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Video> findAllVideo(String keyword, String message) {
		String sql="SELECT *FROM video where "+keyword+" =? ";
		try {
			return qr.query(sql, new BeanListHandler<Video>(Video.class),message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int deleteVideoBylname(String lname) {
		String sql="DELETE FROM video WHERE Lesson_name=?";
		try {
			return qr.update(sql,lname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

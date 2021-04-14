package com.cugb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.cugb.entity.Lesson;
import com.cugb.entity.User;
import com.cugb.entity.Video;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ManagerDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());

	// 查找全部用户
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM USER";
		try {
			return qRunner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> findAllStudents() {
		String sql = "SELECT * FROM USER WHERE User_type = 2";
		try {
			return qRunner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> findAllTeachers() {
		String sql = "SELECT * FROM USER WHERE User_type = 1";
		try {
			return qRunner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int deleteMany(String uids) {
		String sql = "DELETE FROM USER WHERE User_id IN (" + uids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int addUser(User user) {
		String sql = "INSERT INTO USER (User_name,User_type,User_class,Student_id,User_email,PASSWORD,User_photo) \r\n"
				+ "VALUES (?,?,?,?,?,?,?)";
		try {
			return qRunner.update(sql, user.getUser_name(), user.getUser_type(), user.getUser_class(),
					user.getStudent_id(), user.getUser_email(), user.getPassword(), user.getUser_photo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int updateUser(User user) {
		String sql = "UPDATE user SET User_name = ? ,User_type=?,User_class=?,Student_id=?,User_email=?,PASSWORD=?,User_photo=? WHERE User_id = ?";
		try {
			return qRunner.update(sql, user.getUser_name(), user.getUser_type(), user.getUser_class(),
					user.getStudent_id(), user.getUser_email(), user.getPassword(), user.getUser_photo(),
					user.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public User findUserById(int user_id) {
		String sql = "SELECT * FROM user WHERE user_id = ?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class), user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User checkUserNumber(String user_number) {
		String sql = "SELECT * FROM USER WHERE user_number = ?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class), user_number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User checkEmail(String user_email) {
		String sql = "SELECT * FROM USER WHERE user_email = ?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class), user_email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int deleteManyVideos(String uids) {
		String sql = "DELETE FROM video WHERE Video_id IN (" + uids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Video> findAllVideos() {
		String sql = "SELECT * FROM video";
		try {
			return qRunner.query(sql, new BeanListHandler<Video>(Video.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> findAllName() {
		String sql = "SELECT * FROM lesson";
		try {
			List<String> name = qRunner.query(sql, new ColumnListHandler<>("Teacher_name"));
			return name;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> findAllLesson() {
		String sql = "SELECT * FROM lesson";
		try {
			return qRunner.query(sql, new ColumnListHandler<>("Lesson_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<String> findAllLessonData() {
		String sql = "SELECT * FROM user WHERE User_type = 1";
		try {
			return qRunner.query(sql, new ColumnListHandler<>("User_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addVideo(Video video) {
		String sql = "INSERT INTO video (Video_name, Upload_user_name, Lesson_name, Video_file, Video_description,Video_create_time) \r\n"
				+ "VALUES (?,?,?,?,?,?)";
		String add = "UPDATE lesson SET Videos_number=Videos_number+1 WHERE Lesson_name = ? AND Teacher_name = ?";
		try {
			int temp = qRunner.update(add, video.getLesson_name(), video.getUpload_user_name());
			return qRunner.update(sql, video.getVideo_name(), video.getUpload_user_name(), video.getLesson_name(),
					video.getVideo_file(), video.getVideo_description(), video.getVideo_create_time());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Video findVideoById(int video_id) {
		String sql = "SELECT * FROM video WHERE video_id = ?";
		try {
			return qRunner.query(sql, new BeanHandler<Video>(Video.class), video_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateVideo(Video video) {
		String sql = "UPDATE video SET Video_name = ? ,Upload_user_name=?,Lesson_name=?,Video_file=?,Video_description=?,Video_create_time=? WHERE Video_id = ?";
		try {
			return qRunner.update(sql, video.getVideo_name(), video.getUpload_user_name(), video.getLesson_name(),
					video.getVideo_file(), video.getVideo_description(), video.getVideo_create_time(),
					video.getVideo_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Lesson> findAllLessons() {
		String sql = "SELECT * FROM lesson";
		try {
			return qRunner.query(sql, new BeanListHandler<Lesson>(Lesson.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int deleteManyLessons(String uids) {
		String sql = "DELETE FROM lesson WHERE Lesson_id IN (" + uids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int addLesson(Lesson lesson) {
		String sql = "INSERT INTO lesson(Lesson_name,Teacher_name,Students_number,Videos_number,Lesson_photo,Description,Lesson_create_time,flag) VALUES(?,?,?,?,?,?,?,?)";
		try {
			return qRunner.update(sql, lesson.getLesson_name(), lesson.getTeacher_name(), lesson.getStudents_number(),
					lesson.getVideos_number(), lesson.getLesson_photo(), lesson.getDescription(),
					lesson.getLesson_create_time(), lesson.getFlag());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Lesson findLessonById(int lesson_id) {
		String sql = "SELECT * FROM lesson WHERE lesson_id = ?";
		try {
			return qRunner.query(sql, new BeanHandler<Lesson>(Lesson.class), lesson_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int updateLesson(Lesson lesson) {
		String sql = "update lesson set Lesson_name=?,Teacher_name=?,Students_number=?,Lesson_photo=?,Description=?,flag=? where Lesson_id=?";
		try {
			return qRunner.update(sql, lesson.getLesson_name(), lesson.getTeacher_name(), lesson.getStudents_number(),
					lesson.getLesson_photo(), lesson.getDescription(), lesson.getFlag(), lesson.getLesson_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

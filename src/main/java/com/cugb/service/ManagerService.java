package com.cugb.service;

import java.util.List;

import com.cugb.dao.ManagerDao;
import com.cugb.entity.Lesson;
import com.cugb.entity.User;
import com.cugb.entity.Video;

public class ManagerService {
	ManagerDao md = new ManagerDao();

	// 查找全部用户
	public List<User> findAllUsers() {
		return md.findAllUsers();
	}

	// 查找全部学生
	public List<User> findAllStudents() {
		return md.findAllStudents();
	}

	// 查找全部教师
	public List<User> findAllTeachers() {
		return md.findAllTeachers();
	}

	// 删除用户
	public boolean deleteMany(String uids) {
		return md.deleteMany(uids) > 0 ? true : false;
	}

	public boolean addUser(User user) {
		return md.addUser(user) > 0 ? true : false;
	}

	public boolean updateUser(User user) {
		return md.updateUser(user) > 0 ? true : false;
	}

	public User findUserById(int user_id) {
		return md.findUserById(user_id);
	}

	public boolean checkUserNumber(String user_number) {
		User user = md.checkUserNumber(user_number);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkEmail(String user_email) {
		User user = md.checkEmail(user_email);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteManyVideos(String uids) {
		return md.deleteManyVideos(uids) > 0 ? true : false;
	}

	public List<Video> findAllVideos() {
		return md.findAllVideos();
	}

	public List<String> findAllName() {
		return md.findAllName();
	}

	public List<String> findAllLesson() {
		return md.findAllLesson();
	}

	public boolean addVideo(Video video) {
		return md.addVideo(video) > 0 ? true : false;
	}

	public Video findVideoById(int video_id) {
		return md.findVideoById(video_id);
	}

	public boolean updateVideo(Video video) {
		return md.updateVideo(video) > 0 ? true : false;
	}

	public List<Lesson> findAllLessons() {
		return md.findAllLessons();
	}

	public boolean deleteManyLessons(String uids) {
		return md.deleteManyLessons(uids) > 0 ? true : false;
	}

	public boolean addLesson(Lesson lesson) {
		return md.addLesson(lesson) > 0 ? true : false;
	}

	public List<String> findAllLessonData() {
		return md.findAllLessonData();
	}

	public Lesson findLessonById(int lesson_id) {
		return md.findLessonById(lesson_id);
	}

	public boolean updateLesson(Lesson lesson) {
		return md.updateLesson(lesson) > 0 ? true : false;
	}

}

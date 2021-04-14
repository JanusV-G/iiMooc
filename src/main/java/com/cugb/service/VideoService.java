package com.cugb.service;

import java.util.List;

import com.cugb.dao.VideoDao;
import com.cugb.entity.Video;
import com.cugb.utils.PageTool;

public class VideoService {
	VideoDao vd=new VideoDao();
	public Video findVideoById(String id) {
		// TODO Auto-generated method stub
		return vd.findVideoById(id);
	}

	public boolean updateVideoById(Video v) {
		// TODO Auto-generated method stub
		return vd.updateVideoById(v)>0?true:false;
	}

	public boolean deleteVideoById(String id) {
		// TODO Auto-generated method stub
		return vd.deleteVideoById(id)>0?true:false;
	}

	public boolean addVideo(Video v) {
		// TODO Auto-generated method stub
		return vd.addVideo(v)>0?true:false;
	}

	public int getTotalCount() {
		// TODO Auto-generated method stub
		return vd.getTotalCount();
	}
	public int getTotalCount(String keyword, String message) {
		return vd.getTotalCount(keyword,message);
	}
	public List<Video> findVideoByPage(PageTool tool, String name) {
		// TODO Auto-generated method stub
		List<Video> list=vd.findVideoByPage(tool,name);
		return list;
	}
	public List<Video> findVideoByPage(PageTool tool, String keyword, String message) {
		List<Video> list=vd.findVideoByPage(tool,keyword,message);
		return list;
	}
	public List<Video> findAllVideo(String keyword, String message) {
		List<Video> list=vd.findAllVideo(keyword,message);
		return list;
	}
	public boolean deletevedioBylname(String lname) {
		return vd.deleteVideoBylname(lname)>0?true:false;
	}
}

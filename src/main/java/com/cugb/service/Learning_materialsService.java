package com.cugb.service;

import java.util.List;

import com.cugb.dao.Learning_materialsDao;
import com.cugb.entity.Learning_materials;
import com.cugb.entity.Lesson;
import com.cugb.utils.PageTool;

public class Learning_materialsService {
	Learning_materialsDao ld=new Learning_materialsDao();

	//分页查找:
	public List<Learning_materials> findLMByLessonName(PageTool tool, String lessonName){
		return ld.findLMByLessonName(tool,lessonName);
	}

	public List<Learning_materials> findLessonmaterialByPage(PageTool tool,String name){
		List<Learning_materials> list=ld.findLessonmaterialByPage(tool,name);
		return list;
	}
	public int getTotalCount() {
		return ld.getTotalCount();
	}
	//方法重载: 根据指定的关键字查找
	public int getTotalCount(String keyword, String message){
		return ld.getTotalCount(keyword, message);
	}
	
	public boolean addMaterial(Learning_materials learning_materials) {		
		return ld.addMaterial(learning_materials)>0?true:false;
	}
	public Learning_materials findLessonmaterialBylm(String lm_name) {
		return ld.findLessonmaterialBylm(lm_name);
	}
	public boolean updatematerial(Learning_materials Learning_materials) {
		return ld.updatematerial(Learning_materials)>0?true:false;
	}
	public boolean deleteLessonmaterialById(String lessonmaterialids) {
		return ld.deleteLessonmaterialById(lessonmaterialids)>0?true:false;
	}

	public List<Learning_materials> findAllLm() {
		// TODO Auto-generated method stub
		return ld.findAllLm();
	}
	public boolean deleteManyLm(String uids) {
		// TODO Auto-generated method stub
		return ld.deleteManyLm(uids)>0?true:false;
	}
	public boolean deleteLessonmaterialBylname(String lessonmaterialids) {
		return ld.deleteLessonmaterialBylname(lessonmaterialids)>0?true:false;
	}
}

package com.cugb.service;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cugb.dao.Test_totalDao;
import com.cugb.entity.Test_total;
import com.cugb.utils.PageTool;

public class Test_totalService {
	Test_totalDao ttd = new Test_totalDao();
	
	Test_totalDao td=new Test_totalDao();//ѧ����ʹ�õ�test_totaldao
	
	public List<Test_total> findTesk_TotalByPage(PageTool tool, String name) {
		List<Test_total> list=td.findTest_totalByPage(tool,name);
		return list;
	}
	
	public boolean addTesk_Total(Test_total t) {
		return td.addTest_total(t) > 0;
	}
	
	public boolean deleteTesk_TotalById(String id) {
		return td.deleteTest_totalById(id) > 0;
	}
	
	public boolean updateTesk_TotalById(Test_total t) {
		return td.updateTest_totalById(t) > 0;
	}
	
	public Test_total findTesk_TotalById(String id) {
		return td.findTest_totalById(id);
	}

	
	//���п��Ե�����
	public int getTotalCount() {
		return ttd.getTotalCount();
	}
	
	//�ҵ����п���
	public List<Test_total> findAlltests() {
		return ttd.findAlltests();
	}
	
	//�ҵ�û�����Ŀ���
	public List<Test_total> findUnendtests() {
		return ttd.findUnendtests();
	}
	
	//�ҵ��Ѿ������Ŀ���
	public List<Test_total> findEndtests() {
		return ttd.findEndtests();
	}

	public List<Test_total> findTest_total(String keyword, String message) {
		return ttd.findTest_total(keyword,message);
	}
	
	//����test_idɾ������
	public boolean deleteTest(int id) {
		return ttd.deleteTest(id) > 0;
	}
	
	//����test_id�ҵ��ض��Ŀ�����Ϣ
	public Test_total findTestTotalById(int id) {
		return ttd.findTestTotalById(id);
	}
	
	//����test_id�ҵ��ض�����Ȼ���޸Ŀ�����Ϣ��ttΪ�����࣬��������Ҫ�޸ĵ���Ϣ��
	public boolean edictTestTotal(Test_total tt) {
		return ttd.edictTestTotal(tt) > 0;
	}
	
	//���ӿ��ԣ�ttΪ�����࣬������test_id���������Ϣ��
	public boolean addTestTotal(Test_total tt) {
		return ttd.addTestTotal(tt) > 0;
	}
	
	public boolean deleteManyTest(String uids) {
		// TODO Auto-generated method stub
		return ttd.deleteManyTest(uids)>0?true:false;
	}
	public boolean deleteTesk_TotalBylname(String lname) {
		return td.deleteTesk_TotalBylname(lname)> 0;
	}

}

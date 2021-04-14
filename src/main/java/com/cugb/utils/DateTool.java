package com.cugb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.ConstantPoolGen;

//ʵ�����ڸ�ʽDate��String֮����໥ת��

public class DateTool {
	//��̬��Ա������ ����ֱ������.xxx
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//���ַ���ת����
	public static Date stringToDate(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//������ת�ַ�ת
	public String dateToString(Date dt) {
		return sdf.format(dt);
	}
}

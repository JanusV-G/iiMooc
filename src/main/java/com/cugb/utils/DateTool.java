package com.cugb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.ConstantPoolGen;

//实现日期格式Date与String之间的相互转换

public class DateTool {
	//静态成员属于类 可以直接类名.xxx
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//将字符串转日期
	public static Date stringToDate(String str) {
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//将日期转字符转
	public String dateToString(Date dt) {
		return sdf.format(dt);
	}
}

package com.sp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewsDateUtil {
	/**
	 * 该方法用于返回格式化后的系统当前时间
	 * @return
	 */
	public static String getNewSimpleDate(){
		Calendar ca=Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s =  sdf.format(ca.getTime());  //获得格式化后的日期时间
		return s;
	}
}

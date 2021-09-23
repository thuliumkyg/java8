package com.java8.test4.timeAPI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormateThreadLocal {
	//传统时间API  时间变量枷锁
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
		protected DateFormat initialValue() {
		        return new SimpleDateFormat("yyyyMMdd");
		    }	
	};
	
	public static Date convert(String source) throws ParseException{
		return df.get().parse(source);
	}
	
}

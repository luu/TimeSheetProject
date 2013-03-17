package com.example.timesheet.dbmanager;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateOperations {
	public static SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static Date string2Date(String s){
		
		return null;
	}
	
	public static String date2String(Date d){
		return f.format(d);
	}
}

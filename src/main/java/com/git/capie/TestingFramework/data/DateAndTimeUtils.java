package com.git.capie.TestingFramework.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeUtils {
	private static SimpleDateFormat dateAndTimePattern = new SimpleDateFormat(
			"yyyy-MM-dd-HH-mm-ss-S");
	private static SimpleDateFormat datePattern = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat timePattern = new SimpleDateFormat(
			"HH-mm-ss-S");
	private Date CurrentTime;
	
	private DateAndTimeUtils(){
		CurrentTime = new Date();
	}
	
	private static String getCurrentDateByPattern(SimpleDateFormat dateForm){
		return dateForm.format(new DateAndTimeUtils().CurrentTime);
	}
	
	public static String getCurrentDateAndTime(){
		return getCurrentDateByPattern(dateAndTimePattern);
	}
	
	public static String getCurrentDate(){
		return getCurrentDateByPattern(datePattern);
	}
	
	public static String getCurrentTime(){
		return getCurrentDateByPattern(timePattern);
	}
}

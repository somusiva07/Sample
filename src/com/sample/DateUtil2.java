package com.sample;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * DateUtil class to handle date operations
 * @author arunacso
 *
 */
public class DateUtil2 {


	
	public static String getStringDate(Date date, String format) {		
		String dateString = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		dateString = simpleDateFormat.format(date);
		return dateString;
	}
	
	

	/**
	 * To get the date from String value
	 * @param String date
	 * @return date
	 */
	public static Date getDateByFormatFromString(String dateString, String format) {		
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
		}
		return date;
	}
	
	


	public static void main(String args[])
	{
		System.err.println("Input is : "+ getStringDate(getDateByFormatFromString("220617", "ddmmyy"), "ddmmyy"));
	}
}

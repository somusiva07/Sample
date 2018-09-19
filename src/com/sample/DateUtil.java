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
public class DateUtil {

	private final static String DATE_FORMAT= "yyyy-MM-dd";
	// convert string to date yyyyMMdd
	public static Date getDateByDateFormat(String inputDate, String dateFormat) {
		
		
		Date date = null;
		
		try {
			date = getDateFormat(dateFormat).parse(inputDate);
		} catch (ParseException ex) {
			date = null;
		}
		
		
		return date;

	}
	
	
	/**
	 * Utility method to get Date format
	 * @param format
	 * @return DateFormat dateFormat
	 */
	private static DateFormat getDateFormat(String format)
	{
		
		DateFormat dateFormat = new SimpleDateFormat(format);
		
		
		return dateFormat;
	}
	
	
	/**
	 * To get the String value of given date
	 * @param date
	 * @return String date
	 */
	public static String getStringDate(Date date) {		
		String dateString = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		dateString = simpleDateFormat.format(date);
		return dateString;
	}
	
	public static String getStringDate(Date date, String format) {		
		String dateString = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		dateString = simpleDateFormat.format(date);
		return dateString;
	}
	
	/**
	 * To validate the input date format
	 * @param dateStr
	 * @return status
	 */
	public static boolean validateDate(String dateStr){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
				simpleDateFormat.parse(dateStr.trim());
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	

	/**
	 * To get the date from String value
	 * @param String date
	 * @return date
	 */
	public static Date getDateFromString(String dateString) {		
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		try {
			date = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
		}
		return date;
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
	
	/**
	 * To get the last date of selected month by passing given date
	 * @param first date
	 * @return last date
	 */
	public static String getLastDayOfMonth(String firstDate){
		String lastDate = null;
		Date convertedDate = getDateFromString(firstDate);
		Calendar c = Calendar.getInstance();
		c.setTime(convertedDate);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		lastDate = getStringDate(c.getTime());
		return lastDate;
	}
	


	public static void main(String args[])
	{
		//System.err.println(getDateByDateFormat("2016-06-21","yyyy-MM-dd"));
		/*String fromDate = DateUtil.getStringDate(new Date(), "dd-MMM-yy");	
		
		System.err.println(fromDate);
		
		Date input = DateUtil.getDateByDateFormat(fromDate, "dd-MMM-yy");*/
		
		
		
		System.err.println("Input is : "+ getStringDate(getDateByFormatFromString("220617", "ddmmyy"), "ddmmyy"));
	}
}

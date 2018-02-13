package com.qdfae.jdk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * 日期工具类
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:56:46
 */
public class DateUtils {
	
	private static String yyyyMM = "yyyyMM";
	
	private static String yyyy = "yyyy";
	
	private static String yyyy_MM_dd = "yyyy-MM-dd";
	
	private static String[] parsePatterns = {
		"yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy.MM.dd HH:mm:ss",
		"yyyyMMddHHmm", "yyyy-MM-dd HH:mm", "yyyy/MM/dd HH:mm", "yyyy.MM.dd HH:mm",
		"yyyyMMddHH", "yyyy-MM-dd HH", "yyyy/MM/dd HH", "yyyy.MM.dd HH",
		"yyyyMMdd", "yyyy-MM-dd",  "yyyy/MM/dd", "yyyy.MM.dd"
		};
	
	public static Date autoParseDate(String str) {
		if (StringUtils.isBlank(str)) 
			return null;
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
		}
		return null;
	}
	
	public static int getdiffDays(Date MaxDay,Date minDay){
		try {
			long diff = MaxDay.getTime() - minDay.getTime();
			Long days = diff / (1000 * 60 * 60 * 24);
			return days.intValue();
		} catch (Exception e) {
			
		}
		return 0;
	}
	
	/**
	 * 去掉时间相减
	 * 
	 * @param maxDay
	 * @param minDay
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午11:00:47
	 */
	public static int getDiffByDate(Date maxDay,Date minDay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
			maxDay = format.parse(format.format(maxDay));
			minDay = format.parse(format.format(minDay));
			long diff = maxDay.getTime() - minDay.getTime();
			Long days = diff / (1000 * 60 * 60 * 24);
			return days.intValue();
		} catch (Exception e) {
		}
		return 0;
	}
	/**
	 * 判断结束日期与开始日期的时间差是否大于某个特定的值
	 * 
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @param field 对应于Calendar的field
	 * @param distance 差值
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午11:01:02
	 */
	public static boolean compare(Date startDate,Date endDate,int field,int distance){
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		c.add(field, distance);
		if(endDate.getTime() >= c.getTime().getTime())
			return true;
		else 
			return false;
	}
	
	/**
	 * 获取本个月开始日期
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午11:01:31
	 */
	public static Date getMinMonthDate(){
		try {
			SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			String date = format.format(calendar.getTime());
			return format.parse(date);
		} catch (Exception e) {
			Xlogger.error(XMsgError.buildSimple(DateUtils.class.getName(), "getMinMonthDate", e));
		}
		return null;
	}
	
	/**
	 * 获取本个月结束日期
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午11:00:10
	 */
	public static Date getMaxMonthDate(){
		try {
			SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			String date = format.format(calendar.getTime());
			return format.parse(date);
		} catch (Exception e) {
			Xlogger.error(XMsgError.buildSimple(DateUtil.class.getName(), "getMaxMonthDate", e));
		}
		return null;
	}
	
	/**
	 * 获取年月
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:59:48
	 */
	public static Integer getYearMonth(){
		SimpleDateFormat format = new SimpleDateFormat(yyyyMM);
		return Integer.parseInt(format.format(new Date()));
	}
	
	/**
	 * 获取当前年月
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:59:33
	 */
	public static Integer getCurrentYearMonth(){
		SimpleDateFormat format = new SimpleDateFormat(yyyyMM);
		Date date = new Date();
		return Integer.parseInt(format.format(date));
	}
	
	/**
	 * 获取年
	 * 
	 * @param date
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:59:25
	 */
	public static int getYear(Date date){
		SimpleDateFormat format = new SimpleDateFormat(yyyy);
		return  Integer.parseInt(format.format(date));
	}
	
	/**
	 * 获取当前日期所属月的天数与传入的天数的最小值
	 * 
	 * @param date
	 * @param day
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:59:16
	 */
	public static int getMinDay(Date date,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int maxMonthDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(day < maxMonthDay){
			return day;
		}else{
			return maxMonthDay;
		}
	}
	
	/**
	 * 获取当前月的最大日期
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:58:57
	 */
	public static String getUpMonthMaxDate(){
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
		Calendar calendar = Calendar.getInstance();  
		int month = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return format.format(calendar.getTime());
	}
	
	public static Date convertDate(String date,String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	/**
	 * 是否是闰年
	 * 
	 * @param year
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:58:38
	 */
	public static boolean isLeapYear(int year){
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 获取年份的第一天
	 * 
	 * @param year
	 * @return 
	 * @author hongwei.lian  
	 * @date 2018年2月13日 下午10:58:28
	 */
    public static Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        return calendar.getTime();  
    }  
    
   /**
    * 获取年份的最后一天
    * 
    * @param year
    * @return 
    * @author hongwei.lian  
    * @date 2018年2月13日 下午10:58:12
    */
    public static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        return calendar.getTime();  
    }  

}

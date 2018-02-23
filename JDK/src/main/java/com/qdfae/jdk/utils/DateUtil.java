package com.qdfae.jdk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.qdfae.jdk.logger.XMsgError;
import com.qdfae.jdk.logger.Xlogger;

/**
 * 日期工具类
 * 
 * @author hongwei.lian 
 * @date 2018年2月13日 下午10:56:46
 */
public class DateUtil extends DateUtils {

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
	 * @param maxDay
	 * @param minDay
	 * @return int
	 * @author Administrator
	 * 2016年11月23日 上午10:39:26
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
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @param field 对应于Calendar的field
	 * @param distance 差值
	 * @return
	 * @author wenqiang
	 * 2015年8月19日 下午5:35:56
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
	 * @return
	 * @return Date
	 * @author zhiya.chai
	 * 2015年9月1日 下午1:43:36
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
			Xlogger.error(XMsgError.buildSimple(DateUtil.class.getName(), "getMinMonthDate", e));
		}
		return null;
	}
	/**
	 * 获取本个月结束日期
	 * @return
	 * @return Date
	 * @author zhiya.chai
	 * 2015年9月1日 下午1:43:36
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
	 * @return
	 * @return Integer
	 * @author zhiya.chai
	 * 2015年9月1日 下午1:43:36
	 */
	public static Integer getYearMonth(){
		SimpleDateFormat format = new SimpleDateFormat(yyyyMM);
		return Integer.parseInt(format.format(new Date()));
	}
	/**
	 * 获取当前年月
	 * @return
	 * @return Integer
	 * @author zhiya.chai
	 * 2015年10月27日 上午9:28:17
	 */
	public static Integer getCurrentYearMonth(){
		SimpleDateFormat format = new SimpleDateFormat(yyyyMM);
		Date date = new Date();
		return Integer.parseInt(format.format(date));
	}
	
	/**
	 * 获取年
	 * @param date
	 * @author zhiya.chai
	 * @date 2017年5月17日 上午10:10:29
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
	 * 2018年2月23日 上午9:31:41
	 */
	public static int getMinDay(Date date, int day){
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
	 * @return
	 * @return String
	 * @author zhiya.chai
	 * 2015年9月1日 下午1:43:36
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
	 * @param year
	 * @return
	 * @author zhiya.chai
	 * @date 2017年5月17日 上午10:13:41
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
	 * @param year
	 * @return
	 * @author zhiya.chai
	 * @date 2017年5月17日 上午10:20:48
	 */
    public static Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        return calendar.getTime();  
    }  
    /**
     * 获取年份的最后一天
     * @param year
     * @return
     * @author zhiya.chai
     * @date 2017年5月17日 上午10:24:54
     */
    public static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        return calendar.getTime();  
    }  
    
    /**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date parseDate(Object str, String pattern) {
		if (str == null){
			return null;
		}
		try {
			return DateUtils.parseDate(str.toString(), pattern);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static long getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * 增加或减少时间
	 * 
	 * @param date
	 * @param field
	 * @param value
	 * @return
	 */
	public static Date add(Date date, int field, int value) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, value);
		return c.getTime();
	}
    
}

package com.qdfae.jdk.time;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

/**
 * JDK8日期时间API
 * 
 * @author hongwei.lian
 * 2017年12月5日 下午12:52:02
 */
public class DateTest {

	/**
	 * LocalDate的now()方法获取当前日期
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午12:51:56
	 */
	@Test
	public void testGetLocalDate() {
		LocalDate today = LocalDate.now(); 
		System.out.println("Today's Local date : " + today); 
	}
	
	/**
	 * LocalDate的getYear()方法获取当前日期的年份
	 * LocalDate的getMonthValue()方法获取当前日期的月份
	 * LocalDate的getYear()方法获取当前日期的天数
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午12:51:56
	 */
	@Test
	public void testGetYearAndMonthAndDay() {
		LocalDate today = LocalDate.now(); 
		int year = today.getYear(); 
		int month = today.getMonthValue(); 
		int day = today.getDayOfMonth(); 
		System.out.println("Today's Local date : " + today); 
		System.out.println("Year : " + year + "，Month：" + month + "，Day：" + day);
	}
	
	/**
	 * LocalDate的getDayOfYear()方法获取当前日期的在一年中的第几天
	 * LocalDate的getMonth()方法获取当前日期的月份（使用英语表示）
	 * LocalDate的getDayOfWeek()方法获取当前日期的在一周中的星期
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午12:51:56
	 */
	@Test
	public void testGetYearAndMonthAndDay2() {
		LocalDate today = LocalDate.now(); 
		int day = today.getDayOfYear(); 
		Month month = today.getMonth(); 
		DayOfWeek week = today.getDayOfWeek(); 
		System.out.println("Today's Local date : " + today); 
		System.out.println(today + "是一年的第" + day + "天");
		System.out.println(today + "是" + month);
		System.out.println(today + "是" + week);
	}
	
	/**
	 * LocalDate的format()方法是将日期格式化规定的字符串
	 * 
	 * DateTimeFormatter.BASIC_ISO_DATE
	 * 表示的其格式为"yyyyMMdd"
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午1:29:44
	 */
	@Test
	public void testFomatDate1() {
		LocalDate today = LocalDate.now(); 
		String format = today.format(DateTimeFormatter.BASIC_ISO_DATE); 
	    System.out.println(format);
	}
	
	/**
	 * LocalDate的format()方法是将日期格式化规定的字符串
	 * 
	 * DateTimeFormatter的ofPattern()方法是定义日期格式
	 * 表示的其格式为"yyyy/MM/dd"
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午1:29:44
	 */
	@Test
	public void testFomatDate2() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDate today = LocalDate.now(); 
		String format = today.format(formatter); 
	    System.out.println(format);
	}
	
	/**
	 * LocalDate的format()方法是将日期格式化规定的字符串
	 * 
	 * DateTimeFormatter的ofPattern()方法是定义日期格式
	 * 表示的其格式为"yyyy/MM/dd"
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午1:29:44
	 */
	@Test
	public void testFomatData3() {
		String dateString = "20171205";
		LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.BASIC_ISO_DATE); 
	    System.out.println(date);
	}
	
	/**
	 * LocalDate的parse()方法是将字符串日期转换为日期格式
	 * 
	 * DateTimeFormatter的ofPattern()方法是定义日期格式
	 * 表示的其格式为"yyyy/MM/dd"
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午1:29:44
	 */
	@Test
	public void testFomatData4() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		String dateString = "2017/12/05";
		LocalDate date = LocalDate.parse(dateString, formatter); 
	    System.out.println(date);
	}
	
	/**
	 * 新旧API对比
	 * 
	 * @author hongwei.lian
	 * 2017年12月5日 下午3:46:49
	 */
	@Test
	public void testFomatData5() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String format1 = simpleDateFormat.format(new Date());
		System.out.println(format1);
		 
		//JDK8
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");  
		LocalDate today = LocalDate.now(); 
		String format2 = today.format(formatter); 
	    System.out.println(format2);
	}
	
}
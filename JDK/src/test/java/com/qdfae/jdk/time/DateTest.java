package com.qdfae.jdk.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.huajin.baymax.util.DateUtils;
import com.qdfae.jdk.domain.User;
import com.qdfae.jdk.utils.DateTimeUtil;
import com.qdfae.jdk.utils.DateUtil;

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
	
	@Test
	public void testFomatData6() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse("2018-05-11");
		Date date2 = dateFormat.parse("2018-05-08");
		if (!date1.before(date2)) {
			System.out.println("error");
		}
//		if (date1.after(date2) ) {
//			System.out.println("错误");
//		}
	}
	
	@Test
	public void testFomatData7() throws ParseException {
		Date currDate = new Date();
		String formatDate = DateUtils.formatDate(currDate, "yyyy-MM-dd");
		System.out.println(formatDate);
		Integer valueOf = Integer.valueOf(DateUtils.formatDate(currDate, "yyyyMMdd"));
	    System.out.println(valueOf);
	}
	
	@Test
	public void testFomatData8() throws ParseException {
//		Date currDate = new Date();
//		System.out.println(currDate.getClass().);
	}
	
	@Test
	public void testFomatData9() throws ParseException {
	    //System.out.println(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse("2018-07-16");
		Date date2 = DateUtil.add(date1, Calendar.MONTH, 6);
		System.out.println(date2);
		
		int diffByDate = DateUtil.getDiffByDate(date2, date1);
		System.out.println(diffByDate);
		
		
		
		Date date3 = dateFormat.parse("2018-05-25");
		Date date4 = dateFormat.parse("2018-11-17");
		int diffByDate1 = DateUtil.getDiffByDate(date4, date3);
		System.out.println(diffByDate1);
		
	}
	
	/**
	 * Date转换为LocalDate
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年7月20日 下午5:49:30
	 */
	@Test
	public void testFomatData11() throws ParseException {
		Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        System.out.println("Date = " + date);
        System.out.println("LocalDate = " + localDate);
        
	}
	
	@Test
	public void testFomatData12() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse("2017-07-16");
		Date date2 = dateFormat.parse("2018-09-18");
		Integer interestDay = (int)DateUtils.getDistanceOfTwoDate(date1, date2);//-- 62
		System.out.println(interestDay);
		
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(
				DateTimeUtil.toLocalDate(date1), 
				DateTimeUtil.toLocalDate(date2));
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(
				DateTimeUtil.toLocalDate(date1), 
				DateTimeUtil.toLocalDate(date2));
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(
				DateTimeUtil.toLocalDate(date1), 
				DateTimeUtil.toLocalDate(date2));
//		System.out.println(days);
//		System.out.println(months);
//		System.out.println(years);
//		System.out.println(days + months + years);
		
		
		System.out.println(DateTimeUtil.daysBetweenDate(date1, date2));
		//System.out.println(DateTimeUtil.monthsBetweenDate(date1, date2));
		//System.out.println(DateTimeUtil.yearsBetweenDate(date1, date2));
		
		int orderMoney = 1;
		int investMoneyMin = 1;
		int investMoneyAppend = 1;
		boolean flag = (orderMoney-investMoneyMin) % investMoneyAppend != 0;
		System.out.println(flag);
	}
	
	@Test
	public void testFomatData111() throws ParseException {
		User user = new User(1, "1", "2", new Date());
		String data = JSON.toJSONString(user, SerializerFeature.DisableCircularReferenceDetect, 
				SerializerFeature.WriteDateUseDateFormat);
		//JSONArray jsonArray = JSON.parseArray(data);
        System.out.println(data);
	}
	
	@Test
	public void testFomatData1211() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse("2017-07-16");
		Date date2 = dateFormat.parse("2018-09-18");
		boolean notEqual = ObjectUtils.notEqual(date1, date2);
		System.out.println(notEqual);//true
	}
	
}

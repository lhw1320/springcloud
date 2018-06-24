package com.qdfae.jdk.collections;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.huajin.baymax.util.DateUtils;
import com.qdfae.jdk.utils.DateUtil;

/**
 * Collections工具类
 *
 * @author hongwei.lian
 * @date 2018年5月15日 下午3:25:05
 */
public class CollectionsTest {
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月15日 下午3:27:46
	 */
	@Test
	public void test1() {
//		Map<String, Object> emptyMap = Collections.<String, Object> emptyMap();
//		
//		Map<Object, Object> emptyMap2 = Collections.emptyMap();
//		
		
		
		
	}
	
	@Test
	public void test2() {
		//-- JDK8 时间API
		LocalDate localDate = LocalDate.parse("20180527", DateTimeFormatter.BASIC_ISO_DATE); 
	    System.out.println(localDate);
	    
	    //-- 系统默认时区
	    ZoneId zoneId = ZoneId.systemDefault();  
	    System.out.println(zoneId);
	    
	    //-- 将本地时间表示为时区时间
	    ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
	    System.out.println(zonedDateTime);
	    
	    //-- 转换为Date类型
	    Date date = Date.from(zonedDateTime.toInstant());
	    System.out.println(date);
	    
	    
	    
	    Date nextValueDate = DateUtils.add(date, Calendar.DATE, 1);
	    System.out.println(nextValueDate);//0528
	    
	    
	    String formatDate = DateUtils.formatDate(nextValueDate, "yyyy-MM-dd");
	    System.out.println(formatDate);//"2018-05-28"
	    
	    
	    Date parseDate = DateUtil.parseDate(formatDate, "yyyy-MM-dd");
	    
	    
	    
	    
//	    LocalDate localDate1 = LocalDate.parse("20180527", DateTimeFormatter.BASIC_ISO_DATE); 
//	    Date date1 = Date.from(localDate1.atStartOfDay(zoneId).toInstant());
//	    System.out.println(date1);
//	    
//	    long days = DateUtil.getDistanceOfTwoDate(date, date1);
//	    System.out.println(days);
	    
	}
	
	@Test
	public void testsort1() {
		//List<ListingTradeInvestVo> tradeInvestList
		
	}
	
}

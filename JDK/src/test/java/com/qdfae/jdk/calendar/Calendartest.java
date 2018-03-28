package com.qdfae.jdk.calendar;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * Calendar类
 *
 * @author hongwei.lian
 * @date 2018年3月27日 下午7:20:39
 */
public class Calendartest {
	
	/**
	 * 获取任意时间
	 *
	 * @author hongwei.lian
	 * @date 2018年3月27日 下午7:50:38
	 */
	@Test
	public void testGetAnyTime() {
		Calendar calendar=Calendar.getInstance();  
		calendar.set(2012, Calendar.NOVEMBER, 15, 18, 23, 55);
		Date dateTime = calendar.getTime();
		System.out.println(dateTime);
	}
	
	@Test
	public void testGetStartTimeOfToday() {
//		Calendar c1 = Calendar.getInstance();
//        c1.setTimeInMillis(timeInMs);
//        c1.set(Calendar.HOUR_OF_DAY, 0);
//        c1.set(Calendar.MINUTE, 0);
//        c1.set(Calendar.SECOND, 0);
//        c1.set(Calendar.MILLISECOND, 0);
//        long timeInMillis = c1.getTimeInMillis();
	}

}

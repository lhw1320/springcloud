package com.qdfae.jdk.time;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.qdfae.jdk.utils.DateUtil;

public class DateTest1 {
	
	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		Date date = new Date();
		int day = date.getDate();
		System.out.println(day);
	} 
	
	/**
	 * DateUtil的add()方法
	 * 
	 * @author hongwei.lian
	 * 2018年2月23日 上午9:29:13
	 */
	@Test
	public void test2() {
		 Date date = DateUtil.add(new Date(), Calendar.MONTH, 1);
		 System.out.println(date);
	} 
	
	@Test
	public void test3() {
		Date nextValueDate = DateUtil.add(new Date(), Calendar.MONTH, 1);
		int minDay = DateUtil.getMinDay(nextValueDate, 10);
		System.out.println(minDay);
	} 
	
	@Test
	public void test4() {
		Date nextValueDate = DateUtil.add(new Date(), Calendar.MONTH, 1);
		Date date = DateUtil.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate, 10));
		System.out.println(date);
	} 
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年3月29日 上午11:29:20
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test5() {
		Date date1 = new Date(2018, 3, 14);//-- 数据库中的
		
		Date date2 = new Date(2018, 3, 12);//-- 新设置的
		
		System.out.println(!date1.before(date2));
	} 

}

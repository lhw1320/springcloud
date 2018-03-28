package com.qdfae.jdk.dodatime;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;

/**
 * JodaTime学习
 *
 * @author hongwei.lian
 * @date 2018年3月27日 下午7:20:52
 */
public class JodaTimeTest {
	
	/**
	 * 获取任意时间
	 *
	 * @author hongwei.lian
	 * @date 2018年3月27日 下午7:48:40
	 */
	@Test
	public void testGetAnyTime() {
		DateTime dateTime=new DateTime(2012, 12, 15, 18, 23, 55);  
		System.out.println(dateTime);
	}
	
	/**
	 * 获取今天的开始时间，比如：2018-03-27 00:00:00
	 *
	 * @author hongwei.lian
	 * @date 2018年3月27日 下午7:22:23
	 */
	@Test
	public void testGetStartTimeOfToday() {
		DateTime nowTime = new DateTime();
		DateTime startTimeOfToday =  nowTime.withTimeAtStartOfDay();
		System.out.println(startTimeOfToday);
	}
	
	/**
	 *  获取今天的结束时间，比如：2018-03-27 23:59:59
	 *
	 * @author hongwei.lian
	 * @date 2018年3月27日 下午7:26:49
	 */
	@Test
	public void testGetEndTimeOfToday() {
		DateTime nowTime = new DateTime();
		DateTime endTimeOfToday  =  nowTime.millisOfDay().withMaximumValue();
		System.out.println(endTimeOfToday);
	}
	
	/**
	 * 获取现在距离今天结束还有多长时间
	 *
	 * @author hongwei.lian
	 * @date 2018年3月27日 下午7:29:28
	 */
	@Test
	public void testGetRemainTimeOfToday() {
		DateTime nowTime = new DateTime();
		DateTime endTimeOfToday  =  nowTime.millisOfDay().withMaximumValue();
		long remainTimeOfToday = endTimeOfToday.getMillis() - nowTime.getMillis();
		System.out.println(remainTimeOfToday);
	}
	
	/**
	 * 计算两个日期的相隔天数
	 *
	 * @author hongwei.lian
	 * @date 2018年3月27日 下午7:34:17
	 */
	@Test
	public void testGetBetweenTimeOfTwoDate() {
		DateTime nowTime = new DateTime();
		DateTime futureTime = new DateTime(2018, 10, 1, 0, 0, 0);
		int days = Days.daysBetween(nowTime, futureTime).getDays();
		System.out.println(days);
	}

}

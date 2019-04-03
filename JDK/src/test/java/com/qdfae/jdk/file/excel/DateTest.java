package com.qdfae.jdk.file.excel;

import java.util.Date;

import org.junit.Test;

import com.qdfae.jdk.utils.DateUtil;

public class DateTest {
	
	@Test
	public void test1() {
		Date tradeTime1 = DateUtil.parseDate("20190318173155", "yyyyMMddHHmmss");
		Date tradeTime2 = DateUtil.parseDate("20190319", "yyyyMMdd");
		Date tradeTime3 = DateUtil.parseDate("20190320", "yyyyMMdd");
		Date tradeTime4 = DateUtil.parseDate("20190324", "yyyyMMdd");
		Date buyTimeStart = DateUtil.parseDate("2019-03-18 17:30:58", "yyyy-MM-dd HH:mm:ss");
		Date buyTimeEnd = DateUtil.parseDate("2019-03-24 16:53:01", "yyyy-MM-dd HH:mm:ss");
		if (tradeTime1.before(buyTimeStart) || tradeTime1.after(buyTimeEnd)) {
			System.out.println("==时间不在认购期内1==");
		}
		if (tradeTime2.before(buyTimeStart) || tradeTime2.after(buyTimeEnd)) {
			System.out.println("==时间不在认购期内2==");
		}
		if (tradeTime3.before(buyTimeStart) || tradeTime3.after(buyTimeEnd)) {
			System.out.println("==时间不在认购期内3==");
		}
		if (tradeTime4.before(buyTimeStart) || tradeTime4.after(buyTimeEnd)) {
			System.out.println("==时间不在认购期内4==");
		}
	}

}

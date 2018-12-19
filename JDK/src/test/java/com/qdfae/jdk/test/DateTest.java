package com.qdfae.jdk.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bouncycastle.asn1.dvcs.Data;
import org.junit.Test;

import com.huajin.baymax.util.DateUtils;
import com.qdfae.jdk.domain.User;
import com.qdfae.jdk.utils.DateTimeUtil;

public class DateTest {
	
	@Test
	public void test1() throws ParseException {
		Date syncBeginDate = DateUtils.parseDate("2018-10-13", "yyyy-MM-dd");
		Date today = DateUtils.parseDate(LocalDate.now().toString(), "yyyy-MM-dd");
		if (today.before(syncBeginDate)) {
			//-- 查询起始日大于当日，则数据有误
			System.out.println("日期条件有误");
		}
	}
	
	@Test
	public void test2() throws ParseException {
		Date beginDate = DateUtils.parseDate("2018-10-15", "yyyy-MM-dd");
		Date endDate = DateUtils.parseDate("2018-10-31", "yyyy-MM-dd");
		long distanceOfTwoDate = DateUtils.getDistanceOfTwoDate(beginDate, endDate);
		int daysBetweenDate = DateTimeUtil.daysBetweenDate(beginDate, endDate);
		System.out.println(distanceOfTwoDate);
		System.out.println(daysBetweenDate);
	}
	
	@Test
	public void test3() {
		List<User> userList = new ArrayList<>();
		userList.forEach(user -> {
			System.out.println("====" + user.getId());
		});
	}
	
	@Test
	public void test20() {
//		BigDecimal w = new BigDecimal("10670.88");
//		BigDecimal z = new BigDecimal("18619.91");
//		BigDecimal y = new BigDecimal("166.88");
//		System.out.println(w.add(z).add(y));
	}

}

package com.qdfae.jdk.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

import com.huajin.baymax.util.DateUtils;
import com.jayway.jsonpath.internal.function.numeric.Sum;
import com.qdfae.jdk.enums.CalculatePeriodModeEnum;
import com.qdfae.jdk.utils.DateTimeUtil;
import com.qdfae.jdk.utils.DateUtil;
import com.qdfae.summarize.util.UUIDUtil;

public class RepayPlanTest {
	
	/**
	 * 按月付息，到期还本
	 * 
	 *  计息基准类型：Custom（0）、ActualDays（1）
	 *	计息基准天数：360
	 *	计息方式：按日计息
	 *
	 * @author hongwei.lian
	 * @throws ParseException 
	 * @date 2018年9月20日 下午1:52:28
	 */
	@Test
	public void test1() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 计息本金
		BigDecimal principal = new BigDecimal("1000");
		//-- 利率
		BigDecimal investProfit = new BigDecimal("0.200");
		
		System.out.println("======第一期======");
		//-- 第一期计息天数11
		Date begin1 = format.parse("2018-09-24");
		Date end1 = format.parse("2018-10-04");
		int interestDay1 = DateTimeUtil.daysBetweenDate(begin1, end1) + 1;
		System.out.println("第一期计息天数：" + interestDay1);//11
		BigDecimal interest1 = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay1))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第一期利息" + interest1);
		
		System.out.println("======第二期======");
		Date begin2 = format.parse("2018-10-05");
		Date end2 = format.parse("2018-11-04");
		int interestDay2 = DateTimeUtil.daysBetweenDate(begin2, end2) + 1;
		System.out.println("第二期计息天数：" + interestDay2);//31
		BigDecimal interest2 = principal.multiply(investProfit)
	              .multiply(new BigDecimal(interestDay2))
	              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
        System.out.println("利息" + interest2);
		
        System.out.println("======第三期======");
		Date begin3 = format.parse("2018-11-05");
		Date end3 = format.parse("2018-12-04");
		int interestDay3 = DateTimeUtil.daysBetweenDate(begin3, end3) + 1;
		System.out.println("第三期计息天数：" + interestDay3);//30
		BigDecimal interest3 = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay3))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第三期利息" + interest3);
		
		System.out.println("======第四期======");
		Date begin4 = format.parse("2018-12-05");
		Date end4 = format.parse("2018-12-30");
		int interestDay4 = DateTimeUtil.daysBetweenDate(begin4, end4) + 1;
		System.out.println("第四期计息天数：" + interestDay4);//30
		BigDecimal interest4 = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay4))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第四期利息" + interest4);
	}
	
	/**
	 * 按月付息，到期还本
	 * 
	 *  计息基准类型：Custom（0）、ActualDays（1）
	 *	计息基准天数：360
	 *	计息方式：按日计息
	 *
	 * @author hongwei.lian
	 * @throws ParseException 
	 * @date 2018年9月20日 下午1:52:28
	 */
	@Test
	public void test2() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 计息本金
		BigDecimal principal = new BigDecimal("1000");
		//-- 利率
		BigDecimal investProfit = new BigDecimal("0.200");
		
		System.out.println("======一次性提前还清======");
		//-- 第一期计息天数11
		Date begin = format.parse("2018-09-24");
		Date end = format.parse("2018-10-02");
		int interestDay = DateTimeUtil.daysBetweenDate(begin, end);
		System.out.println("计息天数：" + interestDay);//11
		BigDecimal interest = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("利息" + interest);
		
	}
	
	@Test
	public void test3() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 计息本金
		BigDecimal principal = new BigDecimal("80");
		//-- 利率
		BigDecimal investProfit = new BigDecimal("0.200");
		
		System.out.println("======提前部分======");
		//-- 第一期计息天数11
		Date begin = format.parse("2018-09-24");
		Date end = format.parse("2018-10-01");
		int interestDay = DateTimeUtil.daysBetweenDate(begin, end);
		System.out.println("计息天数：" + interestDay);//11
		BigDecimal interest = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("利息" + interest);//0.31
		
		//-- 剩余本金
		BigDecimal remainprincipal = new BigDecimal("920");
		
		System.out.println("======第一期======");
		//-- 第一期计息天数11
		Date begin1 = format.parse("2018-09-24");
		Date end1 = format.parse("2018-10-04");
		int interestDay1 = DateTimeUtil.daysBetweenDate(begin1, end1);
		System.out.println("第一期计息天数：" + interestDay1);//11
		BigDecimal interest1 = remainprincipal.multiply(investProfit)
															            .multiply(new BigDecimal(interestDay1))
															            .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第一期利息" + interest1);//5.11
		System.out.println("第一期应还利息" + interest1.add(interest));//5.42
		
		System.out.println("======第二期======");
		Date begin2 = format.parse("2018-10-05");
		Date end2 = format.parse("2018-11-04");
		int interestDay2 = DateTimeUtil.daysBetweenDate(begin2, end2) + 1;
		System.out.println("第二期计息天数：" + interestDay2);//31
		BigDecimal interest2 = remainprincipal.multiply(investProfit)
	              .multiply(new BigDecimal(interestDay2))
	              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
        System.out.println("利息" + interest2);
		
        System.out.println("======第三期======");
		Date begin3 = format.parse("2018-11-05");
		Date end3 = format.parse("2018-12-04");
		int interestDay3 = DateTimeUtil.daysBetweenDate(begin3, end3) + 1;
		System.out.println("第三期计息天数：" + interestDay3);//30
		BigDecimal interest3 = remainprincipal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay3))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第三期利息" + interest3);
		
		System.out.println("======第四期======");
		Date begin4 = format.parse("2018-12-05");
		Date end4 = format.parse("2018-12-30");
		int interestDay4 = DateTimeUtil.daysBetweenDate(begin4, end4) + 1;
		System.out.println("第四期计息天数：" + interestDay4);//30
		BigDecimal interest4 = remainprincipal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay4))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第四期利息" + interest4);
		
		System.out.println("总利息" + interest1.add(interest).add(interest2).add(interest3).add(interest4));//49.87
	}
	
	/**
	 * 普通计算周期模式
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午2:42:14
	 */
	@Test
	public void test4() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 2018-09-24
		Date valueDate = format.parse("2018-12-27");
		Date expireDate = format.parse("2019-09-23");
		//-- 兑付半年末月25日
		int settleInvestDay = 25;
		int periods = countPeriodsByHalfYear(valueDate, expireDate, CalculatePeriodModeEnum.非自然周期计算模式.getValue(), 
				settleInvestDay);
		System.out.println("普通计算周期模式计算出周期：" + periods);
	}
	
	/**
	 * 自然计算周期模式
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午2:42:31
	 */
	@Test
	public void test5() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 2018-09-24
		//-- 2018-06-27
		Date valueDate = format.parse("2018-09-16");
		Date expireDate = format.parse("2019-09-17");
		//-- 兑付半年末月25日
		int settleInvestDay = 15;
		int periods = countPeriodsByHalfYear(valueDate, expireDate, CalculatePeriodModeEnum.自然周期计算模式.getValue(), 
				settleInvestDay);
		System.out.println("自然计算周期模式计算出周期：" + periods);
	}
	
	/**
	 * 按半年付息，到期话本
	 *
	 * @param valueDate
	 * @param expireDate
	 * @param calculatePeriodMode
	 * @param settleInvestDay
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午4:38:35
	 */
	private static int countPeriodsByHalfYear11(Date valueDate, Date expireDate, int calculatePeriodMode, int settleInvestDay) {
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		LocalDate firstEndDateExclusive = null;
		//-- 按照自然模式
		int firstPeriod = 0;
		if (Objects.equals(calculatePeriodMode, CalculatePeriodModeEnum.自然周期计算模式.getValue())) {
			//-- 判断起息日
			firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.JUNE, settleInvestDay);
		    if (startDateInclusive.isBefore(firstEndDateExclusive)) {
					firstPeriod += 1;
			} else if (startDateInclusive.isAfter(firstEndDateExclusive) 
					&& startDateInclusive.getMonth().getValue() >= Month.JUNE.getValue()  
					&& startDateInclusive.getMonth().getValue() <= Month.DECEMBER.getValue()) {
				firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.DECEMBER, settleInvestDay);
				if (startDateInclusive.isBefore(firstEndDateExclusive)) {
					firstPeriod += 1;
				}
			}
			//-- 如果起息日在自然半年指定日期之前，则更新为自然半年指定日期
			if (startDateInclusive.isBefore(firstEndDateExclusive)) {
				//firstPeriod += 1;
				startDateInclusive = firstEndDateExclusive;
			}
		}
		System.out.println("===" + firstEndDateExclusive);
		System.out.println("===" + startDateInclusive);
		System.out.println("===" + firstPeriod);
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		//-- 计算到期日和起息日之间的相差月份
		int otherSum = years*12 + months + (days > 0 ? 1 : 0);
		return firstPeriod + (otherSum%6 == 0 ? otherSum/6 : otherSum/6 + 1);
	}
	
	@Test
	public void test111() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2000-06-01");
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		int minDays = DateTimeUtil.getMinDays(LocalDate.of(startDateInclusive.getYear(), Month.JUNE, 01), 31);
//		System.out.println(minDays);
//		System.out.println(Month.FEBRUARY.length(startDateInclusive.isLeapYear()));
//		System.out.println(Month.JUNE.minLength());
//		System.out.println(Month.JUNE.maxLength());
		
		
		String formatDate = DateTimeUtil.formatDate(valueDate);
		System.out.println(formatDate);
		
		String formatDate2 = DateTimeUtil.formatDate(valueDate, "yyyy-MM-dd");
	    System.out.println(formatDate2);
	}
	
	
	@Test
	public void test6() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2018-09-24");
		Date expireDate = format.parse("2019-08-23");
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		//-- 计算到期日和起息日之间的相差月份
		int otherSum = years*12 + months + (days > 0 ? 1 : 0);
		System.out.println("===" + otherSum);
	}
	
	@Test
	public void test7() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2018-05-18");
		Date expireDate = format.parse("2019-05-20");
		int periods = 0;
		//相差年份
		periods += (expireDate.getYear() - valueDate.getYear());
		//相差月份
		int months = (expireDate.getMonth()-valueDate.getMonth());
		if (months > 0) {
			periods += 1;
		} else if (months == 0) {
			periods += (expireDate.getDate() > valueDate.getDate()? 1: 0);
		}
		System.out.println("periods=" + periods);
		
		int periods1 = 0;
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months1 = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		periods1 = years;
		if (months1 > 0) {
			periods1 += 1;
		} else if (Objects.equals(months1, 0) && days > 0) {
			periods1 += 1;
		}
		System.out.println("periods1=" + periods1);
	}
	
	/**
	 * 按年付息，到期还本
	 *
	 * @param valueDate
	 * @param expireDate
	 * @param calculatePeriodMode
	 * @param settleInvestDay
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午4:38:58
	 */
	private static int countPeriodsByYear(Date valueDate, Date expireDate, int calculatePeriodMode, int settleInvestDay) {
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		LocalDate firstEndDateExclusive = null;
		//-- 按照自然模式
		int firstPeriod = 0;
		if (Objects.equals(calculatePeriodMode, CalculatePeriodModeEnum.自然周期计算模式.getValue())) {
			//-- 判断起息日
			firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.DECEMBER, settleInvestDay);
//			if (startDateInclusive.getMonth().getValue() <=  Month.DECEMBER.getValue()) {
//				firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.DECEMBER, settleInvestDay);
//				if (startDateInclusive.isBefore(firstEndDateExclusive)) {
//					firstPeriod += 1;
//				}
//			}
			//-- 如果起息日在自然半年指定日期之前，则更新为自然半年指定日期
			if (startDateInclusive.isBefore(firstEndDateExclusive)) {
				firstPeriod += 1;
				startDateInclusive = firstEndDateExclusive;
			}
		}
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int periods = years;
		if (months > 0) {
			periods += 1;
		} else if (Objects.equals(months, 0) && days > 0) {
			periods += 1;
		}
		return firstPeriod + periods;
	}
	
	/**
	 * 普通计算周期模式
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午2:42:14
	 */
	@Test
	public void test8() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 2018-09-24
		//-- 2018-12-27
		Date valueDate = format.parse("2018-09-24");
		Date expireDate = format.parse("2019-09-23");
		//-- 兑付半年末月25日
		int settleInvestDay = 25;
		int periods = countPeriodsByYear(valueDate, expireDate, CalculatePeriodModeEnum.非自然周期计算模式.getValue(), 
				settleInvestDay);
		System.out.println("普通计算周期模式计算出周期：" + periods);
	}
	
	/**
	 * 自然计算周期模式
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午2:42:31
	 */
	@Test
	public void test9() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 2018-09-24
		//-- 2018-12-27
		Date valueDate = format.parse("2018-07-01");
		Date expireDate = format.parse("2019-12-31");
//		//-- 兑付每年8月25日
//		int settleInvestDay = 25;
		
		//-- 兑付每年8月25日
		int settleInvestDay = 15;
		int periods = countPeriodsByYear(valueDate, expireDate, CalculatePeriodModeEnum.自然周期计算模式.getValue(), 
				settleInvestDay);
		System.out.println("自然计算周期模式计算出周期：" + periods);
	}
	
	@Test
	public void test10() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 2018-09-24
		Date valueDate = format.parse("2018-10-29");
		Date expireDate = format.parse("2019-09-23");
		int periods = (expireDate.getYear()- valueDate.getYear())*12 + (expireDate.getMonth()-valueDate.getMonth()) 
		+ (expireDate.getDate() > valueDate.getDate()? 1: 0);
		System.out.println("周期：" + periods);
		
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		System.out.println("===" + years);
		System.out.println("===" + months);
		System.out.println("===" + days);
		periods = years*12 + months + (days > 0 ? 1 : 0);
		System.out.println("周期：" + periods);
		
	}
	
	/**
	 * 按季付息，到期话本
	 *
	 * @param valueDate
	 * @param expireDate
	 * @param calculatePeriodMode
	 * @param settleInvestDay
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午5:00:52
	 */
	private static int countPeriodsBySeason(Date valueDate, Date expireDate, int calculatePeriodMode, int settleInvestDay) {
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		int firstPeriod = 0;
		//-- 按照自然模式
		if (Objects.equals(calculatePeriodMode, CalculatePeriodModeEnum.自然周期计算模式.getValue())) {
			//-- 判断起息日
			LocalDate firstEndDateExclusive = null;
			int minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.MARCH, settleInvestDay);
			firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.MARCH, minDays);
			if (startDateInclusive.isAfter(firstEndDateExclusive) 
					&& startDateInclusive.getMonth().getValue() >= Month.MARCH.getValue()  
					&& startDateInclusive.getMonth().getValue() <= Month.JUNE.getValue()) {
				minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.JUNE, settleInvestDay);
				firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.JUNE, minDays);
			} else if (startDateInclusive.isAfter(firstEndDateExclusive) 
					&& startDateInclusive.getMonth().getValue() >= Month.JUNE.getValue()  
					&& startDateInclusive.getMonth().getValue() <= Month.SEPTEMBER.getValue()) {
				minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.SEPTEMBER, settleInvestDay);
				firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.SEPTEMBER, minDays);
			} else if (startDateInclusive.isAfter(firstEndDateExclusive) 
					&& startDateInclusive.getMonth().getValue() >= Month.SEPTEMBER.getValue()  
					&& startDateInclusive.getMonth().getValue() <= Month.DECEMBER.getValue()) {
				minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.DECEMBER, settleInvestDay);
				firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.DECEMBER, minDays);
			}
			//-- 如果起息日在自然半年指定日期之前，则更新为自然半年指定日期
			if (startDateInclusive.isBefore(firstEndDateExclusive)) {
				firstPeriod += 1;
				startDateInclusive = DateTimeUtil.addDays(firstEndDateExclusive, 1);
			}
		}
		System.out.println("===startDateInclusive" + startDateInclusive);
		System.out.println("===startDateInclusive" + endDateExclusive);
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		//-- 计算到期日和起息日之间的相差月份
		System.out.println("===years" + years);
		System.out.println("===months" + months);
		System.out.println("===days" + days);
		int otherSum = years*12 + months + (days > 0 ? 1 : 0);
		return firstPeriod + (otherSum%3 == 0 ? otherSum/3 : otherSum/3 + 1);
	}
	
	/**
	 * 自然计算周期模式
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午2:42:31
	 */
	@Test
	public void test11() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2018-12-16");
		Date expireDate = format.parse("2019-12-16");
		//-- 兑付自然季度末月31日
		int settleInvestDay = 1;
		int periods = countPeriodsBySeason(valueDate, expireDate, CalculatePeriodModeEnum.自然周期计算模式.getValue(), 
				settleInvestDay);
		System.out.println("自然计算周期模式计算出周期：" + periods);
	}
	
	/**
	 * 普通计算周期模式
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午2:42:14
	 */
	@Test
	public void test12() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2019-01-01");
		Date expireDate = format.parse("2020-01-01");
		int settleInvestDay = 31;
		int periods = countPeriodsBySeason(valueDate, expireDate, CalculatePeriodModeEnum.非自然周期计算模式.getValue(), 
				settleInvestDay);
		System.out.println("非自然周期计算模式计算出周期：" + periods);
	}
	
	/**
	 * 普通计算周期模式
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月21日 下午2:42:14
	 */
	@Test
	public void test13() throws ParseException {
		int settleInvestDay = 15;
		System.out.println("=====1=====");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2018-09-27");
		Date expireDate = format.parse("2019-09-27");
		//-- 过时API
//		System.out.println("1=" + valueDate.getDate());//27
//		System.out.println("2=" + expireDate.getDate());//27
//		System.out.println("3=" + (valueDate.getDate() ==  expireDate.getDate()));//true
//		System.out.println("=======================");
//		System.out.println("1=" + valueDate.getMonth());//27
//		System.out.println("2=" + expireDate.getMonth());//27
//		System.out.println("3=" + (valueDate.getMonth() ==  expireDate.getMonth()));//true
		System.out.println(expireDate.getMonth());
		System.out.println(valueDate.getMonth());
		System.out.println((expireDate.getMonth() - valueDate.getMonth())%3==0);
		System.out.println(valueDate.getDate());
		System.out.println(valueDate.getDate() < settleInvestDay);
		
		
		
		
		
        //-- JDK8API		
		System.out.println("=====2=====");
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
//		System.out.println("1=" + startDateInclusive.getDayOfMonth());//27
//		System.out.println("2=" + endDateExclusive.getDayOfMonth());//27
//		System.out.println("3=" + (startDateInclusive.getDayOfMonth() ==  endDateExclusive.getDayOfMonth()));//true
//		System.out.println("================================");
//		System.out.println("1=" + startDateInclusive.getMonthValue());//27
//		System.out.println("2=" + endDateExclusive.getMonthValue());//27
//		System.out.println("3=" + (startDateInclusive.getMonthValue() ==  endDateExclusive.getMonthValue()));//true
	
	
		System.out.println(endDateExclusive.getMonthValue());
		System.out.println(startDateInclusive.getMonthValue());
		System.out.println(Objects.equals((endDateExclusive.getMonthValue() - startDateInclusive.getMonthValue())%3, 0));
		System.out.println(startDateInclusive.getDayOfMonth());
		System.out.println(startDateInclusive.getDayOfMonth() < settleInvestDay);
	
	}
	
	/**
	 * 按年付息，到期还本，计算下一期起息日
	 * 
	 * 如果兑付日为：8月15日
	 * 
	 * 项目起息日：20180701，
	 * 项目到期日：20181231
	 * 
	 * 按普通周期计算模式
	 * 
	 * 
	 * 按自然周期计算模式
	 * 年末
	 * 
	 * 
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月25日 上午11:41:56
	 */
	@Test
	public void test14() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2018-07-01");
		Date expireDate = format.parse("2019-12-31");
		int settleInvestDay = 815;
		int period = 1;
		Date nextValueDate = DateUtils.add(interestStartDate, Calendar.YEAR, 1);
		//第一期
		if(period == 1){
			int expireMonth = expireDate.getMonth()+1; 
			int startMonth = interestStartDate.getMonth()+1;  
			int settleMonth = settleInvestDay/100;  
			//1、   起息月<结息月  2、起息月=到期月=结息月 && 起息日<结息日 这两种情况需要调整第一期的周期
			boolean needAdapter = (startMonth < settleMonth) ||
					((expireMonth == startMonth && expireMonth == settleMonth) 
							&& (interestStartDate.getDate()< settleInvestDay%100));
			if(needAdapter){
				//下一期起息日
				nextValueDate = interestStartDate;
			}
		}
		//每年的结息日(mmDD) 
		// 修改月份之前一定要先修改日期
		nextValueDate = DateUtils.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate,settleInvestDay%100));
		nextValueDate = DateUtils.setMonths(nextValueDate, settleInvestDay/100-1);
	}
	
	@Test
	public void test15() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2018-07-01");
		Date expireDate = format.parse("2019-01-31");
		int settleInvestDay = 20;
		int period = 1;
		
		Date nextValueDate = null;
		//-- 1、期数为1；2、相差月份是3的倍数；3、起息日的日期<结息日
		System.out.println("===" + expireDate.getMonth());//-- 0
		System.out.println("===" + interestStartDate.getMonth());//-- 6
		if (period == 1 && (expireDate.getMonth()-interestStartDate.getMonth())%3==0 
				&& interestStartDate.getDate() < settleInvestDay) {
			nextValueDate = interestStartDate;
		} else {
			nextValueDate = DateUtils.add(interestStartDate, Calendar.MONTH, 3);
		}
		System.out.println("=====" + nextValueDate);
		Date setDays = DateUtils.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate, settleInvestDay));
		System.out.println("====" + setDays);//-- 10月20日
	}
	
	/**
	 * 按季付息，到期还本，获取下一个起息日
	 *
	 * @param interestStartDate
	 * @param expireDate
	 * @param calculatePeriodMode
	 * @param settleInvestDay
	 * @param period
	 * @return
	 * @author hongwei.lian
	 * @date 2018年9月25日 下午3:53:04
	 */
	private static Date getNextValueDateBySeason(Date interestStartDate, Date expireDate, int calculatePeriodMode, 
			int settleInvestDay, int period) {
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(interestStartDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		LocalDate firstEndDateExclusive = null;
		LocalDate nextValueDate = null;
		//-- 按自然计算周期计算下一期起息日
		if (Objects.equals(calculatePeriodMode, CalculatePeriodModeEnum.自然周期计算模式.getValue())) {
			//-- 优先处理第一期
			if (Objects.equals(period, 1)) {
				//-- 判断起息日
				int minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.MARCH, settleInvestDay);
				firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.MARCH, minDays);
				System.out.println("====1" + firstEndDateExclusive);
				if (startDateInclusive.isAfter(firstEndDateExclusive) 
						&& startDateInclusive.getMonth().getValue() >= Month.MARCH.getValue()  
						&& startDateInclusive.getMonth().getValue() <= Month.JUNE.getValue()) {
					minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.JUNE, settleInvestDay);
					firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.JUNE, minDays);
					System.out.println("====2" + firstEndDateExclusive);
				} else if (startDateInclusive.isAfter(firstEndDateExclusive)
						&& startDateInclusive.getMonth().getValue() >= Month.JUNE.getValue()  
						&& startDateInclusive.getMonth().getValue() <= Month.SEPTEMBER.getValue()) {
					minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.SEPTEMBER, settleInvestDay);
					firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.SEPTEMBER, minDays);
					System.out.println("====3" + firstEndDateExclusive);
				} else if (startDateInclusive.isAfter(firstEndDateExclusive) 
						&& startDateInclusive.getMonth().getValue() >= Month.SEPTEMBER.getValue()  
						&& startDateInclusive.getMonth().getValue() <= Month.DECEMBER.getValue()) {
					minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.DECEMBER, settleInvestDay);
					firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.DECEMBER, minDays);
					System.out.println("====4" + firstEndDateExclusive);
				} 
				System.out.println("startDateInclusive===" + startDateInclusive);
				System.out.println("firstEndDateExclusive===" + firstEndDateExclusive);
				if (startDateInclusive.isBefore(firstEndDateExclusive)) {
					nextValueDate = firstEndDateExclusive;
				} else {
					nextValueDate = DateTimeUtil.addMonths(startDateInclusive, 3);
				}
			} else {
				//-- 增加三个月
				nextValueDate = DateTimeUtil.addMonths(startDateInclusive, 3);
				//-- 如果增加三个月后起息日落在1、4、7、10月份上需要强制减去一个月
				if (nextValueDate.getMonth() == Month.JANUARY || nextValueDate.getMonth() == Month.APRIL 
						|| nextValueDate.getMonth() == Month.JULY || nextValueDate.getMonth() == Month.OCTOBER) {
					nextValueDate = DateTimeUtil.addMonths(nextValueDate, -1);
				}
			}
		} else {
			if (ObjectUtils.notEqual(period, 1)) {
				startDateInclusive = DateTimeUtil.addDays(startDateInclusive, -1);
			}
			nextValueDate = DateTimeUtil.addMonths(startDateInclusive, 3);
		}
		System.out.println(nextValueDate);
		nextValueDate = DateTimeUtil.setDays(nextValueDate, DateTimeUtil.getMinDays(nextValueDate, settleInvestDay));
		System.out.println(nextValueDate);
		return DateTimeUtil.toDate(DateTimeUtil.addDays(nextValueDate, 1));
	}
	
	@Test
	public void test16() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2018-9-20");
		Date expireDate = format.parse("2020-12-12");
		Date nextValueDate = getNextValueDateBySeason(interestStartDate, expireDate, 
				CalculatePeriodModeEnum.自然周期计算模式.getValue(), 20, 1);
		System.out.println("自然周期计算模式计算下一个起息日：" + nextValueDate);
		
		//-- 第一期：2018-12-01 -- 2018-12-30
		//-- 第二期：2018-12-31 -- 2019-03-30
		//-- 第三期：2019-03-31 -- 2019-06-30
		//-- 第四期：2019-07-01 -- 2019-09-30
		//-- 第五期：2019-10-01 -- 2019-12-30
		//-- 第六期：2019-12-31 -- 2020-03-30
	}
	
	@Test
	public void test17() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2019-11-01");
		Date expireDate = format.parse("2020-01-01");
		Date nextValueDate = getNextValueDateBySeason(interestStartDate, expireDate, 
				CalculatePeriodModeEnum.非自然周期计算模式.getValue(), 31, 4);
		System.out.println("普通计算周期模式计算下一个起息日：" + nextValueDate);
		
		//-- 第一期：2019-01-01 -- 2019-04-30
		//-- 第二期：2019-05-01 -- 2019-07-31
		//-- 第三期：2019-08-01 -- 2019-10-31
		//-- 第四期：2019-11-01 -- 2019-12-31  
	}
	
	/**
	 * 
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月26日 上午10:24:04
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test18() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2019-01-20");
		int dayOfMonth1 = interestStartDate.getDate();
		System.out.println("使用DateAPI获取当前时间所属月的日期：" + dayOfMonth1);
		
		//-- 将Date转换为Calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(interestStartDate);
		int dayOfMonth2 = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("使用CalendarAPI获取当前时间所属月的日期：" + dayOfMonth2);
		
		//-- 将Date转换为LocalDate
		LocalDate localDate = DateTimeUtil.toLocalDate(interestStartDate);
		int dayOfMonth3 = localDate.getDayOfMonth();
		System.out.println("使用LocalDateAPI获取当前时间所属月的日期：" + dayOfMonth3);
	}
	
	/**
	 * 按半年付息，到期还本，正常分期
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年9月26日 下午2:54:10
	 */
	@Test
	public void test19() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//-- 计息本金
		BigDecimal principal = new BigDecimal("1000");
		//-- 利率
		BigDecimal investProfit = new BigDecimal("0.200");
		
		//-- 第一期
		Date begin1 = format.parse("2018-10-01");
		Date end1 = format.parse("2018-12-24");
		int interestDay1 = DateTimeUtil.daysBetweenDate(begin1, end1) + 1;
		System.out.println("第一期计息天数：" + interestDay1);//90
		BigDecimal interest1 = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay1))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第一期利息：" + interest1);//50.00
		
		//-- 第二期
		Date begin2 = format.parse("2018-12-25");
		Date end2 = format.parse("2019-03-24");
		int interestDay2 = DateTimeUtil.daysBetweenDate(begin2, end2) + 1;
		System.out.println("第二期计息天数：" + interestDay2);//182
		BigDecimal interest2 = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay2))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第二期利息：" + interest2);//101.11
		
		//-- 第三期
		Date begin3 = format.parse("2019-06-25");
		Date end3 = format.parse("2019-09-22");
		int interestDay3 = DateTimeUtil.daysBetweenDate(begin3, end3) + 1;
		System.out.println("第三期计息天数：" + interestDay3);//182
		BigDecimal interest3 = principal.multiply(investProfit)
											              .multiply(new BigDecimal(interestDay3))
											              .divide(new BigDecimal(360), 2, BigDecimal.ROUND_DOWN);
		System.out.println("第三期利息：" + interest3);//50.00
	}
	
	@Test
	public void test1212() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date begin1 = format.parse("2018-09-01");
		int day = 31;
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(begin1);
		 int maxMonthDay = calendar.getActualMaximum(5);
		 if (day < maxMonthDay) {
		      System.out.println(day);
		 } else {
			 System.out.println(maxMonthDay);
		}
		 
		 System.out.println(UUIDUtil.getUUID());
	}
	
	/**
	 * 计算利息
	 *
	 * @throws ParseException
	 * @author hongwei.lian
	 * @date 2018年12月11日 下午4:40:03
	 */
	@Test
	public void test12112() throws ParseException {
		BigDecimal totalPrincipal = new BigDecimal("10000");
		BigDecimal subTotalPrincipal = totalPrincipal.multiply(
				new BigDecimal("1000").divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP));
	    System.out.println("==" + subTotalPrincipal);
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date begin1 = format.parse("2019-12-26");
		Date begin2 = format.parse("2019-02-20");
	    Integer interestDay = DateTimeUtil.daysBetweenDate(begin1, begin2) + 1;
	    System.out.println("==interestDay==" + interestDay);//-- 731
	    
	    begin1 = format.parse("2019-12-26");
		begin2 = format.parse("2020-01-18");
	    interestDay = DateTimeUtil.daysBetweenDate(begin1, begin2);
	    System.out.println("==interestDay111==" + interestDay);//-- 749
	    
	    int interestBaseDays = 360;
	    int zeroplace = 2;
	    int paramInt = BigDecimal.ROUND_DOWN;
	    totalPrincipal = new BigDecimal("200");
	    BigDecimal investProfit = new BigDecimal("0.1");
	    BigDecimal intesrt = totalPrincipal.multiply(investProfit).
	                          multiply(new BigDecimal(interestDay))
	                          .divide(new BigDecimal(interestBaseDays), zeroplace, paramInt);
	    System.out.println("==" + intesrt);//--19.83
	    
	    //-- 3.83  0.
	    
	    //-- 0.86 + 3.01
	    //-- 0.05  + 0.17
	    
	    
	    //-- 3.88   + 70.00  450.00     + 25.00
	    
	    //-- 25.55  460.00
	    
	    
	    //-- 2.91 + 10.20   35
	    //-- 1.66   + 5.83   月
	    
	    
	    //-- 0.21  +  1.01
	    //-- 0.25  +  1.16
	    //-- 5.95 + 27.76
	    
	    
	    
	}
	
	@Test
	public void testCal() throws ParseException {
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date begin1 = format.parse("2019-01-21");
		Date begin2 = format.parse("2019-02-20");
	    Integer interestDay = DateTimeUtil.daysBetweenDate(begin1, begin2) + 1;
	    System.out.println("==interestDay==" + interestDay);//-- 731
	    
	    int interestBaseDays = 360;
	    int zeroplace = 2;
	    int paramInt = BigDecimal.ROUND_DOWN;
	    BigDecimal totalPrincipal = new BigDecimal("466.67");
	    BigDecimal investProfit = new BigDecimal("0.15");
	    BigDecimal intesrt = totalPrincipal.multiply(investProfit).divide(
	    				new BigDecimal(12), zeroplace, paramInt);
	    System.out.println("==" + intesrt);//--19.83
	    
	    
//	    totalPrincipal = new BigDecimal("333.34");
//	    BigDecimal subTotalPrincipal = totalPrincipal.multiply(
//				new BigDecimal("300").divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP));
//		System.out.println(subTotalPrincipal);
//		
//		BigDecimal divide = subTotalPrincipal.divide(new BigDecimal(2), 2, BigDecimal.ROUND_DOWN);
//		System.out.println(divide);
	}
	
	@Test
	public void test1345() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2019-01-01");
		Date expireDate = format.parse("2020-12-31");
		LocalDate interestStartLocalDate = DateTimeUtil.toLocalDate(interestStartDate);
		LocalDate nextValueLocalDate = DateTimeUtil.toLocalDate(expireDate);
		System.out.println((Objects.equals(interestStartLocalDate.getMonthValue(), 
				nextValueLocalDate.getDayOfMonth()) 
				&& Objects.equals(interestStartLocalDate.getDayOfMonth(), nextValueLocalDate.getDayOfMonth())));
		
		String sss = "com.huajin.baymax.exception.BayMaxBaseException: 提前部分还款金额不能大于应还总本金";
		System.out.println(sss.indexOf(":"));
		System.out.println(sss.substring(sss.indexOf(":") + 1));
	}
	
	@Test
	public void test132245() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2019-01-15");
		Date expireDate = format.parse("2020-12-31");
		LocalDate interestStartLocalDate = DateTimeUtil.toLocalDate(interestStartDate);
		LocalDate nextValueDate = null;
		int settleInvestDay = 20;
		int period = 1;
		if (Objects.equals(period, 1) && interestStartLocalDate.getDayOfMonth() < settleInvestDay) {
			nextValueDate = interestStartLocalDate;
		} else {
			nextValueDate = DateTimeUtil.addMonths(interestStartLocalDate, 1);
		}
		nextValueDate = DateTimeUtil.setDays(nextValueDate, DateTimeUtil.getMinDays(nextValueDate, settleInvestDay));
		System.out.println(DateTimeUtil.toDate(DateTimeUtil.addDays(nextValueDate, 1)));
	}
	
	@Test
	public void test111121() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2018-12-12");
		Date expireDate = format.parse("2021-12-29");
		int settleInvestDay = 1231;
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(interestStartDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		LocalDate nextValueLocalDate = DateTimeUtil.addYears(startDateInclusive, 1);
		//-- 第一期
		if (Objects.equals(1, 1)){
			int expireMonth = endDateExclusive.getMonthValue();   
			int startMonth = startDateInclusive.getMonthValue(); 
			int settleMonth = settleInvestDay/100; 
			//-- 1、起息月<结息月；2、起息月=到期月=结息月 && 起息日<结息日 这两种情况需要调整第一期的周期
			boolean needAdapter = (startMonth < settleMonth) ||
					((Objects.equals(expireMonth, startMonth) && Objects.equals(expireMonth, settleMonth)) 
							&& (startDateInclusive.getDayOfMonth() < settleInvestDay%100));
			if (needAdapter) {
				//-- 下一期起息日
				nextValueLocalDate = startDateInclusive;
			}
		}
		System.out.println(nextValueLocalDate);
		nextValueLocalDate = DateTimeUtil.setDays(nextValueLocalDate, DateTimeUtil.getMinDays(nextValueLocalDate, 
				settleInvestDay%100));
		nextValueLocalDate = DateTimeUtil.setMonths(nextValueLocalDate, settleInvestDay/100);
		Date date = DateTimeUtil.toDate(DateTimeUtil.addDays(nextValueLocalDate, 1));
		System.out.println(date);
		
	}
	
	@Test
	public void test1111121() throws ParseException { 
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse(" 2018-12-12");
		Date expireDate = format.parse("2020-12-11");
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		int firstPeriod = 0;
		int settleInvestDay = 101;
		int calculatePeriodMode = CalculatePeriodModeEnum.自然周期计算模式.getValue();
		//-- 按照自然年模式
		if (Objects.equals(calculatePeriodMode, CalculatePeriodModeEnum.自然周期计算模式.getValue())) {
			//-- 判断起息日
			LocalDate firstEndDateExclusive = null;
			int minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.DECEMBER, settleInvestDay%100);
			firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.DECEMBER, minDays);
			//-- 如果起息日在自然半年指定日期之前，则更新为自然半年指定日期
			if (startDateInclusive.isBefore(firstEndDateExclusive)) {
				firstPeriod += 1;
				startDateInclusive = DateTimeUtil.addDays(firstEndDateExclusive, 1);
			}
		}
		System.out.println(firstPeriod);
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int periods = years;
		if (months > 0) {
			periods += 1;
		} else if (Objects.equals(months, 0) && days > 0) {
			periods += 1;
		}
		System.out.println(firstPeriod + periods);
	}
	
	@Test
	public void testRepayYearInterestStragey() throws ParseException { 
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2018-07-01");
		Date expireDate = format.parse("2021-12-29");
		Date nextValueDate = getNextValueDate(interestStartDate, expireDate, 2, 630);
		System.out.println(nextValueDate);
		
		
		//-- 兑付日：630    起息日：2018-06-01
		//-- 第一期：2018-06-01   2018-06-30
		//-- 第二期：2018-07-01   2019-06-30
		//-- 第三期：以此类推
		
		//-- 兑付日：101    起息日：2018-12-12
		//-- 第一期：2018-12-12   2019-01-01
		//-- 第二期：2019-01-02   2020-01-01
		//-- 第三期：以此类推
		
		
		//-- 兑付日：1231    起息日：2018-12-12
		//-- 第一期：2018-12-12   2018-12-31
		//-- 第二期：2019-01-01   2019-12-31
		//-- 第三期：以此类推
	}
	
	public static Date getNextValueDate(Date interestStartDate, Date expireDate , int period, int settleInvestDay) {
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(interestStartDate);
		LocalDate nextValueLocalDate = null;
		//-- 第一期
		if (Objects.equals(period, 1)){
			nextValueLocalDate = DateTimeUtil.addYears(startDateInclusive, 1);
			System.out.println("+1" + nextValueLocalDate);
			//-- 设置第一期计息截止日
			LocalDate firstEndDateExclusive = DateTimeUtil.setMonths(startDateInclusive, settleInvestDay/100);
			firstEndDateExclusive = DateTimeUtil.setDays(firstEndDateExclusive, settleInvestDay%100);
			if (startDateInclusive.isBefore(firstEndDateExclusive)) {
				nextValueLocalDate = startDateInclusive;
			}
			System.out.println("222==" + nextValueLocalDate);
			//-- 每年的结息日(mmDD)，修改月份之前一定要先修改日期
			nextValueLocalDate = DateTimeUtil.setDays(nextValueLocalDate, DateTimeUtil.getMinDays(nextValueLocalDate, 
					settleInvestDay%100));
			nextValueLocalDate = DateTimeUtil.setMonths(nextValueLocalDate, settleInvestDay/100);
			System.out.println(DateTimeUtil.toDate(DateTimeUtil.addDays(nextValueLocalDate, 1)));
		} else {
			//-- 在上一期的计息截止日基础上增加一年
			nextValueLocalDate = DateTimeUtil.addYears(DateTimeUtil.addDays(startDateInclusive, -1), 1);
			System.out.println(DateTimeUtil.toDate(nextValueLocalDate));
		}
		return DateTimeUtil.toDate(DateTimeUtil.addDays(nextValueLocalDate, 1));
	}
	
	
	@Test
	public void test1121211() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2019-01-01");
		Date expireDate = format.parse("2020-01-01");
		Date nextValueDate = getNextValueDateByHalfYear(interestStartDate, expireDate, 
				CalculatePeriodModeEnum.自然周期计算模式.getValue(), 31, 1);
		System.out.println(nextValueDate);
		
		//-- 第一期：2018-12-12   到  2018-12-30
		//-- 第一期：2018-12-31   到  2019-06-30
		//-- 第一期：2019-07-01   到  2019-12-30
		//-- 第一期：2019-12-31   到  2018-12-30
	}
	
	@Test
	public void test112121211() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2019-12-31");
		Date expireDate = format.parse(" 2025-12-12");
		Date nextValueDate = getNextValueDateByHalfYear(interestStartDate, expireDate, 
				CalculatePeriodModeEnum.非自然周期计算模式.getValue(), 30, 3);
		System.out.println(nextValueDate);
		
		//-- 第一期：2018-12-12   到  2019-06-30
		//-- 第一期：2019-07-01   到  2019-12-30
		//-- 第一期：2019-12-31   到  2020-06-30
		//-- 第一期：2019-12-31   到  2018-12-30
	}
	
	public static Date getNextValueDateByHalfYear(Date interestStartDate, Date expireDate, Integer calculatePeriodMode, 
			int settleInvestDay, int period) {
		LocalDate interestStartLocalDate = DateTimeUtil.toLocalDate(interestStartDate);
		LocalDate expireLocalDate = DateTimeUtil.toLocalDate(expireDate);
		LocalDate nextValueLocalDate = null;
		if (Objects.equals(calculatePeriodMode, CalculatePeriodModeEnum.自然周期计算模式.getValue())) {
			//-- 优先处理第一期
			if (Objects.equals(period, 1)) {
				//-- 判断起息日
				int minDays = DateTimeUtil.getMinDays(interestStartLocalDate, Month.JUNE, settleInvestDay);
				LocalDate firstEndDateExclusive = LocalDate.of(interestStartLocalDate.getYear(), Month.JUNE, minDays);
				System.out.println(firstEndDateExclusive);
				if (interestStartLocalDate.isAfter(firstEndDateExclusive)
						&& interestStartLocalDate.getMonth().getValue() >= Month.JUNE.getValue()  
						&& interestStartLocalDate.getMonth().getValue() <= Month.DECEMBER.getValue()) {
					minDays = DateTimeUtil.getMinDays(interestStartLocalDate, Month.DECEMBER, settleInvestDay);
					firstEndDateExclusive = LocalDate.of(interestStartLocalDate.getYear(), Month.DECEMBER, minDays);
					System.out.println("2==" + firstEndDateExclusive);
				}
				if (interestStartLocalDate.isBefore(firstEndDateExclusive)) {
					nextValueLocalDate = firstEndDateExclusive;
				} else {
					nextValueLocalDate = DateTimeUtil.addMonths(interestStartLocalDate, 6);
				}
				System.out.println("3==" + nextValueLocalDate);
			} else {
				System.out.println(interestStartLocalDate);
				nextValueLocalDate = DateTimeUtil.addMonths(interestStartLocalDate, 6);
				System.out.println("4==" + nextValueLocalDate);
				//-- 如果增加6个月后月份落在1、7月份，则强制减去一个月
				if (Objects.equals(nextValueLocalDate.getMonth(), Month.JANUARY) 
						|| Objects.equals(nextValueLocalDate.getMonth(), Month.JULY)) {
					nextValueLocalDate = DateTimeUtil.addMonths(nextValueLocalDate, -1);
					System.out.println("5==" + nextValueLocalDate);
				}
			}
		} else {
			if (ObjectUtils.notEqual(period, 1)) {
				interestStartLocalDate =  DateTimeUtil.addDays(interestStartLocalDate, -1);
				System.out.println("interestStartLocalDate=" + interestStartLocalDate);
			} 
			nextValueLocalDate = DateTimeUtil.addMonths(interestStartLocalDate, 6);
			System.out.println("nextValueLocalDate=" + nextValueLocalDate);
		}
		//-- 获取结息日和当月最大天数的较小者
		nextValueLocalDate = DateTimeUtil.setDays(nextValueLocalDate, DateTimeUtil.getMinDays(nextValueLocalDate, 
				settleInvestDay));
		System.out.println("nextValueLocalDate=" + nextValueLocalDate);
		return DateTimeUtil.toDate(DateTimeUtil.addDays(nextValueLocalDate, 1));
	}
	
	@Test
	public void test1121213211() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2018-12-18");
		Date expireDate = format.parse("2020-12-18");
		int countPeriodsByHalfYear = countPeriodsByHalfYear(interestStartDate, expireDate, 
				CalculatePeriodModeEnum.自然周期计算模式.getValue(), 1);
		System.out.println(countPeriodsByHalfYear);
	}
	
	public static int countPeriodsByHalfYear(Date valueDate, Date expireDate, Integer calculatePeriodMode, int settleInvestDay) {
		LocalDate startDateInclusive = DateTimeUtil.toLocalDate(valueDate);
		LocalDate endDateExclusive = DateTimeUtil.toLocalDate(expireDate);
		//-- 按照自然模式
		int firstPeriod = 0;
		if (Objects.equals(calculatePeriodMode, CalculatePeriodModeEnum.自然周期计算模式.getValue())) {
			//-- 判断起息日
			LocalDate firstEndDateExclusive = null;
			int minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.JUNE, settleInvestDay);
			firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.JUNE, minDays);
			if (startDateInclusive.isAfter(firstEndDateExclusive)
					&& startDateInclusive.getMonth().getValue() >= Month.JUNE.getValue()  
					&& startDateInclusive.getMonth().getValue() <= Month.DECEMBER.getValue()) {
				minDays = DateTimeUtil.getMinDays(startDateInclusive, Month.DECEMBER, settleInvestDay);
				firstEndDateExclusive = LocalDate.of(startDateInclusive.getYear(), Month.DECEMBER, minDays);
			}
			//-- 如果起息日在自然半年指定日期之前，则更新为自然半年指定日期
			if (startDateInclusive.isBefore(firstEndDateExclusive)) {
				firstPeriod += 1;
				startDateInclusive = DateTimeUtil.addDays(firstEndDateExclusive, 1);
			}
		}
		System.out.println(firstPeriod);
		int years = DateTimeUtil.betweenYearsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int months = DateTimeUtil.betweenMonthsOfTwoLocalDate(startDateInclusive, endDateExclusive);
		int days = DateTimeUtil.betweenDaysOfTwoLocalDate(startDateInclusive, endDateExclusive);
		//-- 计算到期日和起息日之间的相差月份
		int otherSum = years*12 + months + (days > 0 ? 1 : 0);
		return firstPeriod + (otherSum%6 == 0 ? otherSum/6 : otherSum/6 + 1);
	}
	
	@Test
	public void testCountSeason1() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2019-01-01");
		Date expireDate = format.parse("2020-01-01");
		//按季统计
		int periods = 0;
		//相差月份
		int months = (expireDate.getYear()- valueDate.getYear())*12 
				+ (expireDate.getMonth()-valueDate.getMonth()) 
				+ (expireDate.getDate() > valueDate.getDate()? 1: 0);
		if(months%3 == 0){
			periods += months/3;
		}else{
			periods += months/3 + 1;
		}
		System.out.println(periods);
	}
	
	@Test
	public void testSeason1() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date interestStartDate = format.parse("2019-07-31");
		Date expireDate = format.parse("2020-01-01");
		int period = 4;
		int settleInvestDay = 31;
		Date nextValueDate = null;
		//期数为1且相差月份是3的倍数且起息日的日期<结息日
		if (period == 1 && (expireDate.getMonth()-interestStartDate.getMonth())%3==0 
				&& interestStartDate.getDate() < settleInvestDay) {
			nextValueDate = interestStartDate;
		} else {
			nextValueDate = DateUtils.add(interestStartDate, Calendar.MONTH, 3);
		}
		System.out.println(DateUtils.setDays(nextValueDate, DateUtil.getMinDay(nextValueDate, settleInvestDay)));
	}
	
	//-- 2019-01-01 到  2019-01-30
   //--  2019-01-31 到  2019-04-29
	  //--  2019-04-30 到  2019-07-30
	  //--  2019-07-31 到  2019-10-30
	  //--  2019-10-31 到  2019-12-31
	//-- 合并前两期
}

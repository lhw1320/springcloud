package com.qdfae.jdk.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.qdfae.jdk.repayPlan.GenRepayStageParam;
import com.qdfae.jdk.utils.DateTimeUtil;
import com.qdfae.jdk.utils.DateUtil;

/**
 * GenRepayStageParam测试
 * 
 * @author hongwei.lian
 * 2018年2月24日 下午5:41:21
 */
public class GenRepayStageParamTest {
	
	/**
	 * 获取到期日
	 * 
	 * @author hongwei.lian
	 * 2018年2月24日 下午5:42:13
	 */
	@Test
	public void testGetExpireDate() {
		//-- 设置时间
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 1, 15);
		Date time = calendar.getTime();
		
		//-- 组装参数
		GenRepayStageParam param = new GenRepayStageParam(time, 10, 3, 1);
		Date expireDate = param.getExpireDate();
		System.out.println(expireDate);
	} 
	
	@Test
	public void test1() {
		BigDecimal principal = new BigDecimal("100000");//本金
        BigDecimal investProfit = new BigDecimal("0.1");//利率
        int interestDay = 365;//计息天数
        Integer interestBaseDays = 365;//计息基准天数
		BigDecimal interest = principal.multiply(investProfit)
		                                                  .multiply(new BigDecimal(interestDay))
		                                                  .divide(new BigDecimal(interestBaseDays), 2, BigDecimal.ROUND_DOWN);
		System.out.println("本期利息：" + interest);
	} 
	
    private static final int PLAIN_YEAR_DAYS = 365;
    
    private static final int LEAP_YEAR_DAYS = 366;
	
	@Test
	public void test2() throws ParseException {
		int zeroplace = 4;
		int paramInt = BigDecimal.ROUND_HALF_EVEN;
		BigDecimal principal = new BigDecimal("100000");//本金
        BigDecimal investProfit = new BigDecimal("0.1");//利率
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date valueDate = format.parse("2018-12-16");
		Date expireDate = format.parse("2019-03-14");
		int firstYear = DateUtil.getYear(valueDate);
        int lastYear = DateUtil.getYear(expireDate);
        BigDecimal interest = BigDecimal.ZERO;//利息
        int interestDay = 89; // 计息天数
        if (firstYear != lastYear) { //如果首年与尾年不是同一年
            //获取首年天数
            int firstYearDays = DateUtil.getDiffByDate(DateUtil.getYearLast(firstYear), valueDate) + 1;
            int lastYearDays = DateUtil.getDiffByDate(expireDate, DateUtil.getYearFirst(lastYear));
            int calInterestDay = firstYearDays + lastYearDays;
            if (interestDay > calInterestDay) {
                lastYearDays = (interestDay - firstYearDays);
            }
            if (DateUtil.isLeapYear(firstYear)) {//是否是闰年
                interest = principal.multiply(investProfit).multiply(new BigDecimal(firstYearDays)).divide(new BigDecimal(LEAP_YEAR_DAYS), zeroplace, paramInt);
            } else {
                interest = principal.multiply(investProfit).multiply(new BigDecimal(firstYearDays)).divide(new BigDecimal(PLAIN_YEAR_DAYS), zeroplace, paramInt);
            }
            if (DateUtil.isLeapYear(lastYear)) {//是否是闰年
                interest = interest.add(principal.multiply(investProfit).multiply(new BigDecimal(lastYearDays)).divide(new BigDecimal(LEAP_YEAR_DAYS), zeroplace, paramInt));
            } else {
                interest = interest.add(principal.multiply(investProfit).multiply(new BigDecimal(lastYearDays)).divide(new BigDecimal(PLAIN_YEAR_DAYS), zeroplace, paramInt));
            }
            int diffYeay = lastYear - firstYear - 1;//相差年份
            interest = interest.add(principal.multiply(investProfit).multiply(new BigDecimal(diffYeay)).setScale(zeroplace, paramInt));
        } else {
            if (DateUtil.isLeapYear(firstYear)) {//是否是闰年
                interest = principal.multiply(investProfit).multiply(new BigDecimal(interestDay)).divide(new BigDecimal(LEAP_YEAR_DAYS), zeroplace, paramInt);
            } else {
                interest = principal.multiply(investProfit).multiply(new BigDecimal(interestDay)).divide(new BigDecimal(PLAIN_YEAR_DAYS), zeroplace, paramInt);
            }
        }
		System.out.println("本期利息：" + interest);
		//-- 2438.356
		//-- 2520.547
		//-- 2520.547
		//-- 2520.547
		
	} 
	
	@Test
	public void test111() {
		System.out.println(2438.35 + 2520.54 + 2520.54 + 2520.54);
		//-- 9999.97
		
		
		//-- 9999.99
		
		System.out.println(2438.3561 + 2520.5479 + 2520.5479 + 2520.5479);
		//-- 9999.9998
		
		//-- 
		
		
		System.out.println(2438.36 + 2520.55 + 2520.55 + 2520.55);
		//-- 10000.0
		
		
		System.out.println(2438.356 + 2520.547 + 2520.547 + 2520.547);
		//-- 9999.997000000001
		
		//-- 2438.36 2520.55 
		
		
		//-- BigDecimal.ROUND_HALF_UP
		//-- 10000.00
		//-- 2438.36  2520.55 2520.55 2520.55
		
		//-- BigDecimal.ROUND_HALF_DOWN
		//-- 10000.00
		//-- 2438.36  2520.55 2520.55 2520.55
		
	}
	
	@Test
	public void test1211() {
		System.out.println(new BigDecimal("8.3552").setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		
		//-- 2.556  2.56
		//-- 2.554  2.55
		//-- 2.555  2.56
		//-- 2.565  2.56
		//-- 2.545  2.54
		//-- 2.5451 2.55
		//-- 8.3552  8.36
	}

}

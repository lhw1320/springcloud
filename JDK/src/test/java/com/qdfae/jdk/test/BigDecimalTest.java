package com.qdfae.jdk.test;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * BigDecimal API学习
 * 
 * @author hongwei.lian
 * 2018年2月22日 下午4:43:03
 */
public class BigDecimalTest {
	
	/**
	 * add
	 * 
	 * @author hongwei.lian
	 * 2018年2月22日 下午4:45:12
	 */
	@Test
	public void testAdd() {
		
	} 
	
	/**
	 * subtract
	 * 
	 * @author hongwei.lian
	 * 2018年2月22日 下午4:45:22
	 */
	@Test
	public void testSubtract() {
		
	} 
	
	/**
	 * multiply
	 * 
	 * @author hongwei.lian
	 * 2018年2月22日 下午4:45:28
	 */
	@Test
	public void testMultiply() {
		
	} 
	
	/**
	 * divide
	 * public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
	 * divisor：除数
	 * scale：保留小数位数
	 * roundingMode：保留算法
	 * 
	 * BigDecimal.ROUND_HALF_UP 四舍五入
	 * 
	 * @author hongwei.lian
	 * 2018年2月22日 下午4:45:33
	 */
	@Test
	public void testDivide() {
		//-- 利息
		BigDecimal interest = new BigDecimal(30);
		//-- 期限
		int timeLimit = 45;
		interest = new BigDecimal(timeLimit).divide(new BigDecimal(100), 1, BigDecimal.ROUND_HALF_UP);
		System.out.println(interest);//0.42
	} 
	
	/**
	 * pow
	 * public BigDecimal pow(int paramInt)
	 * paramInt：指数
	 * 
	 * ROUND_DOWN 舍去
	 * 
	 * @author hongwei.lian
	 * 2018年2月24日 下午1:51:42
	 */
	@Test
	public void testPow() {
		
		BigDecimal pow = new BigDecimal(2).pow(4);
		System.out.println(pow);//2^4=16

		
//		BigDecimal totalPrincipal = new BigDecimal(1000);
//		BigDecimal monthlyInterestRate = new BigDecimal(0.41);
//		int periodNum = 1;//第一期
//		int periodNums = 16;
//		// 每月偿还的本金=贷款本金*月利率*(1+月利率)^(当前期次-1)/((1+月利率)^总期次-1)
//		BigDecimal principal = totalPrincipal.multiply(monthlyInterestRate)
//							.multiply(monthlyInterestRate.add(BigDecimal.ONE).pow(periodNum - 1))
//							.divide((monthlyInterestRate.add(BigDecimal.ONE).pow(periodNums).subtract(BigDecimal.ONE)), 2,
//									BigDecimal.ROUND_DOWN);
		//System.out.println(principal);//1.68
	} 
	
	@Test
	public void testRoundingMode1() {
		//-- 被除数
		BigDecimal dividend = new BigDecimal(100);
		//-- 除数
		BigDecimal divisor = new BigDecimal(12);
		//-- 进位方式：舍位取值
		int roundingMode = BigDecimal.ROUND_DOWN;
		//-- 商
		BigDecimal quotient = dividend.divide(divisor, 2, roundingMode);
		System.out.println(quotient);//8.33
	}
	
	@Test
	public void testRoundingMode2() {
		//-- 被除数
		BigDecimal dividend = new BigDecimal(100);
		//-- 除数
		BigDecimal divisor = new BigDecimal(12);
		//-- 进位方式：进位取值
		int roundingMode = BigDecimal.ROUND_UP;
		//-- 商
		BigDecimal quotient = dividend.divide(divisor, 2, roundingMode);
		System.out.println(quotient);//8.34
	}
	
	@Test
	public void testRoundingMode3() {
		//-- 被除数
		BigDecimal dividend = new BigDecimal(100);
		//-- 除数
		BigDecimal divisor = new BigDecimal(8);
		//-- 进位方式：五舍六入
		int roundingMode = BigDecimal.ROUND_HALF_UP;
		//-- 商
		BigDecimal quotient = dividend.divide(divisor, 0, roundingMode);
		System.out.println(quotient);//13
	}
	
	@Test
	public void testRoundingMode4() {
		//-- 被除数
		BigDecimal dividend = new BigDecimal(100);
		//-- 除数
		BigDecimal divisor = new BigDecimal(8);
		//-- 进位方式：五舍六入
		int roundingMode = BigDecimal.ROUND_HALF_DOWN;
		//-- 商
		BigDecimal quotient = dividend.divide(divisor, 0, roundingMode);
		System.out.println(quotient);//12
	}
	
	@Test
	public void test11() {
		BigDecimal projectMoney = new BigDecimal("0.1000");
		System.out.println(projectMoney.divide(new BigDecimal("100"), 5, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void test12() {
		String string1 = "";
		String string2 = null;
		System.out.println(!StringUtils.equals(string2, string1));
	}

}

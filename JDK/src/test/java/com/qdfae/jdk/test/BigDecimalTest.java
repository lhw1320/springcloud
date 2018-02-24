package com.qdfae.jdk.test;

import java.math.BigDecimal;

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

}

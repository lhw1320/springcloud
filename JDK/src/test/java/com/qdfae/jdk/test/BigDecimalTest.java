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

}

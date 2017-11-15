package com.qdfae.jdk.operator;

import org.junit.Test;

/**
 * 运算符
 * @author hongwei.lian 
 * @date 2017年11月15日 下午11:09:08
 */
public class OperatorTest {
	
	/**
	 * 运算符运算级 
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午11:06:59
	 */
	@Test
	public void test() {
		int a = 1, b = 2, c = 3;
		int result1 = ++a+c+++b++;
		//拆分
		int result2 = (++a) + (c++) + (b++);
		System.out.println(result1);
		System.out.println(result2);;
	}

}

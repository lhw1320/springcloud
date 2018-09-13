package com.qdfae.jdk.bigdecimal;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * BigDecimalTest
 *
 * @author hongwei.lian
 * @date 2018年5月21日 上午10:21:34
 */
public class BigDecimalTest {
	
	/**
	 * BigDecimal构造函数区别
	 * 
	 * 涉及BigDecimal的API
	 * 1、public BigDecimal(int val)：不会失真
	 * 2、public BigDecimal(String val)：不会失真
	 * 3、public BigDecimal(double val)：会失真
	 * 
	 * 结论是如果使用BigDecimal构造方法构造BigDecimal数据类型，强烈建议使用public BigDecimal(String val)
	 * ，无论是整型还是浮点型都不会失真
	 *
	 * @author hongwei.lian
	 * @date 2018年9月12日 下午2:01:08
	 */
	@Test
	public void test1() {
		/**
		 * public BigDecimal(int val)
		 * 不会失真
		 */
		BigDecimal value1 = new BigDecimal(12);
		/**
		 * public BigDecimal(String val)
		 * 不会失真，强烈建议
		 */
		BigDecimal value2 = new BigDecimal("12");
		/**
		 * public BigDecimal(double val)
		 * 会失真
		 */
		BigDecimal value3 = new BigDecimal(12.555);
		/**
		 * public BigDecimal(String val)
		 * 不会失真，强烈建议
		 */
		BigDecimal value4 = new BigDecimal("12.555");
		System.out.println(value1);//-- 12
		System.out.println(value2);//-- 12
		System.out.println(value3);//-- 12.55499999999999971578290569595992565155029296875
		System.out.println(value4);//-- 12.555
	}
	
	/**
	 * java.lang.ArithmeticException异常处理
	 * 
	 * 涉及BigDecimal的API：
	 * 0、public BigDecimal(String val)
	 * 1、public BigDecimal divide(BigDecimal divisor)
	 * 2、public BigDecimal divide(BigDecimal divisor, int roundingMode)
	 * 3、public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
	 *
	 * @author hongwei.lian
	 * @date 2018年9月12日 下午1:43:36
	 */
	@Test
	public void test2() {
		//-- 被除数
		BigDecimal dividend = new BigDecimal("12");
		//-- 除数1（被除数可以整除除数）
		BigDecimal divisor1 = new BigDecimal("4");
		//-- 除数2（被除数不能整除除数）
		BigDecimal divisor2 = new BigDecimal("7");
		System.out.println("被除数：" + dividend);;//-- 12
		System.out.println("除数1：" + divisor1);;//-- 4
		System.out.println("除数2：" + divisor2);;//-- 7
		//-- 测试public BigDecimal divide(BigDecimal divisor)
		System.out.println(dividend.divide(divisor1));//-- 3
		System.out.println(dividend.divide(divisor2));//-- 抛出java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.异常
		//-- 测试public BigDecimal divide(BigDecimal divisor, int roundingMode)
		System.out.println(dividend.divide(divisor1, BigDecimal.ROUND_HALF_UP));//-- 3
		System.out.println(dividend.divide(divisor2, BigDecimal.ROUND_HALF_UP));//-- 2
		//-- 测试public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
		System.out.println(dividend.divide(divisor1, 2, BigDecimal.ROUND_HALF_UP));//-- 3.00
		System.out.println(dividend.divide(divisor2, 2, BigDecimal.ROUND_HALF_UP));//-- 1.71
	}
	
	/**
	 * BigDecimal数据类型四舍五入注意事项
	 * 
	 * 本身BigDecimal数据类型四舍五入是没有任何问题的
	 * 只不过是通过各种方法得出的结果可能是不一样的
	 * 
	 * 比如：
	 * 使用public BigDecimal(String val)和public BigDecimal(double val)得出的
	 * BigDecimal的值就是不同的，那么经过四舍五入结果当然也可能不会相同
	 *
	 * 涉及BigDecimal的API：
	 * public BigDecimal setScale(int newScale, int roundingMode)
	 *
	 * @author hongwei.lian
	 * @date 2018年9月12日 下午2:24:08
	 */
	@Test
	public void test3() {
		BigDecimal value1 = new BigDecimal(12.555);
		BigDecimal value2 = new BigDecimal("12.555");
		System.out.println(value1);//-- 12.55499999999999971578290569595992565155029296875
		System.out.println(value2);//-- 12.555
		System.out.println(value1.setScale(1, BigDecimal.ROUND_HALF_UP));//-- 12.6
		System.out.println(value2.setScale(1, BigDecimal.ROUND_HALF_UP));//-- 12.6
		System.out.println(value1.setScale(2, BigDecimal.ROUND_HALF_UP));//-- 12.55
		System.out.println(value2.setScale(2, BigDecimal.ROUND_HALF_UP));//-- 12.56
	}
	
	/**
	 * BigDecimal.ROUND_HALF_UP表示四舍五入保留算法
	 *
	 * @author hongwei.lian
	 * @date 2018年5月21日 上午10:35:53
	 */
	@Test
	public void testBigDecimal1() {
		//-- 项目金额
//		BigDecimal projectMoney = new BigDecimal("1000");
		//-- 平台服务费费率
//		BigDecimal platformFee = new BigDecimal("0.001");
//		BigDecimal feeAmount = projectMoney.multiply(platformFee).setScale(2, BigDecimal.ROUND_HALF_UP);
//		System.out.println(feeAmount);
		
		BigDecimal feeAmount = new BigDecimal("1.454");
		System.out.println(feeAmount.setScale(2, BigDecimal.ROUND_HALF_UP));
	}

}

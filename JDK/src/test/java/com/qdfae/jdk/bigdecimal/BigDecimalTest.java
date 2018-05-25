package com.qdfae.jdk.bigdecimal;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年5月21日 上午10:21:34
 */
public class BigDecimalTest {
	
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

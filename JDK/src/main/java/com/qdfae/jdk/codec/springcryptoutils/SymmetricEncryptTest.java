package com.qdfae.jdk.codec.springcryptoutils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTime;
import org.junit.Test;

import com.huajin.baymax.encrypt.SymmetricEncrypt;

public class SymmetricEncryptTest {
	
	private String accountName = "jkxDJxg1KSE=";
	
	@Test
	public void test1() {
		String decryptStr = SymmetricEncrypt.decryptStr(accountName);
		System.out.println(decryptStr);
	}
	
	@Test
	public void test2() {
		BigDecimal expectedIncome = BigDecimal.ZERO;
		List<BigDecimal> incomeList = new ArrayList<>();
		incomeList.add(new BigDecimal(0.08));
		incomeList.add(new BigDecimal(0.11));
		incomeList.add(new BigDecimal(0.04));
		for (BigDecimal income : incomeList) {
			expectedIncome = expectedIncome.add(income);
		}
		System.out.println(expectedIncome);
	}
	
	@Test
	public void test3() {
		//System.out.println(new BigDecimal(0.008).setScale(2, BigDecimal.ROUND_DOWN));
		
		
		
	}
	
	@Test
	public void test4() {
		//-- 总利息
		BigDecimal interest = new BigDecimal(0.89);
		
		//-- 分子：numerator 
		BigDecimal numerator = new BigDecimal(60)
				.multiply(new BigDecimal(0.15));
		System.out.println("分子：" + numerator);
		
		//-- 分母：denominator
		BigDecimal denominator = new BigDecimal(15)
				.multiply(new BigDecimal(0.05))
				.add(new BigDecimal(25)
						.multiply(new BigDecimal(0.1)))
				.add(new BigDecimal(60)
						.multiply(new BigDecimal(0.15)));
		System.out.println("分母：" + denominator);
		
		//-- 结果：result
		BigDecimal result = interest.multiply(numerator).divide(denominator, 2, BigDecimal.ROUND_DOWN);
		System.out.println("结果：" + result);
		
		
		
		//-- 65.68 + 788.24 兑付计划总利息：853.92
		
		//-- 86.65 + 7.22 = 93.87（差一分钱）、
		//-- 修改
		
		//-- 65.68 + 788.21
		
		
//		BigDecimal weight1 = new BigDecimal(20000)
//				.multiply(new BigDecimal(0.01))
//				.divide(new BigDecimal(20000)
//						.multiply(new BigDecimal(0.01))
//						.add(new BigDecimal(80000).multiply(new BigDecimal(0.03))), 2, BigDecimal.ROUND_DOWN);
//		
//		System.out.println(weight1);//0.07
////		BigDecimal weight2 = new BigDecimal(80000)
////				.multiply(new BigDecimal(0.03))
////				.divide(divisor, 2, BigDecimal.ROUND_DOWN);
////		System.out.println(weight2);//0.92
//		
//		//-- 按照权重
//		System.out.println(new BigDecimal(853.93).multiply(new BigDecimal(20000)
//				.multiply(new BigDecimal(0.01))).divide(new BigDecimal(20000)
//				.multiply(new BigDecimal(0.01))
//				.add(new BigDecimal(80000).multiply(new BigDecimal(0.03))), 2, BigDecimal.ROUND_DOWN));
//		
//		//65.68
//		
//		
//		//-- 按照比例
//		//System.out.println(interest.multiply(new BigDecimal(20000).divide(new BigDecimal(100000.00), 2, BigDecimal.ROUND_DOWN)));
////		2599.99999999999991534549437233181379269808530807495117187500000
////		0.07
////		59.775099999999996498445398174226284027099609375  785.6155
////		170.785999999999989995558280497789382934570312500

	}
	
	@Test
	public void test5() {
		BigDecimal denominator = BigDecimal.ZERO;
		Map<BigDecimal, BigDecimal> investProfitMap = new HashMap<>();
		investProfitMap.put(new BigDecimal(0.01), new BigDecimal(20000));
		investProfitMap.put(new BigDecimal(0.03), new BigDecimal(80000));
	    for (Entry<BigDecimal, BigDecimal> entry : investProfitMap.entrySet()) {
	    	denominator = denominator.add(entry.getKey().multiply(entry.getValue()));
	    }
	    System.out.println(denominator);
	    
	}

}

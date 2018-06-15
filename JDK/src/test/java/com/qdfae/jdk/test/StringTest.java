package com.qdfae.jdk.test;

import org.junit.Test;

public class StringTest {
	
	@Test
	public void test1() {
		//-- 实体账户
		String accountNo = "15000091139455";
		System.out.println(accountNo.length());
		
		//-- 清分子账户：30205413   影子账户
		String subAccountNo1 = "30105413000000";
		System.out.println(subAccountNo1.length());
		
		//-- 清分子账户：30205413   费用账户
		String subAccountNo2 = "30105413000001";
		System.out.println(subAccountNo2.length());
		
		
		//-- 产品户
		String subAccountNo3 = "30105413000002";
		System.out.println(subAccountNo3.length());
		//System.out.println(subAccountNo3.substring(beginIndex, endIndex));
	}

}

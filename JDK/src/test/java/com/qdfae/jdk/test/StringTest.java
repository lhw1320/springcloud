package com.qdfae.jdk.test;

import org.apache.commons.lang3.StringUtils;
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
	
	@Test
	public void test2() {
		String retStr = "A0010101010100108000000dddd00000000040194015  123450220120620151810201206180000011037  000000:交易受理成功                                                                                       00000000000000000000000000000";
		System.out.println(retStr.length());
	}
	
	@Test
	public void test3() {
		String summary = "代11002873390701平安测试六零零零三三七七九五零九 付款 （ZZZZZ_投资顾问费_H5测试LXY21）";
		String fundUseType = null;
		if(StringUtils.isNotBlank(summary) && summary.indexOf("（") != -1 && summary.indexOf("）") != -1){
			String str = summary.substring(summary.indexOf("（") + 1, summary.indexOf("）"));
			System.out.println("str=" + str);
			String[] strArr = str.split("_");
			if(strArr.length == 1){
				fundUseType = strArr[0];
			}else if(strArr.length > 1){
				fundUseType = strArr[1];
			}
		}
		System.out.println("fundUseType=" + fundUseType);
	}
	
	@Test
	public void test4() {
		String summary = "代11002873390701平安测试六零零零三三七七九五零九 付款 （交易服务费）";
		String fundUseType = null;
		if(StringUtils.isNotBlank(summary) && summary.indexOf("（") != -1 && summary.indexOf("）") != -1){
			String str = summary.substring(summary.indexOf("（") + 1, summary.indexOf("）"));
			System.out.println("str=" + str);
			String[] strArr = str.split("_");
			if(strArr.length == 1){
				fundUseType = strArr[0];
			}else if(strArr.length > 1){
				fundUseType = strArr[1];
			}
		}
		System.out.println("fundUseType=" + fundUseType);
	}
	
	@Test
	public void test5() {
		String summary = "代11002873390701平安测试六零零零三三七七九五零九 付款 （交易服务费）";
		String fundUseType = null;
		if(StringUtils.isNotBlank(summary) && summary.indexOf("（") != -1 && summary.indexOf("）") != -1){
			String str = summary.substring(summary.indexOf("（") + 1, summary.indexOf("）"));
			System.out.println("str=" + str);
			String[] strArr = str.split("_");
			if(strArr.length == 1){
				fundUseType = strArr[0];
			}else if(strArr.length > 1){
				fundUseType = strArr[1];
			}
		}
		System.out.println("fundUseType=" + fundUseType);
	}
	
	@Test
	public void test6() {
		String summary = "ZZZZZ_投资顾问费";
		String fundUseType = null;
		if(StringUtils.isNotBlank(summary) && summary.indexOf("_") != -1){
			String str = summary.substring(summary.indexOf("_") + 1, summary.length());
			System.out.println("str=" + str);
			String[] strArr = str.split("_");
			fundUseType = strArr[0];
		}
		System.out.println("fundUseType=" + fundUseType);
	}
	
	@Test
	public void test7() {
		String summary = "ZZZZZ_放款_H5测试LXY21";
		String fundUseType = null;
		if(StringUtils.isNotBlank(summary) && summary.indexOf("_") != -1){
			String str = summary.substring(summary.indexOf("_") + 1, summary.length());
			System.out.println("str=" + str);
			String[] strArr = str.split("_");
			fundUseType = strArr[0];
		}
		System.out.println("fundUseType=" + fundUseType);
	}


}

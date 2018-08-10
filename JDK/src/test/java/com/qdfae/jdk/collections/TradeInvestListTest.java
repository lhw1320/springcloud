package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.qdfae.jdk.domain.ListingTradeInvestVo;

/**
 * 判断某个值是否在给出的区间列表中
 *
 * @author hongwei.lian
 * @date 2018年8月6日 下午7:15:26
 */
public class TradeInvestListTest {
	
	/**
	 * 判断某个值是否在给出的区间列表中
	 *
	 * @author hongwei.lian
	 * @date 2018年8月6日 下午7:15:48
	 */
	@Test
	public void test1() {
		//-- 存放投资金额区间列表
		List<ListingTradeInvestVo> tradeInvestList = new ArrayList<>();
		tradeInvestList.add(new ListingTradeInvestVo(new BigDecimal("20.00"), new BigDecimal("30.00")));
		tradeInvestList.add(new ListingTradeInvestVo(new BigDecimal("80.00"), new BigDecimal("90.00")));
		tradeInvestList.add(new ListingTradeInvestVo(new BigDecimal("40.00"), new BigDecimal("60.00")));
		//-- 解析Excel得出的每一行投资金额
		BigDecimal tradeMoney = new BigDecimal("60");
		//-- 在认购区间列表的个数
		int inCount = 0;
		//-- 排序（自然），原因是从数据库取出的列表中不一定是从大到小的区间排序的（录入时导致的）
		tradeInvestList.sort(
				(tradeInvest1, tradeInvest2) 
				-> 
				tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()));
		for (int j = 0; j < tradeInvestList.size(); j++) {
			ListingTradeInvestVo tradeInvest = tradeInvestList.get(j);
			boolean moreEqualCompare = tradeMoney.compareTo(tradeInvest.getInvestAmountMin()) >= 0;
			boolean lessCompare = tradeMoney.compareTo(tradeInvest.getInvestAmountMax()) < 0;
			boolean lessEqualCompare = tradeMoney.compareTo(tradeInvest.getInvestAmountMax()) <= 0;
			if (j == tradeInvestList.size()-1) {
				//-- 如果是最后一组，则使用lessEqualCompare
				if (moreEqualCompare && lessEqualCompare) {
					inCount++;
				}
			} else {
				//-- 使用lessCompare
				if (moreEqualCompare && lessCompare) {
					inCount++;
				}
			}
		}
		if (inCount == 0) {
			System.out.println(tradeMoney + "不在认购区间内");
		}
		if (inCount > 0) {
			System.out.println(tradeMoney + "在认购区间内");
		}
	}

}

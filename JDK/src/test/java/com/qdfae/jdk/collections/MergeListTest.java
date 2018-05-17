package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.ListingTradeInvestVo;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年5月9日 下午7:57:13
 */
public class MergeListTest {
	
	private List<ListingTradeInvestVo> tradeInvestList1;
	
	private List<ListingTradeInvestVo> tradeInvestList2;
	
	private Map<Integer, List<ListingTradeInvestVo>> tradeInvestMap;
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月9日 下午8:00:09
	 */
	@Before
	public void Init() {
		tradeInvestList1 = new ArrayList<>();
		tradeInvestList1.add(new ListingTradeInvestVo(1, 2012, new BigDecimal(100000.00), new BigDecimal(0.01000)));
		tradeInvestList1.add(new ListingTradeInvestVo(3, 2012, new BigDecimal(200000.00), new BigDecimal(0.02000)));
		tradeInvestList1.add(new ListingTradeInvestVo(2, 2012, new BigDecimal(500000.00), new BigDecimal(0.05000)));
		tradeInvestList2 = new ArrayList<>();
		tradeInvestList2.add(new ListingTradeInvestVo(1, 2012, new BigDecimal(100000.00), new BigDecimal(0.01000)));
		tradeInvestList2.add(new ListingTradeInvestVo(3, 2012, new BigDecimal(200000.00), new BigDecimal(0.02000)));
		tradeInvestList2.add(new ListingTradeInvestVo(2, 2012, new BigDecimal(500000.00), new BigDecimal(0.05000)));
		tradeInvestMap = new HashMap<>();
		tradeInvestMap.put(1, tradeInvestList1);
		tradeInvestMap.put(2, tradeInvestList2);
	}

	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月9日 下午8:00:13
	 */
	@Test
	public void testMergeList() {
		//-- 获取key的List集合
		List<Integer> keyList = new ArrayList<>(tradeInvestMap.keySet());
		List<Integer> keyList2 = tradeInvestMap.keySet().stream().collect(Collectors.toList());
		//-- 以第一个List为基准组装对象参数
		List<ListingTradeInvestVo> tradeInvestList = tradeInvestMap.get(keyList.get(0));
		for (int i = 0; i < tradeInvestList.size(); i++) {
			for (int j = 1; j < keyList.size(); j++) {
				List<ListingTradeInvestVo> otherTradeInvestList = tradeInvestMap.get(keyList.get( j));
				tradeInvestList.get(i).setInvestAmountMin(tradeInvestList.get(i).
						getInvestAmountMin().add(otherTradeInvestList.get(i).getInvestAmountMin()));
				tradeInvestList.get(i).setInvestProfit(tradeInvestList.get(i).
						getInvestProfit().add(otherTradeInvestList.get(i).getInvestProfit()));
			}
		}
		tradeInvestList.forEach(tradeInvest -> {
			System.out.println(tradeInvest.getInvestAmountMin());
			System.out.println(tradeInvest.getInvestProfit());
		});
		
	}
	
}

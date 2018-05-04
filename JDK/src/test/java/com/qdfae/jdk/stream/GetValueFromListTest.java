package com.qdfae.jdk.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.ListingTradeInvestVo;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年5月2日 上午11:43:16
 */
public class GetValueFromListTest {
	
	private List<ListingTradeInvestVo> tradeInvestList;
	
	private List<ListingTradeInvestVo> filterTradeInvestList;
	
	/**
	 * 初始化
	 *
	 * @author hongwei.lian
	 * @date 2018年5月2日 上午11:45:49
	 */
	@Before
	public void Init() {
		tradeInvestList = new ArrayList<>();
		filterTradeInvestList = new ArrayList<>();
		tradeInvestList.add(new ListingTradeInvestVo(1, 2012, new BigDecimal(100000.00), new BigDecimal(0.01000)));
		tradeInvestList.add(new ListingTradeInvestVo(3, 2012, new BigDecimal(200000.00), new BigDecimal(0.02000)));
		tradeInvestList.add(new ListingTradeInvestVo(2, 2012, new BigDecimal(500000.00), new BigDecimal(0.05000)));
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月2日 上午11:43:52
	 */
	@Test
	public void testGetValue1() {
		BigDecimal orderMoney = new BigDecimal(100000.00);
		//-- 过滤、取最大值、获取
		Optional<ListingTradeInvestVo> optional = tradeInvestList.stream()
		                        .filter(tradeInvest -> orderMoney.compareTo(tradeInvest.getInvestAmountMin()) >= 0)
		                        .max((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()));
		if (!optional.isPresent()) {
			System.out.println("认购金额必须大于项目起投金额");
		}
		System.out.println(optional.get().getInvestAmountMin());
	}
	
	@Test
	public void testGetValue2() {
		BigDecimal orderMoney = new BigDecimal(250000.00);
//		tradeInvestList.stream()
//		                        .filter(tradeInvest -> orderMoney.compareTo(tradeInvest.getInvestAmountMin()) >= 0)
//		                        .sorted((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()))
//		                        .
		//System.out.println(tradeInvestVo.getInvestAmountMin());
		//System.out.println(501*1024*1024);//525336576
		
		//210763776
		//525336576
		
		
		System.out.println(20000/1000);//20S
		System.out.println(2000000/1000);//2000S
		System.out.println(2000000/1000/60);//33分钟
		
	}
	
	/**
	 *  
	 *
	 * @author hongwei.lian
	 * @date 2018年5月2日 下午12:40:56
	 */
	@Test
	public void testGetValue3() {
		BigDecimal orderMoney = new BigDecimal(650000.00);
		//-- 过滤、排序（自然排序，即从小到大）
		List<ListingTradeInvestVo> filterTradeInvestList = tradeInvestList.stream()
				.filter(tradeInvest -> orderMoney.compareTo(tradeInvest.getInvestAmountMin()) >= 0)
				.sorted((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()))
		        .collect(Collectors.toList());
		//-- 反转
		Collections.reverse(filterTradeInvestList);
		//-- 取出第一个值，即为最大值
		ListingTradeInvestVo tradeInvestVo = filterTradeInvestList.get(0);
		System.out.println(tradeInvestVo.getInvestAmountMin());
	}
	
}

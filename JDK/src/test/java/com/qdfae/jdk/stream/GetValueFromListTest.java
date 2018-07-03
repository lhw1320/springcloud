package com.qdfae.jdk.stream;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.ListingTradeInvest;
import com.qdfae.jdk.domain.ListingTradeInvestComplex;
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
		BigDecimal orderMoney = new BigDecimal(1000.00);
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
	
	@Test
	public void testGetValue4() {
		//-- 过滤、排序（自然排序，即从小到大）
		List<ListingTradeInvestVo> filterTradeInvestList = tradeInvestList.stream()
				.sorted((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()))
		        .collect(Collectors.toList());
		filterTradeInvestList.forEach(System.out::println);
	}
	
	@Test
	public void testGetValue5() {
		tradeInvestList.sort((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()));
		tradeInvestList.forEach(System.out::println);
	}
	
	/**
	 * 排序重新组装
	 * 
	 * JDK 1.8 新特性
	 * public interface List<E> extends Collection<E>
	 * default void sort(Comparator<? super E> c)
	 * 
	 *
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @author hongwei.lian
	 * @date 2018年6月25日 下午2:47:21
	 */
	@Test
	public void testGetValue6() throws IllegalAccessException, InvocationTargetException {
		//-- 1、从数据库查询
		//-- 这里使用组装好的tradeInvestList
		
		//-- 2、自然排序（从小到大）
		tradeInvestList.sort(
				(tradeInvest1, tradeInvest2) 
				-> 
				tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()));
		
		//-- 3、按照
		List<ListingTradeInvestComplex> tradeInvestComplexList = new ArrayList<>(tradeInvestList.size());
		for (int i = 0; i < tradeInvestList.size(); i++) {
			ListingTradeInvestComplex tradeInvest = new ListingTradeInvestComplex();
			BeanUtils.copyProperties(tradeInvest, tradeInvestList.get(i));
			BigDecimal investAmountMax = BigDecimal.ZERO;
			if (i < tradeInvestList.size()-1) {
				investAmountMax = tradeInvestList.get(i+1).getInvestAmountMin();
			} else if (i == tradeInvestList.size()-1) {
				//-- 如果是最后一项，设置为项目投资上限
				investAmountMax = this.getInvestAmountMax();
			}
			tradeInvest.setInvestAmountMax(investAmountMax);
			tradeInvestComplexList.add(tradeInvest);	
		}
		
		//-- 输出
		tradeInvestComplexList.forEach(System.out::println);
		tradeInvestComplexList.forEach(complex -> System.out.println(complex.getInvestAmountMax()));
	}

	/**
	 * 设置项目投资上限金额
	 *
	 * @return
	 * @author hongwei.lian
	 * @date 2018年6月25日 下午3:05:02
	 */
	private BigDecimal getInvestAmountMax() {
		return new BigDecimal("1000000");
	}
	
}

package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.BizplanRepay;

/**
 * reduce操作
 *
 * @author hongwei.lian
 * @date 2018年6月1日 上午9:10:12
 */
public class StreamReduceTest {
	
	private List<BizplanRepay> bizplanRepayList;
	
	@Before
	public void init() {
		bizplanRepayList = new ArrayList<>();
		bizplanRepayList.add(new BizplanRepay(1, new BigDecimal("60.00"), new BigDecimal("60.00"), new BigDecimal("0.62")));
		bizplanRepayList.add(new BizplanRepay(2, new BigDecimal("70.00"), new BigDecimal("70.00"), new BigDecimal("0.78")));
	}
	
	/**
	 * Stream<T>接口
	 * Optional<T> reduce(BinaryOperator<T> accumulator);
	 *
	 * @author hongwei.lian
	 * @date 2018年6月1日 上午9:17:21
	 */
	@Test
	public void testReduce1() {
		BigDecimal totalPrincipal = bizplanRepayList.stream()
				                                                                .map(BizplanRepay::getPrincipal)
				                                                                .reduce((sum, count) -> sum.add(count))
				                                                                .get();
		System.out.println(totalPrincipal);
	}
	
}

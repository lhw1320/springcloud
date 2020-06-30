package com.qdfae.jdk.optional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.internal.function.numeric.Sum;

/**
 * Optional测试类
 *
 * @author hongwei.lian
 * @date 2020年6月30日 上午9:23:28
 */
public class OptionalTest {
	
	/**
	 * reduce
	 *
	 * @author hongwei.lian
	 * @date 2020年6月30日 上午9:24:43
	 */
	@Test
	public void testReduce() {
		List<BigDecimal> interestList = Arrays.asList(new BigDecimal("1"), new BigDecimal("2"));
		//List<BigDecimal> interestList = Collections.emptyList();
		BigDecimal reduce = interestList.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("==reduce==" + reduce);
	}
	
	@Test
	public void testReduce2() {
		List<BigDecimal> interestList = Arrays.asList(new BigDecimal("1"), new BigDecimal("2"));
		//List<BigDecimal> interestList = Collections.emptyList();
		BigDecimal reduce = interestList.stream().reduce((sum, count) -> sum.add(count)).orElse(BigDecimal.ZERO);
		System.out.println("==reduce==" + reduce);
	}

}

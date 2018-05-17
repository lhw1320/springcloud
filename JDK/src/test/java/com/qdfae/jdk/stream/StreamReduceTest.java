package com.qdfae.jdk.stream;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Stream reduce API
 * reduce：聚合
 * 
 * Stream不会自己存储元素。元素储存在底层集合或者根据需要产生。
 * Stream操作符不会改变源对象。相反，它会返回一个持有结果的新的Stream。
 * Stream操作可能是延迟执行的，这意味着它们会等到需要结果的时候才执行。
 * 
 * reduce()方法的处理方式一般是每次都产生新的数据集，
 * 
 * collect()方法是在原数据集的基础上进行更新，过程中不产生新的数据集。
 *
 * @author hongwei.lian
 * @date 2018年5月17日 下午2:48:52
 */
public class StreamReduceTest {
	
	@Test
	public void testReduce1() {
		Integer result = Stream.of(1, 2, 3, 4)
		                                      .reduce(100, (sum, item) -> sum + item);
		System.out.println(result);//110
	}
	
	/**
	 * T reduce(T identity, BinaryOperator<T> accumulator);
	 *
	 * @author hongwei.lian
	 * @date 2018年5月17日 下午8:35:34
	 */
	@Test
	public void testReduce2() {
		Integer result = Stream.of(1, 2, 3, 4)
				                              .reduce(100, Integer::sum);
		System.out.println(result);//110
	}
	
	/**
	 * Optional<T> reduce(BinaryOperator<T> accumulator);
	 *
	 * @author hongwei.lian
	 * @date 2018年5月17日 下午8:36:25
	 */
	@Test
	public void testReduce3() {
		Optional<Integer> optional = Stream.of(1, 2, 3, 4).reduce(Integer::sum);
		System.out.println(optional.get());//10
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月17日 下午2:49:32
	 */
//	@Test
//	public void testReduce1() {
//		 BigDecimal principal = new BigDecimal(15); //本金
//	     BigDecimal investProfit = new BigDecimal(0.05);//利率
//	     int interestDay = 30;//计息天数
//	    Integer interestBaseDays = 360;//计息基准天数
//		BigDecimal interest = principal.multiply(investProfit).multiply(new BigDecimal(interestDay)).divide(new BigDecimal(interestBaseDays), 2, BigDecimal.ROUND_DOWN);
//		System.out.println(interest);
//	}

//	@Test
//	public void testReduce2() {
//		BigDecimal principal = new BigDecimal(60); //本金
//	     BigDecimal investProfit = new BigDecimal(0.15);//利率
//	     int interestDay = 30;//计息天数
//	    Integer interestBaseDays = 360;//计息基准天数
//		BigDecimal interest = principal.multiply(investProfit).multiply(new BigDecimal(interestDay)).divide(new BigDecimal(interestBaseDays), 2, BigDecimal.ROUND_DOWN);
//		System.out.println(interest);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

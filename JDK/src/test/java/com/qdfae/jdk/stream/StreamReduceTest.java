package com.qdfae.jdk.stream;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.lang3.ObjectUtils;
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
	
	/**
	 * 初值为0
	 */
	private int checked;
	
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
	
	@Test
	public void testReduce4() {
		//-- 传递过来的cfmRightMoney
		BigDecimal cfmRightMoney = new BigDecimal("30000");
		
		Map<BigDecimal, BigDecimal> investProfitMap = new HashMap<>();
		investProfitMap.put(new BigDecimal("0.05"), new BigDecimal("10000"));
		investProfitMap.put(new BigDecimal("0.10"), new BigDecimal("30000"));
		investProfitMap.put(new BigDecimal("0.15"), new BigDecimal("10000"));
		
		BigDecimal dbCfmRightMoney = investProfitMap.values().stream().reduce(BigDecimal::add).get();
		System.out.println("确权金额：" + dbCfmRightMoney);
		
		investProfitMap.forEach((investProfit, subCfmRightMoney) -> {
			BigDecimal subTotalPrincipal = cfmRightMoney.multiply(
					subCfmRightMoney.divide(dbCfmRightMoney, 2, BigDecimal.ROUND_HALF_UP));
			System.out.println("等比例划分：" + subTotalPrincipal);
		});
	}
	
	/**
	 * Objects.equals的注意事项
	 *
	 * @author hongwei.lian
	 * @date 2018年9月20日 上午10:09:23
	 */
	@Test
	public void testReduce5() {
		//-- Short类型与short类型比较：Short自动拆箱转换为short类型，再进行比较
		System.out.println(new Short("1") == (short)1);//true
		//-- Integer类型与short类型比较：Integer自动拆箱转换为int类型，
		//-- short类型向上提升类型转换为int类型，再比较
		System.out.println(new Integer("1") == (short)1);//true
		//-- Integer类型与short类型比较：short类型自动装箱为Short类型，再比较
		System.out.println(Objects.equals(new Integer("1"), (short)1));//false
		//-- Short类型与Short类型比较：short类型自动装箱为Short类型，再比较
		System.out.println(Objects.equals(new Short("1"), (short)1));//true
		//-- int类型与Short类型比较：int类型自动装箱为Integer类型，short类型自动装箱为Short类型，再比较
		System.out.println(Objects.equals(new Integer("1").intValue(), (short)1));//false
		//-- Short类型与Short类型比较：short类型自动装箱为Short类型，再比较
		System.out.println(Objects.equals(new Integer("1").shortValue(), (short)1));//true
		//-- Integer的shortValue()并不安全，会有溢出问题
		
		
		//System.out.println(new Integer("1") == 1);//true
		//System.out.println(Objects.equals(new Integer("1"), 1));//true
	}
	
	@Test
	public void testReduce6() {
		System.out.println(ObjectUtils.notEqual(new Integer("2"), (short)2));//true
		System.out.println(new Integer("2") != (short)2);//false
		System.out.println(ObjectUtils.notEqual(new Integer("2").shortValue(), (short)2));//false
		
		System.out.println(new Short("1").intValue() == (short)1);//true
		System.out.println(Objects.equals(new Short("1").intValue(), (short)1));//false
		System.out.println(Objects.equals(new Short("1"), (short)1));//true
		System.out.println(Objects.equals(new Short("1").shortValue(), (short)1));//true
		System.out.println(Objects.equals(new Integer("1").shortValue(), (short)1));//true
		
	}
	
	@Test
	public void testReduce7() {
		BigDecimal[] principals = new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ZERO};
		principals[0] = principals[0].add(new BigDecimal("1"));
		principals[1] = principals[1].add(new BigDecimal("1"));
		System.out.println("应还本金：" + principals[0]);
		System.out.println("计息本金：" + principals[1]);
	}
	
	@Test
	public void testReduce8() {
		System.out.println("" != null);//true
		System.out.println(checked);//0
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月17日 下午2:49:32
	 */
	@Test
	public void testReduce11() {
		 BigDecimal principal = new BigDecimal(15); //本金
	     BigDecimal investProfit = new BigDecimal(0.05);//利率
	     int interestDay = 16;//计息天数
	    Integer interestBaseDays = 360;//计息基准天数
		BigDecimal interest = principal.multiply(investProfit).multiply(new BigDecimal(interestDay)).divide(new BigDecimal(interestBaseDays), 2, BigDecimal.ROUND_DOWN);
		System.out.println(interest);
	}

	@Test
	public void testReduce12() {
		BigDecimal principal = new BigDecimal(65); //本金
	     BigDecimal investProfit = new BigDecimal(0.15);//利率
	     int interestDay = 16;//计息天数
	    Integer interestBaseDays = 360;//计息基准天数
		BigDecimal interest = principal.multiply(investProfit).multiply(new BigDecimal(interestDay)).divide(new BigDecimal(interestBaseDays), 2, BigDecimal.ROUND_DOWN);
		System.out.println(interest);
	}
	
}

package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.BizplanRepay;

/**
 * List集合合并
 * 
 * 需求：
 * 一个金融产品具有多个认购金额，不同的认购金额区间对应不同的年化收益率
 * 例如：
 * 认购金额       年化收益率
 * 50000           1.00%
 * 100000         3.00%
 * 200000         5.00%
 * 那么现在的需求是投资者在投资认购者最低的认购金额就是50000起，
 * 认购金额在50000到99999之间那么年化收益率为1.00%
 * 认购金额在100000到199999之间那么年化收益率为3.00%
 * 认购金额在200000及以上的，那么年化收益率为5.00%
 * 
 * 投资者在投资认购后，系统经过确权后
 * 每个投资者订单的确权金额也经过上述认购金额和年化收益率的计算
 * 1、如果出现一个投资者持有超过一笔订单的情况，那么确权金额就是所有订单确权金额的总和
 *      那么计算年化收益的年化收益率为确权金额所在区间进行计算
 * 2、如果出现一个投资者确权金额小于最低的认购金额，那么该投资者的确权金额对应的
 *      年化收益的年化收益率为最低的年化收益率
 *      
 *  由于系统生成还款计划（包含计息本金、本金、利息）是按照固定的年化收益率去计算的
 *  那么对于多个年化收益率的金融产品不再适用，于是经过系统确权之后，
 *  按照不同的年化收益率计算对应的每个投资者确权金额的总和
 *  然后根据不同的年化收益率得出不同的确权本金，使用这两个参数生成对应的还款计划
 *  那么就有合并还款计划的需求，这就是问题
 *  
 *  经过分析得出可以得出这样两个方案：
 *  1、缓存不同年化收益率的还款计划方案一
 *       使用Map集合：key为年化收益率，
 *                               value为年化收益率对应的还款计划
 *  2、缓存不同年化收益率的还款计划方案二
 *       使用List集合：元素为不同年化收益率的还款计划
 *  3、需要明确一点，还款计划策略根据不同的还款方式生成的还款计划是一个List集合
 *        详见下面初始化数据方法
 *
 * @author hongwei.lian
 * @date 2018年5月19日 下午2:15:58
 */
public class MergeListTest {
	
	/**
	 * 年化收益率为5%还款计划
	 */
	private List<BizplanRepay> bizplanRepayList1;
	
	/**
	 * 缓存年化收益率为10%还款计划
	 */
	private List<BizplanRepay> bizplanRepayList2;
	
	/**
	 * 缓存年化收益率为15%还款计划
	 */
	private List<BizplanRepay> bizplanRepayList3;
	
	/**
	 * 缓存不同年化收益率的还款计划方案一
	 * 使用Map集合：key为年化收益率，value为年化收益率对应的还款计划
	 */
	private Map<BigDecimal, List<BizplanRepay>> bizplanRepayMap;
	
	/**
	 * 缓存不同年化收益率的还款计划方案二
	 * 使用List集合：元素为不同年化收益率的还款计划
	 */
	private List<List<BizplanRepay>> bizplanRepayLists;
	
	/**
	 * 合并后的还款计划
	 */
	private List<BizplanRepay> bizplanRepayList;
	
	/**
	 * 初始化
	 *
	 * @author hongwei.lian
	 * @date 2018年5月19日 下午2:24:11
	 */
	@Before
	public void Init() {
		bizplanRepayList1 = new ArrayList<>();
		bizplanRepayList1.add(new BizplanRepay(1, new BigDecimal("60.00"), new BigDecimal("60.00"), new BigDecimal("0.62")));
		bizplanRepayList1.add(new BizplanRepay(2, new BigDecimal("70.00"), new BigDecimal("70.00"), new BigDecimal("0.78")));
		bizplanRepayList2 = new ArrayList<>();
		bizplanRepayList2.add(new BizplanRepay(1, new BigDecimal("25.00"), new BigDecimal("25.00"), new BigDecimal("0.05")));
		bizplanRepayList2.add(new BizplanRepay(2, new BigDecimal("20.00"), new BigDecimal("20.00"), new BigDecimal("0.04")));
		bizplanRepayList3 = new ArrayList<>();
		bizplanRepayList3.add(new BizplanRepay(1, new BigDecimal("15.00"), new BigDecimal("15.00"), new BigDecimal("0.17")));
		bizplanRepayList3.add(new BizplanRepay(2, new BigDecimal("10.00"), new BigDecimal("10.00"), new BigDecimal("0.12")));
		//-- 初始化bizplanRepayMap
		bizplanRepayMap = new HashMap<>();
		bizplanRepayMap.put(new BigDecimal("0.05"), bizplanRepayList1);
		bizplanRepayMap.put(new BigDecimal("0.10"), bizplanRepayList2);
		bizplanRepayMap.put(new BigDecimal("0.15"), bizplanRepayList3);
		//-- 初始化bizplanRepayLists
		bizplanRepayLists = new ArrayList<>();
		bizplanRepayLists.add(bizplanRepayList1);
		bizplanRepayLists.add(bizplanRepayList2);
		bizplanRepayLists.add(bizplanRepayList3);
	}

	/**
	 * 用于遍历合并后的还款计划
	 *
	 * @author hongwei.lian
	 * @date 2018年5月19日 下午2:28:07
	 */
	@After
	public void forEach() {
		bizplanRepayList.forEach(bizplanRepay -> {
			System.out.println("还款计划当前期数：" + bizplanRepay.getPeriodNumber());
			System.out.println("计息本金：" + bizplanRepay.getInterestPrincipal());
			System.out.println("本金：" + bizplanRepay.getPrincipal());
			System.out.println("利息：" + bizplanRepay.getInterest());
		});
	}
	
	/**
	 * 方案一：
	 * 使用JDK API
	 * 
	 * 使用到的API：
	 * Map<K,V>（interface）
	 * Set<K> keySet();
	 * 
	 * Collection<E>（interface）
	 * default Stream<E> stream() {
	 *      return StreamSupport.stream(spliterator(), false);
	 * }
	 * 
	 * Stream<T>（interface）
	 * <R, A> R collect(Collector<? super T, A, R> collector);
	 * 
	 * Collectors（final class）
	 * public static <T> Collector<T, ?, List<T>> toList() {
	 *	        return new CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,
	 *	                                   (left, right) -> { left.addAll(right); return left; },
	 *	                                   CH_ID);
	 *	}
	 *
	 * @author hongwei.lian
	 * @date 2018年5月19日 下午2:29:15
	 */
	@Test
	public void testMergeList1() {
		//-- 1、获取key的List集合
		//-- 使用JDK API 将Set集合转换为List集合
		List<BigDecimal> keyList = new ArrayList<>(bizplanRepayMap.keySet());
		//-- 使用JDK8 Stream API 将Set集合转换为List集合
		//List<BigDecimal> keyList = bizplanRepayMap.keySet().stream().collect(Collectors.toList());
		
		//-- 2、以第一个List为基准组装对象参数
		List<BizplanRepay> mergeBizplanRepayList = bizplanRepayMap.get(keyList.get(0));
		
		//-- 3、组装每期计息本金、本金、利息
		for (int i = 0; i < mergeBizplanRepayList.size(); i++) {
			for (int j = 1; j < keyList.size(); j++) {
				List<BizplanRepay> otherBizplanRepayList = bizplanRepayMap.get(keyList.get( j));
				//-- 3.1、组装计息本金
				mergeBizplanRepayList.get(i).setInterestPrincipal(mergeBizplanRepayList.get(i).getInterestPrincipal()
						.add(otherBizplanRepayList.get(i).getInterestPrincipal()));
				//-- 3.2、组装本金
				mergeBizplanRepayList.get(i).setPrincipal(mergeBizplanRepayList.get(i).getPrincipal()
						.add(otherBizplanRepayList.get(i).getPrincipal()));
				//-- 3.3、组装利息
				mergeBizplanRepayList.get(i).setInterest(mergeBizplanRepayList.get(i).getInterest()
						.add(otherBizplanRepayList.get(i).getInterest()));
			}
		}
		
		//-- 4、赋值
		bizplanRepayList = mergeBizplanRepayList;
	}
	
	/**
	 * 方案一：
	 * 使用JDK8 Stream API
	 * 
	 * 使用到的API：
	 * Map<K,V>（interface）
	 * Collection<V> values();
	 * 
	 * Collection<E>（interface）
	 * default Stream<E> stream() {
	 *      return StreamSupport.stream(spliterator(), false);
	 * }
	 * 
	 * Stream<T>（interface）
	 * Optional<T> reduce(BinaryOperator<T> accumulator);
	 * reduce是归约的含义
	 * 
	 * Optional<T>（final class）
	 * public T get() {
	 *      if (value == null) {
	 *          throw new NoSuchElementException("No value present");
	 *      }
	 *      return value;
	 * }
	 * 
	 * @author hongwei.lian
	 * @date 2018年5月19日 下午3:01:19
	 */
	@Test
	public void testMergeList2() {
		 bizplanRepayList = bizplanRepayMap.values()
										                              .stream()
										                              .reduce(
										                            		  (bizplanRepayList1, bizplanRepayList2) -> {
																				  for (int i = 0; i < bizplanRepayList1.size(); i++) {
																					  //-- 组装计息本金
																					  bizplanRepayList1.get(i).setInterestPrincipal(
																							  bizplanRepayList1.get(i).getInterestPrincipal()
																							  .add(bizplanRepayList2.get(i).getInterestPrincipal()));
																					  //-- 组装本金
																					  bizplanRepayList1.get(i).setPrincipal(
																							  bizplanRepayList1.get(i).getPrincipal()
																							  .add(bizplanRepayList2.get(i).getPrincipal()));
																					  //-- 组装利息
																					  bizplanRepayList1.get(i).setInterest(
																							  bizplanRepayList1.get(i).getInterest()
																							  .add(bizplanRepayList2.get(i).getInterest()));
																				  }
																				  return bizplanRepayList1;})
										                              .get();
	}
	
	/**
	 * 方案二：
	 * 使用JDK API
	 * 
	 * @author hongwei.lian
	 * @date 2018年5月19日 下午3:03:28
	 */
	@Test
	public void testMergeList3() {
		//-- 1、以第一个List为基准组装对象参数
		List<BizplanRepay> mergeBizplanRepayList = bizplanRepayLists.get(0);
		
		//-- 2、组装每期计息本金、本金、利息
		for (int i = 0; i < mergeBizplanRepayList.size(); i++) {
			for (int j = 1; j < bizplanRepayLists.size(); j++) {
				List<BizplanRepay> otherBizplanRepayList = bizplanRepayLists.get(j);
				//-- 2.1、组装计息本金
				mergeBizplanRepayList.get(i).setInterestPrincipal(mergeBizplanRepayList.get(i).getInterestPrincipal()
						.add(otherBizplanRepayList.get(i).getInterestPrincipal()));
				//-- 2.2、组装本金
				mergeBizplanRepayList.get(i).setPrincipal(mergeBizplanRepayList.get(i).getPrincipal()
						.add(otherBizplanRepayList.get(i).getPrincipal()));
				//-- 2.3、组装利息
				mergeBizplanRepayList.get(i).setInterest(mergeBizplanRepayList.get(i).getInterest()
						.add(otherBizplanRepayList.get(i).getInterest()));
			}
		}
		
		//-- 3、赋值
		bizplanRepayList = mergeBizplanRepayList;
	}
	
	/**
	 * 方案二：
	 * 使用JDK Stream API
	 * 
	 * 使用到的API
	 * Collection<E>（interface）
	 * default Stream<E> stream() {
	 *      return StreamSupport.stream(spliterator(), false);
	 * }
	 * 
	 * Stream<T>（interface）
	 * Optional<T> reduce(BinaryOperator<T> accumulator);
	 * reduce是归约的含义
	 * 
	 * Optional<T>（final class）
	 * public T get() {
	 *      if (value == null) {
	 *          throw new NoSuchElementException("No value present");
	 *      }
	 *      return value;
	 * }
	 *
	 * @author hongwei.lian
	 * @date 2018年5月19日 下午3:07:20
	 */
	@Test
	public void testMergeList4() {
		bizplanRepayList = bizplanRepayLists.stream()
										                             .reduce(
															      		     (bizplanRepayList1, bizplanRepayList2) -> {
																				 for (int i = 0; i < bizplanRepayList1.size(); i++) {
																					  //-- 组装计息本金
																					  bizplanRepayList1.get(i).setInterestPrincipal(
																							  bizplanRepayList1.get(i).getInterestPrincipal()
																							  .add(bizplanRepayList2.get(i).getInterestPrincipal()));
																					  //-- 组装本金
																					  bizplanRepayList1.get(i).setPrincipal(
																							  bizplanRepayList1.get(i).getPrincipal()
																							  .add(bizplanRepayList2.get(i).getPrincipal()));
																					  //-- 组装利息
																					  bizplanRepayList1.get(i).setInterest(
																							  bizplanRepayList1.get(i).getInterest()
																							  .add(bizplanRepayList2.get(i).getInterest()));
																				  }
																				  return bizplanRepayList1;})
															         .get();
	}

}

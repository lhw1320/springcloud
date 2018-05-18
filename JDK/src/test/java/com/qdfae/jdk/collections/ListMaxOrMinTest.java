package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.ListingTradeInvest;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月16日 下午3:48:51
 */
public class ListMaxOrMinTest {
	
	/**
	 * 存储Integer类型
	 */
	private List<Integer> integerList;
	
	
	/**
	 * 存储String类型
	 */
	private List<String> stringList;
	
	/**
	 * 存储ListingTradeInvest类型
	 */
	private List<ListingTradeInvest> tradeInvestList;
	
	/**
	 * 数据初始化
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午3:51:13
	 */
	@Before
	public void init() {
		integerList = new ArrayList<>();
		integerList.add(3);
		integerList.add(5);
		integerList.add(1);
		integerList.add(9);
		stringList = new ArrayList<>();
		stringList.add("6002312");
		stringList.add("6002382");
		stringList.add("6002342");
		stringList.add("6002302");
		tradeInvestList = new ArrayList<>();
		tradeInvestList.add(new ListingTradeInvest(1, new BigDecimal(900), new BigDecimal(9.000)));
		tradeInvestList.add(new ListingTradeInvest(2, new BigDecimal(200), new BigDecimal(2.000)));
		tradeInvestList.add(new ListingTradeInvest(3, new BigDecimal(500), new BigDecimal(5.000)));
		tradeInvestList.add(new ListingTradeInvest(4, new BigDecimal(300), new BigDecimal(3.000)));
	}
	
	/**
	 * Collections
	 * public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)
	 * 要求：
	 *         1、T extends Object
	 *         2、Comparable<? super T>
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:04:12
	 */
	@Test
	public void testGetListMin11() {
		Integer min = Collections.min(integerList);
		System.out.println(min);
	}
	
	/**
	 * Collections
	 * public static <T extends Comparable<? super T>> void sort(List<T> list)
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:04:16
	 */
	@Test
	public void testGetListMin12() {
		Collections.sort(integerList);
		System.out.println(integerList.get(0));
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:04:20
	 */
	@Test
	public void testGetListMin13() {
		integerList.sort(null);
		System.out.println(integerList.get(0));
	}
	
	@Test
	public void testGetListMin14() {
		integerList.sort((integet1, integet2) -> integet1.compareTo(integet2));
		System.out.println(integerList.get(0));
	}
	
	@Test
	public void testGetListMin15() {
		integerList.sort(Integer::compare);
		System.out.println(integerList.get(0));
	}
	
	@Test
	public void testGetListMin16() {
		Integer min = integerList.stream().min(Integer::compare).get();
		System.out.println(min);
	}
	
	@Test
	public void testGetListMin17() {
		Stream<Integer> integerStream = integerList.stream().sorted();
		System.out.println(integerStream.findFirst().get());
	}
	
	@Test
	public void testGetListMin18() {
		Stream<Integer> integerStream = integerList.stream().sorted();
		System.out.println(integerStream.findFirst().get());
	}
	
	/**
	 * Collections
	 * public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp)
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:17:36
	 */
	@Test
	public void testGetListMin31() {
		ListingTradeInvest min = Collections.min(tradeInvestList, (tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()));
		System.out.println(min.getInvestAmountMin());
	}
	
	/**
	 * Collections
	 * public static <T> void sort(List<T> list, Comparator<? super T> c)
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:19:48
	 */
	@Test
	public void testGetListMin32() {
		Collections.sort(tradeInvestList, (tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()));
		System.out.println(tradeInvestList.get(0).getInvestAmountMin());
	}
	
	/**
	 * List
	 * default void sort(Comparator<? super E> c)
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:35:39
	 */
	@Test
	public void testGetListMin33() {
		tradeInvestList.sort((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()));
		System.out.println(tradeInvestList.get(0).getInvestAmountMin());
	}
	
	/**
	  * 使用API
	 * Collection
	 * default Stream<E> stream()
	 * Stream
	 * Stream<T> sorted()
	 * Optional<T> findFirst()
	 * Optional
	 * public T get()
	 * 
	 * 前提是ListingTradeInvest实现Comparable接口
	 * 并重写public int compareTo(T o)方法
	 * 
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:37:52
	 */
	@Test
	public void testGetListMin34() {
		ListingTradeInvest tradeInvest = 
				tradeInvestList.stream()
				                        .sorted()
				                        .findFirst()
				                        .get();
		System.out.println(tradeInvest.getInvestAmountMin());
	}
	
	/**
	 * 使用API
	 * Collection
	 * default Stream<E> stream()
	 * Stream
	 * Stream<T> sorted(Comparator<? super T> comparator)
	 * Optional<T> findFirst()
	 * Optional
	 * public T get()
	 * 
	 * 不需要实现Comparable接口
	 * 
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:43:06
	 */
	@Test
	public void testGetListMin35() {
		ListingTradeInvest tradeInvest = 
				tradeInvestList.stream()
				                        .sorted((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()))
				                        .findFirst()
				                        .get();
		System.out.println(tradeInvest.getInvestAmountMin());
	}
	
	/**
	 * 使用API
	 * Collection
	 * default Stream<E> stream()
	 * Stream
	 * Optional<T> min(Comparator<? super T> comparator)
	 * Optional
	 * public T get()
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 下午8:52:07
	 */
	@Test
	public void testGetListMin36() {
		ListingTradeInvest tradeInvest = 
				tradeInvestList.stream()
				                        .min((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()))
				                        .get();
		System.out.println(tradeInvest.getInvestAmountMin());
	}
	
	@Test
	public void testGetListMin37() {
		ListingTradeInvest tradeInvest = 
				tradeInvestList.stream()
										.min((tradeInvest1, tradeInvest2) -> tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()) == -1 ? -1 : (tradeInvest1.getInvestAmountMin().compareTo(tradeInvest2.getInvestAmountMin()) == 0 ? 0 : 1))
										.get();
		System.out.println(tradeInvest.getInvestAmountMin());
	}
	
}

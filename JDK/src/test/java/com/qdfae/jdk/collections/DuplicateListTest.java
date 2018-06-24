package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.TradeDetail;

/**
 * List集合去重
 * 
 * @author hongwei.lian 
 * @date 2018年3月11日 下午8:54:57
 */
public class DuplicateListTest {
	
	/**
	 * 存储没有去重的明细对象的List集合
	 */
	private List<TradeDetail> tradeDetailList;
	
	/**
	 * 存储去重后的明细对象的List集合
	 */
	private List<TradeDetail> duplicateTradeDetailList;
	
	/**
	 * 存储去重后的明细对象的Set集合
	 */
	private Set<TradeDetail> tradeDetailSet;
	
	/**
	 * 初始化tradeDetailList
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午9:04:45
	 */
	@Before
	public void InitTradeDetailList() {
		tradeDetailList = new ArrayList<>();
		tradeDetailList.add(new TradeDetail(1, "600010", "账户一", new BigDecimal(500.00)));
		tradeDetailList.add(new TradeDetail(2, "600011", "账户二", new BigDecimal(100.00)));
		tradeDetailList.add(new TradeDetail(3, "600010", "账户一", new BigDecimal(-100.00)));
		tradeDetailList.add(new TradeDetail(4, "600010", "账户一", new BigDecimal(-100.00)));
		tradeDetailList.add(new TradeDetail());
	}
	
	/**
	 * 使用Map集合进行List集合去重
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午9:05:49
	 */
	@Test
	public void testDuplicateListWithIterator() {
		duplicateTradeDetailList = new ArrayList<>();
		Map<String, TradeDetail> tradeDetailMap = tradeDetailList.stream()
		                       .collect(Collectors.toMap(
		                    		   tradeDetail -> tradeDetail.getAccountNo(), 
		                    		   tradeDetail -> tradeDetail,
		                    		   (oldValue, newValue) -> newValue));
		tradeDetailMap.forEach(
				(accountNo, tradeDetail) -> duplicateTradeDetailList.add(tradeDetail)
		);
		duplicateTradeDetailList.forEach(System.out::println);
		//-- 参考文章
		//http://blog.jobbole.com/104067/
		//https://www.cnblogs.com/java-zhao/p/5492122.html
	}
	
	/**
	 * 使用Set接口的实现类TreeSet进行List集合去重
	 * 
	 * TreeSet实现类
	 * 构造方法：
	 * public TreeSet(Comparator<? super E> comparator)
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午9:37:48
	 */
	@Test
	public void testDuplicateListWithTreeSet() {
		tradeDetailSet = new TreeSet<>(
				(tradeDetail1, tradeDetail2) 
				-> 
				tradeDetail1.getAccountNo().compareTo(tradeDetail2.getAccountNo())
		);
		tradeDetailSet.addAll(tradeDetailList.stream().filter(tradeDetailPab -> Objects.nonNull(tradeDetailPab.getAccountNo())).collect(Collectors.toList()));
		tradeDetailSet.forEach(System.out::println);
	}
	
	/**
	 * 使用Set接口的实现类HashSet进行List集合去重
	 * 
	 * HashSet实现类
	 * 构造方法：
	 * public TreeSet(Comparator<? super E> comparator)
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午9:37:51
	 */
	@Test
	public void testDuplicateListWithHashSet() {
		//-- 前提是TradeDetail根据规则重写hashCode()方法和equals()方法
		tradeDetailSet = new HashSet<>(tradeDetailList);
		tradeDetailSet.forEach(System.out::println);
	}
	
	/**
	 * String类的equals()方法和==
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月11日 下午9:28:12
	 */
	@Test
	public void testStringEquals() {
		String accountNo1 = "60010";
		String accountNo2 = "60010";
		System.out.println(accountNo1.equals(accountNo2));//true
		System.out.println(accountNo1 == accountNo2);//true
		System.out.println(accountNo1.compareTo(accountNo2));//0
		String accountNo3 = new String("60010");
		String accountNo4 = new String("60010");
		System.out.println(accountNo3.equals(accountNo4));//true
		System.out.println(accountNo3 == accountNo4);//false
		System.out.println(accountNo3.compareTo(accountNo4));//0
	}
	
	/**
	 * 合并相同账户中的金额
	 *
	 * @author hongwei.lian
	 * @date 2018年5月10日 下午2:15:00
	 */
	@Test
	public void testDuplicateListWithIterator1() {
		duplicateTradeDetailList = new ArrayList<>();
		Map<String, TradeDetail> tradeDetailMap = tradeDetailList.stream()
		                       .collect(Collectors.toMap(
		                    		   tradeDetail -> tradeDetail.getAccountNo(), 
		                    		   tradeDetail -> tradeDetail,
		                    		   (oldValue, newValue) -> {
		                    			    newValue.setBalance(newValue.getBalance().add(oldValue.getBalance()));
		                    			    return newValue;
		                    		   }));
		tradeDetailMap.forEach(
				(accountNo, tradeDetail) -> duplicateTradeDetailList.add(tradeDetail)
		);
		duplicateTradeDetailList.forEach(System.out::println);
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年5月10日 下午2:20:40
	 */
	@Test
	public void testDuplicateListWithIterator2() {
		Map<String, TradeDetail> tradeDetailMap = tradeDetailList.stream()
		                       .collect(Collectors.toMap(
		                    		   TradeDetail::getAccountNo, 
		                    		   tradeDetail -> tradeDetail,
		                    		   (oldValue, newValue) -> {
		                    			    newValue.setBalance(newValue.getBalance().add(oldValue.getBalance()));
		                    			    return newValue;
		                    		   }));
		tradeDetailMap.values().forEach(System.out::println);;
	}
	
}

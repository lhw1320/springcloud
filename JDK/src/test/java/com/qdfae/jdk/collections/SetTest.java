package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.qdfae.jdk.domain.TradeDetail;
import com.qdfae.jdk.domain.User;

/**
 * 使用Set集合对List集合进行去重
 * 
 * @author hongwei.lian 
 * @date 2018年3月9日 下午11:15:52
 */
public class SetTest {
	
	/**
	 * Integer类型的hashcode值就是它本身
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 上午12:23:04
	 */
	@Test
	public void testHashCode1() {
		Integer number1  = 1;
		Integer number2  = new Integer(2);
		Integer number3  = new Integer("3");
		System.out.println(number1.hashCode());//1
		System.out.println(number2.hashCode());//2
		System.out.println(number3.hashCode());//3
	}
	
	/**
	 * List集合的泛型为Integer类型
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月9日 下午11:32:53
	 */
	@Test
	public void testListToSet1() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		Set<Integer> set = new HashSet<>(list);
		System.out.println("list的个数为：" + list.size() + "个");
		list.forEach(System.out::println);
		System.out.println("set的个数为：" + set.size() + "个");
		set.forEach(System.out::println);
	}
	
	/**
	 * List集合的泛型为String类型
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月9日 下午11:34:15
	 */
	@Test
	public void testListToSet2() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("a");
		Set<String> set = new HashSet<>(list);
		System.out.println("list的个数为：" + list.size() + "个");
		list.forEach(System.out::println);
		System.out.println("set的个数为：" + set.size() + "个");
		set.forEach(System.out::println);
	}

	/**
	 * List集合的泛型为自定义类型User
	 * 问题：没有得到想要的结果，需求是userCode一样的便是同一个对象
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 上午12:32:12
	 */
	@Test
	public void testListToSet3() {
		List<User> list = new ArrayList<>();
		list.add(new User(1,"用户一","600001"));
		list.add(new User(2,"用户二","600002"));
		list.add(new User(3,"用户一","600001"));
		list.add(new User(4,"用户一","600001"));
		Set<User> set = new HashSet<>(list);
		System.out.println("list的个数为：" + list.size() + "个");
		list.forEach(System.out::println);
		System.out.println("set的个数为：" + set.size() + "个");
		set.forEach(System.out::println);
		//-- 分析自定义类型没有去重的原因
	}
	
	/**
	 * List集合的泛型为自定义类型User
	 * 方案一：重写自定义类型User的hashCode()方法和equals()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 下午2:36:16
	 */
	@Test
	public void testListToSet4() {
		List<User> list = new ArrayList<>();
		list.add(new User(1,"用户一","600001"));
		list.add(new User(2,"用户二","600002"));
		list.add(new User(3,"用户一","600001"));
		list.add(new User(4,"用户一","600001"));
		Set<User> set = new HashSet<>(list);
		System.out.println("list的个数为：" + list.size() + "个");
		list.forEach(System.out::println);
		System.out.println("set的个数为：" + set.size() + "个");
		set.forEach(System.out::println);
        //-- 分析去重的结果，重写equals()方法的前提是必须重写hashCode()方法
		
		//-- hashCode()方法
		
		//-- equals()方法
		
		//-- hashCode()方法和equals()方法两者的联系
	
	}
	
	/**
	 * List集合的泛型为自定义类型User
	 * 方案二：利用TreeSet集合带有比较器comparator的构造方法
	 * public TreeSet(Comparator<? super E> comparator) {
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 下午2:42:57
	 */
	@Test
	public void testListToSet5() {
		List<TradeDetail> list = new ArrayList<>();
		list.add(new TradeDetail(1, "600001", "账户一", new BigDecimal(100.00)));
		list.add(new TradeDetail(2, "600002", "账户二", new BigDecimal(100.00)));
		list.add(new TradeDetail(3, "600001", "账户一", new BigDecimal(-100.00)));
		list.add(new TradeDetail(4, "600001", "账户一", new BigDecimal(-100.00)));
		Set<TradeDetail> set = new TreeSet<>(new Comparator<TradeDetail>() {
			
			@Override
			public int compare(TradeDetail detail1, TradeDetail detail2) {
				return detail1.getAccountNo().compareTo(detail2.getAccountNo());
			}
			
		});
		set.addAll(list);
		System.out.println("list的个数为：" + list.size() + "个");
		list.forEach(System.out::println);
		System.out.println("set的个数为：" + set.size() + "个");
		set.forEach(System.out::println);
		
	}
	
	/**
	 * List集合的泛型为自定义类型User
	 * 方案二：利用TreeSet集合带有比较器comparator的构造方法
	 * public TreeSet(Comparator<? super E> comparator) {
	 * 
	 * 使用JDK8新特性Lambda表达式
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 下午2:42:57
	 */
	@Test
	public void testListToSet6() {
		List<TradeDetail> list = new ArrayList<>();
		list.add(new TradeDetail(1, "600001", "账户一", new BigDecimal(100.00)));
		list.add(new TradeDetail(2, "600002", "账户二", new BigDecimal(100.00)));
		list.add(new TradeDetail(3, "600001", "账户一", new BigDecimal(-100.00)));
		list.add(new TradeDetail(4, "600001", "账户一", new BigDecimal(-100.00)));
		Set<TradeDetail> set = new TreeSet<>(
				(detail1, detail2) -> detail1.getAccountNo().compareTo(detail2.getAccountNo())	
		);
		set.addAll(list);
		System.out.println("list的个数为：" + list.size() + "个");
		list.forEach(System.out::println);
		System.out.println("set的个数为：" + set.size() + "个");
		set.forEach(System.out::println);
		//-- 
	}
	
	/**
	 * 
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 下午3:08:30
	 */
	@Test
	public void testGetClass() {
		User user1 = new User(1,"用户一","600001");
		User user2 = new User(2,"用户一","600001");
		System.out.println(user1.getClass() == user2.getClass());//true
		System.out.println(user1.equals(user2));//true
		System.out.println(user1.hashCode() == user2.hashCode());//false
		System.out.println(user1 == user2);//false
	}
	
	/**
	 * String类型的compareTo()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 下午3:08:59
	 */
	@Test
	public void testStringCompareTo() {
		String subAccountNo1 = "600011";
		String subAccountNo2 = "600011";
		int result = subAccountNo1.compareTo(subAccountNo2);
		if (result == -1) {
			System.out.println("subAccountNo1的账号：" + subAccountNo1 + "小于subAccountNo2的账号：" + subAccountNo2);
		} else if (result == 0) {
			System.out.println("subAccountNo1的账号：" + subAccountNo1 + "等于subAccountNo2的账号：" + subAccountNo2);
		} else if (result == 1) {
			System.out.println("subAccountNo1的账号：" + subAccountNo1 + "大于subAccountNo2的账号：" + subAccountNo2);
		}
	}
	
	/**
	 * String类型的compareToIgnoreCase()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2018年3月10日 下午3:12:29
	 */
	@Test
	public void testStringCompareToIgnoreCase() {
		String subAccountNo1 = "600010";
		String subAccountNo2 = "600011";
		int result = subAccountNo1.compareToIgnoreCase(subAccountNo2);
		System.out.println(result);
	}
	
}

package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.qdfae.jdk.domain.Person;

/**
 * 集合相互转换
 * @author hongwei.lian 
 * @date 2017年11月15日 下午10:52:53
 */
public class CollectionConvertTest {
	
	/**
	 * Set集合转换为List集合方法1
	 * ArrayList的构造方法：ArrayList(Collection<? extends E> c)
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:36:41
	 */
	@Test
	public void testSetToList1() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(4);
		List<Integer> list = new ArrayList<>(set);
		System.out.println(list);
	}
	
	/**
	 * Set集合转换为List集合方法2
	 * 步骤1：先将Set集合转为数组
	 * 步骤2：使用Arrays工具类的asList方法：<T> List<T> asList(T... a)
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:36:41
	 */
	@Test
	public void testSetToList2() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(4);
		List<Object> list = Arrays.asList(set.toArray());//注意此处转换最终为Object类型
		System.out.println(list);
	}
	
	/**
	 * 
	 * @author hongwei.lian
	 * 2017年12月1日 上午11:36:45
	 */
	@Test
	public void testListToMap1() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Kobe", "Btrant"));
		personList.add(new Person(2, "Tom", "Smith"));
		personList.add(new Person(3, "Green", "Dayne"));
		personList.add(new Person(4, "Amy", "Jenny"));
		personList.add(new Person(5, "Lee", "David"));
		
		//List转换为Map
		Map<Integer, List<Person>> resultMap = personList.stream()
					.collect(Collectors.groupingBy(person -> person.getId()));
		 
		//遍历
		resultMap.forEach((key, value) -> {
			System.out.println("key = " + key + ", value = " + value);
		});
	}
	
	/**
	 * Collectors.groupingBy()方法
	 * 
	 * @author hongwei.lian
	 * 2017年12月1日 下午12:51:57
	 */
	@Test
	public void testListToMap2() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Kobe", "Btrant"));
		personList.add(new Person(2, "Tom", "Smith"));
		personList.add(new Person(3, "Green", "Dayne"));
		personList.add(new Person(4, "Amy", "Jenny"));
		personList.add(new Person(5, "Lee", "David"));
		
		//List转换为Map
		Map<Integer, List<Person>> resultMap = personList.stream()
					.collect(Collectors.groupingBy(Person::getId));
		 
		//遍历
		resultMap.forEach((key, value) -> {
			System.out.println("key = " + key + ", value = " + value);
		});
	}

	/**
	 *  Collectors.toMap()方法
	 * @author hongwei.lian
	 * 2017年12月1日 下午12:42:11
	 */
	@Test
	public void testListToMap3() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Kobe", "Btrant"));
		personList.add(new Person(2, "Tom", "Smith"));
		personList.add(new Person(3, "Green", "Dayne"));
		personList.add(new Person(4, "Amy", "Jenny"));
		personList.add(new Person(5, "Lee", "David"));
		
		//List转换为Map
		Map<Integer, Person> resultMap = personList.stream()
		                 .collect(Collectors.toMap(
		                		 person -> person.getId(),
		                		 person -> person
		                 ));
		 
		//遍历
		resultMap.forEach((key, value) -> {
			System.out.println("key = " + key + ", value = " + value);
		});
	}
	
	/**
	 *  Collectors.toMap()方法
	 * @author hongwei.lian
	 * 2017年12月1日 下午12:42:11
	 */
	@Test
	public void testListToMap4() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Kobe", "Btrant"));
		personList.add(new Person(2, "Tom", "Smith"));
		personList.add(new Person(3, "Green", "Dayne"));
		personList.add(new Person(4, "Amy", "Jenny"));
		personList.add(new Person(5, "Lee", "David"));
		
		//List转换为Map
		Map<Integer, Person> resultMap = personList.stream()
		                 .collect(Collectors.toMap(
		                		 Person::getId,
		                		 person -> person
		                 ));
		 
		//遍历
		resultMap.forEach((key, value) -> {
			System.out.println("key = " + key + ", value = " + value);
		});
	}

}

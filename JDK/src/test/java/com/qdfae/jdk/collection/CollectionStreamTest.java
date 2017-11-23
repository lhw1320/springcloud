package com.qdfae.jdk.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.junit.Test;

import com.qdfae.jdk.domain.Person;

public class CollectionStreamTest {
	
	/**
	 * List转换为Map：按照Person对象的ID进行分组
	 * 
	 * 方式一：
	 * 1、转换方式：遍历List依次放进新建的Map集合
	 * 2、遍历方式：增强for循环
	 * 
	 * @author hongwei.lian
	 * 2017年11月23日 下午12:43:36
	 */
	@Test
	public void testListToMap1(){
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Kobe", "Btrant"));
		personList.add(new Person(2, "Tom", "Smith"));
		personList.add(new Person(3, "Green", "Dayne"));
		personList.add(new Person(4, "Amy", "Jenny"));
		personList.add(new Person(5, "Lee", "David"));
		
		//List转换为Map
		Map<Integer, Person> personMap = new HashMap<>();
		for (Person person : personList) {
			personMap.put(person.getId(), person);
		}
		
		//遍历
		for(Entry<Integer, Person> entry : personMap.entrySet()) {
			System.out.println("[ key=" + entry.getKey() + " , value=" + entry.getValue() + " ]");
		}
	}
	
	/**
	 * List转换为Map：按照Person对象的ID进行分组
	 * 
	 * 方式二：
	 * 1、转换方式：JDK8新特性
	 *                       调用Collection的stream()方法，再调用collect()方法
	 *                       其中传入Collectors.toMap()方法进行键映射和值映射                 
	 *                                        
	 * 2、遍历方式：JDK8新特性
	 *                        调用Map接口的forEach()方法，其实就是增强for循环的简写方式
	 * 
	 * @author hongwei.lian
	 * 2017年11月23日 下午12:43:36
	 */
	@Test
	public void testListToMap2(){
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Kobe", "Btrant"));
		personList.add(new Person(2, "Tom", "Smith"));
		personList.add(new Person(3, "Green", "Dayne"));
		personList.add(new Person(4, "Amy", "Jenny"));
		personList.add(new Person(5, "Lee", "David"));
		
		//List转换为Map
		Map<Integer, Person> personMap = personList.stream()
		                 .collect(Collectors.toMap(person -> person.getId(), person -> person));
		
		//遍历
		personMap.forEach((key, value) -> System.out.println("[ key=" + key + " , value=" + value + " ]"));
	}

}

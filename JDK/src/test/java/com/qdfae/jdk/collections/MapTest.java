package com.qdfae.jdk.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;

import com.qdfae.jdk.domain.Person;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月9日 下午1:44:44
 */
public class MapTest {
	
	private List<Person> personList;
	
	@Before
	public void init() {
		personList = new ArrayList<>();
		personList.add(new Person(1, "Tom", "Lee", 22));
		personList.add(new Person(2, "Tom", "Lee", 22));
		personList.add(new Person(3, "Tom", "Lee", 22));
	}
	
	@Test
	public void testMap1() {
		Map<String, Object> map = new HashMap<>(2);
		map.put("source", 3);
		map.put("needGather", 1);
		map.put("gatherStatusDesc", new Integer[]{1, 4});
		map.forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});
	}
	
	@Test
	public void testMap2() {
		Set<Integer> ageSet = personList.stream()
														         .collect(Collectors
														        		 .toMap(
														        				 Person::getAge, 
														        				 person -> person,
														        				 (oldValue, newValue) -> newValue))
														         .keySet();
		System.out.println(ageSet.size());										
	}

}

package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.qdfae.jdk.domain.Person;

import cn.hutool.json.JSONUtil;

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
	
	@Test
	public void testMap3() {
		BigDecimal perRepayMoney = new BigDecimal("6.00");
		BigDecimal currentTotalMoney = new BigDecimal("10.00");
		if (perRepayMoney.subtract(currentTotalMoney).compareTo(BigDecimal.ZERO) >= 0) {
			System.out.println("错误的数据");
		} else {
			System.out.println("正确的数据");
		}
	}
	
	@Test
	public void testMap4() {
		Map<String, Object> map = new HashMap<>();
		map.put("list", personList);
		List<Person> list11 = (List<Person>) map.get("list");
		System.out.println("===" + JSON.toJSONString(list11));
	}

}

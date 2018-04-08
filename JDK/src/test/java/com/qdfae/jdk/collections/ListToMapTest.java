package com.qdfae.jdk.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.Person;
import com.qdfae.jdk.utils.DateUtil;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月8日 下午1:24:52
 */
public class ListToMapTest {
	
	/**
	 * 
	 */
	private List<Person> personList = new ArrayList<>();
	
	/**
	 * 
	 */
	private Map<Integer, Integer> ageMap = new HashMap<>();
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月8日 下午1:27:30
	 */
    @Before
	public void init() {
    	personList.add(new Person(1, "Jams", "Harden", 20));
    	personList.add(new Person(1, "Jams", "Harden", 20));
    	personList.add(new Person(1, "Jams", "Harden", 22));
    	personList.add(new Person(1, "Jams", "Harden", 23));
	}
	
    /**
     * 
     *
     * @author hongwei.lian
     * @date 2018年4月8日 下午1:30:44
     */
    @Test
	public void testListToMap1() {
		personList.forEach(person -> {
			Integer age = person.getAge();
			if (ageMap.containsKey(age)) {
				ageMap.put(age, ageMap.get(age) + 1);
			} else {
				ageMap.put(age, 1);
			}
		});
		ageMap.forEach((key, value) -> {
			System.out.println(key + "：" + value);
		});
	}
    
    /**
     * 
     *
     * @author hongwei.lian
     * @date 2018年4月8日 下午1:38:15
     */
    @Test
    public void testListToMap2() {
    	personList.stream().forEach(person -> {
			Integer age = person.getAge();
			if (ageMap.containsKey(age)) {
				ageMap.put(age, ageMap.get(age) + 1);
			} else {
				ageMap.put(age, 1);
			}
		});
		ageMap.forEach((key, value) -> {
			System.out.println(key + "：" + value);
		});
	}
    
    @Test
    public void testDateUtil() {
    	Date currDate = new Date();
    	String date = DateUtil.formatDate(currDate, "yyyy-MM-dd");
    	System.out.println(date);
    	Integer value = Integer.valueOf(DateUtil.formatDate(currDate, "yyyyMMdd"));
    	System.out.println(value);
    }

}

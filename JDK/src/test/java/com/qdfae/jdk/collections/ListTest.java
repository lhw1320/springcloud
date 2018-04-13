package com.qdfae.jdk.collections;

import java.util.List;

import org.junit.Test;

import com.qdfae.jdk.domain.Person;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月13日 下午1:02:27
 */
public class ListTest {
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月13日 下午1:02:37
	 */
	@Test
	public void testList1() {
		List<Person> list = null;
	    //new ArrayList<>();
		for (Person person : list) {
			System.out.println(person.getId());
		}
		list.forEach(person -> System.out.println(person.getId()));
	}

}

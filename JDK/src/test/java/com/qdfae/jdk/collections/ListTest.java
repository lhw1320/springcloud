package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 上午9:45:55
	 */
	@Test
	public void testList2() {
//		List<Person> list = new ArrayList<>();
//		
//		
//		
//		list.add(new Person(1,"Kobe","bant",new BigDecimal(23)));
//		list.add(new Person(2,"Kobe","bant",new BigDecimal(21)));
//		list.add(new Person(3,"Kobe","bant",new BigDecimal(27)));
//		list.add(new Person(4,"Kobe","bant",new BigDecimal(22)));
//		Person person = list.stream().min((person1, person2) 
//				-> person1.getAge().compareTo(person2.getAge()) == -1 ? -1 : (person1.getAge().compareTo(person2.getAge()) == 0 ? 0 : 1)).get();
//		System.out.println(person.getAge());
//		System.out.println(person.getId());	
	}

	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月16日 上午10:47:55
	 */
	@Test
	public void testList3() {
		BigDecimal b1 = new BigDecimal(1);
		BigDecimal b2 = new BigDecimal(2);
		boolean flag = b1.compareTo(b2) == 1;
	}
	
}

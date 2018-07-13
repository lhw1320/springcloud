package com.qdfae.jdk.collections;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.huajin.baymax.util.DateUtils;
import com.qdfae.jdk.domain.Person;
import com.qdfae.jdk.exception.BayMaxBaseException;
import com.qdfae.jdk.support.ResponseCodeBase;

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
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月24日 上午10:53:57
	 */
	@Test
	public void testList5() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Jams", "Harden", 22));
		personList.add(new Person(2, "Dayne", "Green", 24));
		personList.add(new Person(3, "Divad", "Lee", 22));
		List<Integer> idList = new ArrayList<>();
		personList.forEach(person -> idList.add(person.getId()));
		idList.forEach(System.out::println);
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月24日 上午10:59:22
	 */
	@Test
	public void testList6() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Jams", "Harden", 22));
		personList.add(new Person(2, "Dayne", "Green", 24));
		personList.add(new Person(3, "Divad", "Lee", 22));
		List<Integer> idList = personList.stream()
				.map(person -> person.getId())
				.collect(Collectors.toList());
		idList.forEach(System.out::println);
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月24日 上午11:29:39
	 */
	@Test
	public void testList7() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Jams", "Harden", 22));
		personList.add(new Person(2, "Dayne", "Green", 24));
		personList.add(new Person(3, "Divad", "Lee", 22));
		List<Integer> idList = personList.stream()
				.map(Person::getId)
				.collect(Collectors.toList());
		idList.forEach(System.out::println);
	}
	
	@Test
	public void testList8() throws ParseException {
		List<Person> personList = new ArrayList<>();
//		personList.add(new Person(1, "Jams", "Harden", 22));
//		personList.add(new Person(2, "Dayne", "Green", 24));
//		personList.add(new Person(3, "Divad", "Lee", 22));
		
//		String string = " ";
//		System.out.println(string.length());
//		System.out.println(string == null);
		
//		Person person = personList.get(personList.size() - 1);
//		System.out.println(person);
		Date syncBeginDate = DateUtils.parseDate("2018-07-01","yyyy-MM-dd");
		Date today = DateUtils.parseDate(LocalDate.now().toString(),"yyyy-MM-dd");
		if (today.before(syncBeginDate)) {
			//查询起始日大于当日，则数据有误
			throw new BayMaxBaseException(ResponseCodeBase.SYSTEM_ERROR, null, "日期条件有误");
		}
		
	}
	
	
	
	
	
	
	
	
}

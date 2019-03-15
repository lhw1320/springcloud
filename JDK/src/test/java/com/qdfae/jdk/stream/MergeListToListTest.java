package com.qdfae.jdk.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qdfae.jdk.domain.User;

public class MergeListToListTest {
	
	private List<User> userList1;
	
	private List<User> userList2;
	
	private List<User> margeList;
	
	@Before
	public void init() {
		userList1 = new ArrayList<>();
		userList1.add(new User(1, "Jams", "Harden"));
		userList1.add(new User(2, "Jams", "Worf"));
		userList1.add(new User(3, "Jams", "John"));
		userList2 = new ArrayList<>();
		userList1.add(new User(4, "David", "Lee"));
		userList1.add(new User(5, "David", "John"));
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年6月13日 下午3:26:05
	 */
	@Test
	public void test1() {
		userList1.addAll(userList2);
		margeList = userList1;
	}
	
	/**
	 * 
	 * Stream<T>接口
	 * @SafeVarargs
	 * @SuppressWarnings("varargs") // Creating a stream from an array is safe
	 * public static<T> Stream<T> of(T... values) {
	 *       return Arrays.stream(values);
	 * }
	 *
	 * @author hongwei.lian
	 * @date 2018年6月13日 下午3:26:08
	 */
	@Test
	public void test2() {
		margeList = Stream.of(userList1, userList2)
				                        .flatMap(userList -> userList.stream())
				                        .collect(Collectors.toList());
	}

	@After
	public void foreach() {
		margeList.forEach(System.out::println);
	}
	
}

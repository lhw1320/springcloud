package com.qdfae.jdk.collections;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 
 *
 * @author hongwei.lian
 * @date 2018年4月24日 下午12:45:54
 */
public class ArraysTest {
	
	/**
	 * Arrays
	 * public static <T> List<T> asList(T... a)方法
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年4月24日 下午12:46:30
	 */
	@Test
	public void testArrays1() {
		List<String> stringList = Arrays.asList("a", "b", "c", "d");
		stringList.add("e");
		stringList.forEach(System.out::println);
	}
	
	

}

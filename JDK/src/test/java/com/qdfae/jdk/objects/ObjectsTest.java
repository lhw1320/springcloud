package com.qdfae.jdk.objects;

import static org.mockito.Matchers.notNull;

import java.nio.charset.Charset;
import java.util.Objects;

import org.junit.Test;

import com.qdfae.jdk.domain.Person;

/**
 * Objects测试类
 * 
 * @author hongwei.lian
 * 2017年12月5日 上午11:50:48
 */
public class ObjectsTest {
	
	/**
	 * public static <T> T requireNonNull(T obj)
	 *
	 * @author hongwei.lian
	 * @date 2018年4月24日 下午8:20:27
	 */
	@Test
	public void testRequireNonNull() {
		Object object = Objects.requireNonNull("hello");
		System.out.println(object);
		Person person = null;
		Person person1 = Objects.requireNonNull(person);
		//System.out.println(person1);
	} 
	
	/**
	 * public static boolean equals(Object a, Object b)
	 *
	 * @author hongwei.lian
	 * @date 2018年4月24日 下午8:20:50
	 */
	@Test
	public void testEquals() {
		String username1 = "James";
		String username2 = "James";
		boolean stringFlag = Objects.equals(username1, username2);
		System.out.println(stringFlag);//true
		Person person1 = new Person(1, "James", "Harden");
		Person person2 = new Person(1, "James", "Harden");
		boolean personFlag = Objects.equals(person1, person2);
		System.out.println(personFlag);//false
	} 
	
	@Test
	public void testNull() {
//		String newPhone = "15012369653";
//		String oldPhone = "15012369643";
//		boolean equals = !Objects.equals(newPhone, oldPhone);
//		System.out.println(equals);//true
//		
//		boolean equals2 = !newPhone.equals(oldPhone);
//		System.out.println(equals2);//true
		
		
		
		int num1 = new Integer(1);
		int num2 = new Integer(2);
		boolean equals3 = !Objects.equals(num1, num2);
		System.out.println(equals3);//false
		
		
		
		
//		String newPhone1 = "15012369673";
//		String oldPhone1 = "15012369653";
//		boolean equals1 = Objects.equals(newPhone1, oldPhone1);
//		System.out.println(equals1);//false
	} 
	
}

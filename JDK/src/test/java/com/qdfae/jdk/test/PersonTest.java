package com.qdfae.jdk.test;

import java.util.Objects;

import org.junit.Test;

import com.qdfae.jdk.domain.Person;

/**
 * 
 * 
 * @author hongwei.lian
 * 2018年2月7日 下午8:19:34
 */
public class PersonTest {
	
	/**
	 * 默认值为null，并不是空对象
	 */
	Person person;
	
	/**
	 * 
	 * 
	 * @author hongwei.lian
	 * 2018年2月7日 下午8:19:47
	 */
	@Test
	public void test1() {
		boolean flag = Objects.nonNull(person);
		System.out.println(flag);//false
	} 
	
	/**
	 * 
	 * 
	 * @author hongwei.lian
	 * 2018年2月7日 下午8:22:58
	 */
	@Test
	public void test2() {
		Person person = new Person();
		boolean flag = Objects.nonNull(person);
		System.out.println(flag);//true
	} 
	
}

package com.qdfae.jdk.objects;

import java.util.Objects;

import org.junit.Test;

/**
 * Objects测试类
 * 
 * @author hongwei.lian
 * 2017年12月5日 上午11:50:48
 */
public class ObjectsTest {
	
	@Test
	public void testRequireNonNull() {
		Object object = Objects.requireNonNull("hello");
		System.out.println(object);
	} 

}

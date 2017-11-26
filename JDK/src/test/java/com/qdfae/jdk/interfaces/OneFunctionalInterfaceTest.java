package com.qdfae.jdk.interfaces;

import org.junit.Test;

public class OneFunctionalInterfaceTest {
	
	/**
	 * 匿名对象方式
	 * @author hongwei.lian  
	 * @date 2017年11月26日 下午9:16:53
	 */
	@Test
	public void testAction1() {
		OneFunctionalInterface oneFunctionalInterface = new OneFunctionalInterface() {
			
			@Override
			public void action() {
				System.out.println("action");
			}
			
		};
		oneFunctionalInterface.action();
		String name = oneFunctionalInterface.getName("OneFunctionalInterface");
		System.out.println("name:" + name);
	}
	
	/**
	 *  JDK8Lambda表达式方式
	 * @author hongwei.lian  
	 * @date 2017年11月26日 下午9:22:58
	 */
	@Test
	public void testAction2() {
		OneFunctionalInterface oneFunctionalInterface = () -> System.out.println("action");
		oneFunctionalInterface.action();
		String name = oneFunctionalInterface.getName("OneFunctionalInterface");
		System.out.println("name:" + name);
	}
	
}

package com.qdfae.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午10:43:49
 */
public class Main {
	
	/**
	 * main()方法
	 *  
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午10:44:12
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.sayHello("di"));
		context.close();
	}

}

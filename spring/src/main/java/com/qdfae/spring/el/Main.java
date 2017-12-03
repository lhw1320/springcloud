package com.qdfae.spring.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 上午12:36:16
 */
public class Main {
	
	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 上午12:36:30
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
		ElConfig resouceService = context.getBean(ElConfig.class);
		resouceService.outputResouce();
		context.close();
	}

}

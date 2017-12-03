package com.qdfae.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:32:35
 */
public class Main {
	
	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午11:32:58
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
	    DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
	    DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
	    demoAnnotationService.add();
	    demoMethodService.add();
	    context.close();
	}

}

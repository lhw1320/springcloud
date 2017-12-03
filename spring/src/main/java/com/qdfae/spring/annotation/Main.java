package com.qdfae.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:43:24
 */
public class Main {
	
	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午6:43:36
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		AnnotationService annotationService = context.getBean(AnnotationService.class);
		annotationService.outputResult();
	    context.close();
	}

}

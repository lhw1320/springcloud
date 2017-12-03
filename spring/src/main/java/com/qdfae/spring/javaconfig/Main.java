package com.qdfae.spring.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:00:21
 */
public class Main {
	
    /**
     * main()方法
     * 
     * @param args 
     * @author hongwei.lian  
     * @date 2017年12月2日 下午11:00:15
     */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.sayHello("java config"));
		context.close();
	}

}

package com.qdfae.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午4:03:00
 */
public class Main {

	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午4:03:17
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.getEnvironment().setActiveProfiles("dev");
		context.register(ProfileConfig.class);
		context.refresh();
		
		DemoBean demoBean = context.getBean(DemoBean.class);
		System.out.println(demoBean.getContext());
		
		context.close();
	}
	
}

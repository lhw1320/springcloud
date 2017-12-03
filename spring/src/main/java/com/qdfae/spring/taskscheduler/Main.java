package com.qdfae.spring.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午5:37:22
 */
public class Main {

	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午5:37:30
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
	}
	
}

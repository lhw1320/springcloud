package com.qdfae.spring.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:09:16
 */
public class Main {

	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午6:09:25
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
		ListService listService = context.getBean(ListService.class);
		System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令为：" + listService.showListCmd());
        context.close();	
	}
	
}

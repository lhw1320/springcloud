package com.qdfae.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:50:24
 */
public class Main {
	
	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午11:50:27
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);
		DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
		DemoSingletonService s2 = context.getBean(DemoSingletonService.class);
		DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
		DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
		//equals()此时比较的是对象的地址值
		System.out.println("s1与s2是否相等：" + s1.equals(s2));
		System.out.println("p1与p2是否相等：" + p1.equals(p2));
		context.close();
	}

}

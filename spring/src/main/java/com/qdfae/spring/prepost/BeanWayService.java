package com.qdfae.spring.prepost;

/**
 * 使用@Bean形式的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午3:22:50
 */
public class BeanWayService {
	
	/**
	 * init()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:24:39
	 */
	public void init() {
		System.out.println("@Bean-init-method");
	}
	
	/**
	 * 构造函数
	 */
	public BeanWayService() {
		super();
		System.out.println("初始化构造函数-BeanWayService");
	}
	
	/**
	 * destroy()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:26:16
	 */
	public void destroy() {
		System.out.println("@Bean-destroy-method");
	}

}

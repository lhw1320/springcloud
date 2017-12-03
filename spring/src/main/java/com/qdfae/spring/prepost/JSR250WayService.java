package com.qdfae.spring.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用JSR250形式的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午3:27:14
 */
public class JSR250WayService {
	
	/**
	 * init()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:28:06
	 */
	@PostConstruct
	public void init() {
		System.out.println("jsr250-init-method");
	}

	/**
	 * 构造函数
	 */
	public JSR250WayService() {
		super();
		System.out.println("初始化构造函数-JSR250WayService");
	}
	
	/**
	 * destroy()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:29:41
	 */
	@PreDestroy
	public void destroy(){
		System.out.println("jsr250-destroy-method");
	}

}

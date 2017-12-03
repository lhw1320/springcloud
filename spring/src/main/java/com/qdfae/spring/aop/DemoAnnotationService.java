package com.qdfae.spring.aop;

import org.springframework.stereotype.Service;

/**
 * 使用注解的被拦截类
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:07:56
 */
@Service
public class DemoAnnotationService {
	
	/**
	 * add()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午11:09:03
	 */
	@Action(name = "注解式拦截的add操作")
	public void add() {
		
	}

}

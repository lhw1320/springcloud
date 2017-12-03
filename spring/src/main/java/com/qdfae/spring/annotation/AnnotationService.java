package com.qdfae.spring.annotation;

import org.springframework.stereotype.Service;

/**
 * 服务Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:38:48
 */
@Service
public class AnnotationService {

	/**
	 * outputResult()方法
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午6:40:09
	 */
	public void outputResult() {
		System.out.println("从组合注解配置照样获得的bean");
	}
	
}

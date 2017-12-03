package com.qdfae.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午4:22:45
 */
@Component
public class DemoPublisher {

	@Autowired
	private ApplicationContext applicationContext;
	
	/**
	 * poblish()方法
	 * 
	 * @param msg 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午4:24:35
	 */
	public void poblish(String msg) {
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
	
}

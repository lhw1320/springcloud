package com.qdfae.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午4:17:21
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	/**
	 * onApplicationEvent()方法
	 */
	@Override
	public void onApplicationEvent(DemoEvent event) {
		String msg = event.getMsg();
		System.out.println("我（bean-demoListener）接收到了bean-demopublisher发布的消息：" + msg);
	}

}

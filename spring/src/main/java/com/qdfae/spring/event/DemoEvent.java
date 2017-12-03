package com.qdfae.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午4:14:57
 */
public class DemoEvent extends ApplicationEvent {

	private static final long serialVersionUID = 9061615639845110023L;

	private String msg;
	
	public DemoEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

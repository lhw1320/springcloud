package com.qdfae.spring.profile;

/**
 * 示例Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午3:54:46
 */
public class DemoBean {
	
	private String context;

	public DemoBean(String context) {
		super();
		this.context = context;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
}

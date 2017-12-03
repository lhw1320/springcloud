package com.qdfae.spring.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 需要被注入的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 上午12:04:04
 */
@Service
public class DemoService {

	@Value("其他类的属性")
	private String another;

	public String getAnother() {
		return another;
	}

	public void setAnother(String another) {
		this.another = another;
	}
	
}

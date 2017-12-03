package com.qdfae.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用功能类的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午10:39:14
 */
@Service
public class UseFunctionService {

	@Autowired
	private FunctionService functionService;
	
	/**
	 * sayHello()方法
	 * 
	 * @param word
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午10:40:47
	 */
	public String sayHello(String word) {
		return functionService.sayHello(word);
	}
	
}

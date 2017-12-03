package com.qdfae.spring.di;

import org.springframework.stereotype.Service;

/**
 * 功能类的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午10:35:56
 */
@Service
public class FunctionService {
	
	/**
	 * sayHello()方法
	 * 
	 * @param word
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午10:38:24
	 */
	public String sayHello(String word) {
		return "Hello " + word + " !";
	}

}

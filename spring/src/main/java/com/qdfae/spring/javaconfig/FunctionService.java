package com.qdfae.spring.javaconfig;

/**
 * 功能类的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午10:53:04
 */
public class FunctionService {
	
	/**
	 * sayHello()方法
	 * 
	 * @param word
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午10:53:16
	 */
	public String sayHello(String word) {
		return "Hello " + word + " !";
	}

}

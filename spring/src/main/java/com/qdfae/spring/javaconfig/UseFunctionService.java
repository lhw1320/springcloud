package com.qdfae.spring.javaconfig;

/**
 * 使用功能类的Bean
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午10:53:33
 */
public class UseFunctionService {

	private FunctionService functionService;
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}

    /**
     * sayHello()方法
     * 
     * @param word
     * @return 
     * @author hongwei.lian  
     * @date 2017年12月2日 下午10:53:42
     */
	public String sayHello(String word) {
		return functionService.sayHello(word);
	}
	
}

package com.qdfae.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午10:54:22
 */
@Configuration
public class JavaConfig {

	/**
	 * 创建功能类的Bean实例
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午10:55:29
	 */
	@Bean
	public FunctionService functionService() {
		return new FunctionService();
	}
	
	/**
	 * 创建使用功能类的Bean实例方式一
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午10:56:22
	 */
	@Bean
	public UseFunctionService useFunctionService() {
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService());
		return useFunctionService;
	}
	
	/**
	 * 创建使用功能类的Bean实例方式二
	 * 
	 * @param functionService
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午10:58:02
	 */
//	@Bean
//	public UseFunctionService useFunctionService(FunctionService functionService) {
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}
	
}

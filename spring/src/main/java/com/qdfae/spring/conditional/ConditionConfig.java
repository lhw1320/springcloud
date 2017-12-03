package com.qdfae.spring.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:05:14
 */
@Configuration
public class ConditionConfig {

	/**
	 * windowsListService()方法
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午6:07:23
	 */
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService windowsListService() {
		return new WindowsListService();
	}
	
	/**
	 * linuxListService()方法
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午6:07:20
	 */
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService linuxListService() {
		return new LinuxListService();
	}
	
}

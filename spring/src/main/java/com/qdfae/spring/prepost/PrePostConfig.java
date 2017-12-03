package com.qdfae.spring.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午3:33:03
 */
@Configuration
@ComponentScan("com.qdfae.spring.prepost")
public class PrePostConfig {

	/**
	 * 创建BeanWayService实例
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:34:34
	 */
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public BeanWayService beanWayService() {
		return new BeanWayService();
	}
	
	/**
	 * 创建JSR250WayService实例
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:35:33
	 */
	@Bean
	public JSR250WayService jsr250WayService() {
		return new JSR250WayService();
	}
	
}

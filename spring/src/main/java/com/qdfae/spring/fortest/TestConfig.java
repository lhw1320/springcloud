package com.qdfae.spring.fortest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午7:31:12
 */
@Configuration
public class TestConfig {

	/**
	 * 创建开发环境下的Bean
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午7:32:48
	 */
	@Bean
	@Profile("dev")
	public TestBean devTestBean(){
		return new TestBean("from development profile");
	}
	
	/**
	 * 创建生产环境下的Bean
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午7:33:18
	 */
	@Bean
	@Profile("prod")
	public TestBean prodTestBean(){
		return new TestBean("from production profile");
	}
	
}

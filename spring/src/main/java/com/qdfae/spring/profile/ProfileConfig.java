package com.qdfae.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午3:55:55
 */
@Configuration
public class ProfileConfig {

	/**
	 * Profile为dev时实例化devDemoBean
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:59:17
	 */
	@Bean
	@Profile("dev")
	public DemoBean devDemoBean() {
		return new DemoBean("from development profile");
	}
	
	/**
	 * Profile为prod时实例化prodDemoBean
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午3:59:38
	 */
	@Bean
	@Profile("prod")
	public DemoBean prodDemoBean() {
		return new DemoBean("from production profile");
	}
	
}

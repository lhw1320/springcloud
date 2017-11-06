package com.qdfae.eureka_consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 第二种方式：推荐使用
 * 自定义配置类
 * 
 * @author hongwei.lian
 * 2017年11月6日 上午10:18:56
 */
@Configuration
public class MyConfiguration {
	
	/**
	 * 注入RestTemplate
	 * 
	 * @return
	 * @author hongwei.lian
	 * 2017年11月6日 上午10:19:15
	 */
	//@LoadBalanced   不能使用
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

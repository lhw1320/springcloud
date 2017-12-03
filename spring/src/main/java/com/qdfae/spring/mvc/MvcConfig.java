package com.qdfae.spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring MVC配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午11:20:58
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.qdfae.spring.mvc")
public class MvcConfig {
	
	/**
	 * 配置InternalResourceViewResolver
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午11:24:58
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

}

package com.qdfae.spring;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 * 
 * @author hongwei.lian
 * 2017年12月4日 上午10:44:14
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * 注入VelocityEngine
	 * 
	 * @return
	 * @throws IOException 
	 * @author hongwei.lian  
	 * @date 2018年6月24日 下午6:40:50
	 */
	@Bean
	VelocityEngine velocityEngine() throws IOException {
	    Properties properties = new Properties();
		properties.load(getClass().getResourceAsStream("/velocity.properties"));
	    return new VelocityEngine(properties);
	}
	
}

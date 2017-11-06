package com.qdfae.eureka_producer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用Spring Cloud Eureka方式提供服务1
 * 注意：
 *          1、使用@EnableDiscoveryClient注解进行服务注册与发现，
 *               涉及到类是EnableDiscoveryClientImportSelector
 * 
 * @author hongwei.lian
 * 2017年11月3日 下午1:48:53
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaProducer1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProducer1Application.class, args);
	}
	
}

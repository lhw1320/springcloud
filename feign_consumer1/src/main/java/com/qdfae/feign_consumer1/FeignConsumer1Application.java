package com.qdfae.feign_consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用Spring Cloud Fegin方式消费服务1
 * 注意：
 *          1、使用@EnableDiscoveryClient注解进行服务注册和发现
 *          2、使用@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能
 *                可以指定要扫描的接口（可以是其他服务中的接口）
 *        
 * @author hongwei.lian
 * 2017年11月3日 下午1:30:55
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumer1Application.class, args);
	}
	
}

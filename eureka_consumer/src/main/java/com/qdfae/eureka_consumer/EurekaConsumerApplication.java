package com.qdfae.eureka_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* 使用Spring Cloud LoadBalancer方式消费服务
* 注意：
*          1、向容器中添加RestTemplate实例Bean（使用@Bean注解）
*                不能使用@LoadBalanced注解进行负载均衡，否则抛出异常
*                java.lang.IllegalStateException: No instances available for lianhongwei
*          2、使用@EnableDiscoveryClient注解进行服务注册和发现
*               也可以使用@EnableEurekaClient注解进行，但是这是通用的消费方式，
*               方便切换服务注册中心
*                
* @author hongwei.lian
* 2017年11月3日 下午2:25:13
*/
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {
	
	/**
	 * 第一种方式：
	 * 可以单独提取出去，使用@Configuration注解自定义配置类
	 * 然后使用@Bean注解向容器中注入RestTemplate类
	 * 
	 * @return
	 * @author hongwei.lian
	 * 2017年11月6日 上午10:15:00
	 */
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
	
}

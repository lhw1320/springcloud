package com.qdfae.feign_consumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用Spring Cloud Fegin方式消费服务2
 * 注意：
 *          1、使用@EnableEurekaClient注解进行服务注册和发现
 *          2、使用@EnableFeignClients注解开启扫描Spring Cloud Feign客户端的功能
 *          3、@EnableEurekaClient注解和@EnableDiscoveryClient注解异同点
 *                联系：
 *                        都是进行服务注册和发现
 *                区别：
 *                        @EnableEurekaClient注解的注册中心只能是Eureka注册中心
 *                        @EnableDiscoveryClient注解的注册中心可以随便切换：Eureka、Zookeeper、Consu;l
 *         
 * @author hongwei.lian
 * 2017年11月3日 下午1:41:25
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignConsumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumer2Application.class, args);
	}
	
}

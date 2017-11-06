package com.qdfae.eureka_producer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 使用Spring Cloud Eureka方式提供服务2
 * 注意：
 *          1、使用@EnableEurekaClient注解进行服务注册与发现
 *                @EnableEurekaClient注解是组合注解，包含@EnableDiscoveryClient注解
 *          2、@EnableEurekaClient注解与@EnableDiscoveryClient注解
 *          联系：Spring Cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），
 *                     这两种注解都是进行服务注册和发现的
 *          区别：@EnableDiscoveryClient基于spring-cloud-commons，可以随意切换服务注册中心
 *                     只需要引入注册中心依赖和修改配置文件即可实现注册中心的切换
 *                    @EnableEurekaClient基于spring-cloud-netflix，注册中心只能是Eureka服务注册中心（推荐）
 *          
 * @author hongwei.lian
 * 2017年11月3日 下午1:48:57
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.qdfae.*"})
public class EurekaProducer2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProducer2Application.class, args);
	}
	
}

package com.qdfae.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Spring Cloud Eureka作为微服务注册中心
 * 注意：
 *          1、使用@EnableEurekaServer注解开启Eureka服务注册中心
 *          2、@EnableEurekaServer注解是组合注解，包含@EnableDiscoveryClient注解
 *               涉及到的配置类EurekaServerMarkerConfiguration
 *          3、Spring Cloud默认集成Netflix Eureka作为服务注册中心，其他的服务注册中心
 *                还有Zookeeper，Consul，切换注册中心还是比较容易的
 *          4、@SpringBootApplication注解是组合注解，包含@ComponentScan注解、
 *               @SpringBootConfiguration注解和@EnableAutoConfiguration注解，
 *               其中@SpringBootConfiguration注解也是组合注解，包含@Configuration注解
 *               其中@ComponentScan注解是组合注解，包含@AutoConfigurationPackage注解
 *    
 * @author hongwei.lian
 * 2017年11月3日 下午2:07:57
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
	}
	
}

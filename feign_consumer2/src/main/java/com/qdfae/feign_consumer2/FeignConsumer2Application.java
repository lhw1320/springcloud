package com.qdfae.feign_consumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignConsumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumer2Application.class, args);
	}
	
}

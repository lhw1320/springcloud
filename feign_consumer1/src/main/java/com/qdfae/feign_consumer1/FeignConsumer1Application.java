package com.qdfae.feign_consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(FeignConsumer1Application.class, args);
	}
	
}

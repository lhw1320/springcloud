package com.qdfae.eureka_producer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProducer2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProducer2Application.class, args);
	}
	
}

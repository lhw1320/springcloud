package com.qdfae.hotdeploy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot应用程序启动类
 * 
 * @author hongwei.lian 
 * @date 2017年11月25日 下午8:03:34
 */
@SpringBootApplication
@ComponentScan({"com.qdfae.hotdeploy.*"})
public class ServerMain {

	public static void main(String[] args) {
		SpringApplication.run(ServerMain.class, args);
	}
	
}

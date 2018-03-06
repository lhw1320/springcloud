package com.example.swagger.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 配置Swagger2
 *
 * @author hongwei.lian
 * @date 2018年3月6日 下午8:11:52
 */
@Configuration
@ComponentScan(basePackages = { "com.qdfae.swagger.*" })
@EnableSwagger2
public class Swagger2 {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.qdfae.swagger"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.useDefaultResponseMessages(false)
				.enableUrlTemplating(true);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("资料管理Restful API 文档")
				.description("资料管理Restful API 接口文档")
				.termsOfServiceUrl("git@github.com:LiuwqGit/spring-boot-eureka.git")
				.contact(new Contact("qdfae", "url", "email"))
				.version("1.0")
				.build();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}

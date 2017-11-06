package com.qdfae.feign_consumer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qdfae.feign_consumer1.api.DcApi;

/**
 * 使用Spring Cloud Feign方式消费服务1
 * 注意：
 *         1、注入服务API接口（@EnableFeignClients注解扫描Feign接口）
 *         2、使用Spring MVC方式调用服务
 * 
 * @author hongwei.lian
 * 2017年11月3日 下午4:33:08
 */
@RestController
public class DcController {
	
    @Autowired
    private DcApi dcApi;
    
    @GetMapping("/consumer")
    public String dc() {
        return dcApi.consumer();
    }
    
}
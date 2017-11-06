package com.qdfae.eureka_producer1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供类
 * 注意：
 *          1、注入DiscoveryClient接口，使用getServices获取所有服务注册列表
 *          2、拼装URL访问地址
 * 
 * @author hongwei.lian
 * 2017年11月6日 上午9:45:37
 */
@RestController
public class DcController {
	
    @Autowired
    DiscoveryClient discoveryClient;
    
    @GetMapping("/dc")
    public String dc() {
        String services = "services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
    
}

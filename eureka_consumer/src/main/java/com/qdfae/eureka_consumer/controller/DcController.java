package com.qdfae.eureka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
* 使用Spring Cloud LoadBalancer和RestTemplate消费服务（最基础方式）
* 注意：
*          1、注入LoadBalancerClient用于获取服务信息
*          2、注入RestTemplate用于模拟发送HTTP请求
*          3、使用主机和端口访问服务："http://lianhongwei:2001/dc"，可行
*          4、使用服务ID访问（虚拟服务地址）："http://eurekaclient/dc"，不可行
*          5、注意向容器中注入RestTemplate的时候不能只能使用@Bean注解，
*                不能使用@LoadBalanced注解
* 
* @author hongwei.lian
* 2017年11月3日 下午2:29:49
*/
@RestController
public class DcController {
	
	@Autowired
    LoadBalancerClient loadBalancerClient;
	
    @Autowired
    RestTemplate restTemplate;
    
    @GetMapping("/consumer")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eurekaproducer1");
        System.out.println("=======================");
        System.out.println(serviceInstance.getHost());
        System.out.println("=======================");
        System.out.println(serviceInstance.getServiceId());
        System.out.println("=======================");
        System.out.println(serviceInstance.getPort());
        
        //第一种访问方式：服务器IP地址+端口
        //可行
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        
        //第二种方式：服务器服务ID
        //不可行
        //String url = "http://eurekaproducer1/dc";    
        //抛出如下异常：
        //java.net.UnknownHostException: eurekaproducer1
        
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
    
}

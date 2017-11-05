package com.qdfae.eureka_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
        //第一种方式：服务器IP地址+端口
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        //第二种方式：服务器服务ID，
        //String url = "http://eurekaproducer1/dc";    
        //抛出如下异常：
        //java.net.UnknownHostException: eurekaproducer1
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
    
}

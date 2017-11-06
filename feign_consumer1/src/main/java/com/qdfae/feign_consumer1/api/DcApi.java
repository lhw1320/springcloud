package com.qdfae.feign_consumer1.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用Spring Cloud Feign方式消费服务1
 * 注意：
 *          1、使用@FeignClient注解来指定这个接口所要调用的服务名称
 *          2、使用@FeignClient注可以指定path和url访问路径
 *       
 * @author hongwei.lian
 * 2017年11月3日 下午1:36:06
 */
@FeignClient("eurekaproducer1")
public interface DcApi {

	@GetMapping("/dc")
    String consumer();
	
}
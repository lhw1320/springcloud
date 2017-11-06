package com.qdfae.feign_consumer2.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 注意：
 *          使用@FeignClient注解来指定这个接口所要调用的服务名称
 *       
 * @author hongwei.lian
 * 2017年11月3日 下午1:36:06
 */
@FeignClient("eurekaproducer1")
public interface DcApi {

	@GetMapping("/dc")
    String consumer();
	
}
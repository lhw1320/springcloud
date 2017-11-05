package com.qdfae.feign_consumer2.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eurekaproducer1")
public interface DcApi {

	@GetMapping("/dc")
    String consumer();
	
}
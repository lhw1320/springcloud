package com.qdfae.feign_consumer2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qdfae.feign_consumer2.api.DcApi;

/**
 * Spring MVC方式
 * 
 * @author hongwei.lian
 * 2017年11月3日 下午5:43:09
 */
@RestController
public class DcController {
	
	/**
	 * 注入服务接口
	 */
    @Autowired
    private DcApi dcApi;
    
    @GetMapping("/consumer")
    public String dc() {
        return dcApi.consumer();
    }
    
}
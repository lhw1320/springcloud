package com.qdfae.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 疑问：
 *          尝试着将TestConroller和启动类分包存放
 *          为什么访问不到接口
 * 
 * @author hongwei.lian
 */
@RestController
public class TestController {
	
    @GetMapping("/test")
    public String dc() {
        return "test";
    }
    
}

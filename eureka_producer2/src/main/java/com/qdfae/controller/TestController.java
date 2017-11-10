package com.qdfae.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 疑问：
 *          尝试着将TestConroller和启动类分包存放
 *          为什么访问不到接口
 *          
 * 解决：默认情况下Spring Boot应用自动扫描包的位置是
 *           启动类所在的包以及子包下的所有加注解的类
 *           如果所写的类加注解和启动类所在包分包存放，需要修改默认的包扫描配置
 *           方法是在启动类上加@ComponentScan注解，指定自动扫描包的配置
 *           配置如下：@ComponentScan({"com.qdfae.*"})
 *             
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

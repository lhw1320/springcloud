package com.qdfae.hotdeploy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HotDeployController
 * @author hongwei.lian 
 * @date 2017年11月25日 下午8:06:19
 */
@RestController
@RequestMapping("/hotdeploy")
public class HotDeployController {
	
	/**
	 * say()方法
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月25日 下午9:09:22
	 */
	@GetMapping("/say")
	public String say(HttpServletRequest request) {
		request.setAttribute("say", "Hello Spring Boot!");
		System.out.println("Spring Boot");
		return "hotdeploy";
	}

}

package com.qdfae.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午11:44:16
 */
@Controller
public class HelloController {

	/**
	 * 首页
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午11:45:18
	 */
	@RequestMapping("/index")
	public String hello() {
		return "index";
	}
	
}

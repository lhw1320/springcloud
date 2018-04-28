package com.qdfae.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 全局拦截器
 *
 * @author hongwei.lian
 * @date 2018年4月26日 上午10:37:29
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//-- 可以对自定义注解进行拦截处理
		
		
		logger.info("注解处理");
		return false;
	}
	
}

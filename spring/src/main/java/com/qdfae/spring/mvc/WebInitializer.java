package com.qdfae.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Web配置
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午11:35:06
 */
public class WebInitializer implements WebApplicationInitializer {

	/**
	 * onStartup()方法
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MvcConfig.class);
		context.setServletContext(servletContext);
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
	    servlet.addMapping("/");
	    servlet.setLoadOnStartup(1);
	}

}

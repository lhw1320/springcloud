package com.qdfae.spring.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 拦截规则的注解
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:03:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
	
	/**
	 * name()方法
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午11:03:52
	 */
	String name();

}

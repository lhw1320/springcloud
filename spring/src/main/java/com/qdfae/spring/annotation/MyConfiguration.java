package com.qdfae.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 组合@Configuration和@ComponentScan两个注解
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:32:53
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface MyConfiguration {
	
	/**
	 * value()方法
	 * 
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午6:33:51
	 */
	String[] value() default {};

}

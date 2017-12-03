package com.qdfae.spring.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:14:10
 */
@Aspect
@Component
public class LogAspect {
	
	/**
	 * 切点
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午11:22:14
	 */
	@Pointcut("@annotation(com.qdfae.spring.aop.Action)")
	public void annotationPointCut() {
		
	}
	
	/**
	 * 建言
	 * 
	 * @param joinPoint 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午11:22:17
	 */
	@After("annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Action action = method.getAnnotation(Action.class);
		System.out.println("注解式拦截 " + action.name());
	}
	
	/**
	 * 建言
	 * 
	 * @param joinPoint 
	 * @author hongwei.lian  
	 * @date 2017年12月2日 下午11:22:21
	 */
	@Before("execution(* com.qdfae.spring.aop.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		System.out.println("方法规则式拦截 " + method.getName());
	}

	
}

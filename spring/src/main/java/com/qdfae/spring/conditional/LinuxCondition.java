package com.qdfae.spring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判定Linux的条件
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午6:00:23
 */
public class LinuxCondition implements Condition {

	/**
	 * matches()方法
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getEnvironment().getProperty("os.name").contains("Linux");
	}

}

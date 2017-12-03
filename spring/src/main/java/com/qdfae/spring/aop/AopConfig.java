package com.qdfae.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月2日 下午11:28:25
 */
@Configuration
@ComponentScan("com.qdfae.spring.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}

package com.qdfae.spring.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 配置类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午5:26:16
 */
@Configuration
@ComponentScan("com.qdfae.spring.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {

}

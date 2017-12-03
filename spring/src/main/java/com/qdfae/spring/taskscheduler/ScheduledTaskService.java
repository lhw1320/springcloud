package com.qdfae.spring.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 计划任务执行类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午5:30:30
 */
@Service
public class ScheduledTaskService {

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * 每个五秒执行一次
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午5:36:05
	 */
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime(){
		System.out.println("每隔五秒执行一次" + DATE_FORMAT.format(new Date()));
	}
	
	/**
	 * 每天11点40执行
	 *  
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午5:35:59
	 */
	@Scheduled(cron = "0 43 17 ? * *")
	public void fixTimeExecution() {
		System.out.println("在指定时间" + DATE_FORMAT.format(new Date()) + "执行");
	}
	
}


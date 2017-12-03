package com.qdfae.spring.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 任务执行类
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午5:12:29
 */
@Service
public class AsyncTaskServicr {
	
	/**
	 * executorAsyncTask()方法
	 * 
	 * @param i 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午5:13:26
	 */
	@Async
	public void executorAsyncTask(Integer i) {
		System.out.println("执行异步任务：" + i);
	}
	
	/**
	 * executorAsyncTaskPlus()方法
	 * 
	 * @param i 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午5:14:08
	 */
	@Async
	public void executorAsyncTaskPlus(Integer i) {
		System.out.println("执行异步任务+1：" + (i + 1));
	}

}

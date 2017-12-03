package com.qdfae.spring.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行
 * 
 * @author hongwei.lian 
 * @date 2017年12月3日 下午5:17:50
 */
public class Main {

	/**
	 * main()方法
	 * 
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年12月3日 下午5:18:02
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		AsyncTaskServicr asyncTaskServicr = context.getBean(AsyncTaskServicr.class);
		for (int i = 0; i < 10; i++) {
			asyncTaskServicr.executorAsyncTask(i);
			asyncTaskServicr.executorAsyncTaskPlus(i);
		}
		context.close();
	}
	
}

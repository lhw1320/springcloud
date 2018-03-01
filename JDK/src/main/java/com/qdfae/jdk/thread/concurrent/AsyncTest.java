package com.qdfae.jdk.thread.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AsyncTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println(test());
	}
	
	public static String test() {
		System.out.println("二级审核完成");
		
		//-- 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		//-- 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		
		//-- 创建并执行在给定延迟后启用的 ScheduledFuture。
		scheduledExecutorService.schedule(() -> {
			try {
				System.out.println("10秒后开始生成账户通知");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 10, TimeUnit.SECONDS);
		scheduledExecutorService.shutdown();
		return "返回结果";
		
		//-- 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
		//scheduledExecutorService.shutdown();
		
		//-- 回调
//		ScheduledFuture<Boolean> future = scheduledExecutorService.schedule(new MyCallable(), 1L, TimeUnit.MINUTES);
//		
//		//-- 如有必要，等待计算完成，然后获取其结果。
//		Boolean flag = future.get();
//		
//		if (flag) {
//			System.out.println("执行完毕");
//			//-- 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用。
//			scheduledExecutorService.shutdown();
//		}
	}
	
}

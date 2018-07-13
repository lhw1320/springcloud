package com.qdfae.jdk.thread.executor;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.huajin.baymax.util.DateUtils;

public class ExecutorsTest {
	
	/**
	 * 线程池缓存
	 */
	private Map<Integer, ExecutorService> executorMap = new HashMap<>();;
	
	/**
	 * 异步调用返回结果缓存
	 */
	private Map<Integer, Future<?>> futureMap = new HashMap<>();
	
	/**
	 * 单个线程池
	 *
	 * @author hongwei.lian
	 * @date 2018年7月10日 下午2:11:31
	 */
	@Test
	public void testNewSingleThreadExecutor1() {
		//-- 创建单个线程的线程池
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//-- 创建线程作业任务
		Runnable task = () -> System.out.println("作业任务线程名称：" + Thread.currentThread().getName());
		//-- 
		Future<?> workingFutrue = executorService.submit(task);
		//-- 
		boolean done = workingFutrue.isDone();
		System.out.println("作业任务执行结果：" + done);
	}
	
	/**
	 * 多个线程池
	 *
	 * @author hongwei.lian
	 * @date 2018年7月10日 下午2:11:20
	 */
	@Test
	public void testNewSingleThreadExecutor2() {
		//-- 创建单个线程的线程池
		ExecutorService executorService1 = Executors.newSingleThreadExecutor();
		ExecutorService executorService2 = Executors.newSingleThreadExecutor();
		executorMap.put(1, executorService1);
		executorMap.put(2, executorService2);
		//-- 创建线程作业任务
		Runnable task1 = () -> System.out.println("作业任务线程名称：" + Thread.currentThread().getName());
		Runnable task2 = () -> System.out.println("作业任务线程名称：" + Thread.currentThread().getName());
		//-- 
		Future<?> workingFutrue1 = executorService1.submit(task1);
		futureMap.put(1, workingFutrue1);
		Future<?> workingFutrue2 = executorService2.submit(task2);
		futureMap.put(2, workingFutrue2);
		
		//-- 
		Future<?> future1 = futureMap.get(1);
		Future<?> future2 = futureMap.get(2);
		
		System.out.println("作业任务执行结果：" + future1.isDone());
		System.out.println("作业任务执行结果：" + future2.isDone());
	}
	
	private boolean falg;
	
	@Test
	public void testDate() throws ParseException {
		Date fullSynStartDate = DateUtils.parseDate("2017-03-14", "yyyy-MM-dd");
		Date add = DateUtils.add(fullSynStartDate, Calendar.DAY_OF_YEAR, -2);
		System.out.println(add);
		Date today = DateUtils.parseDate(LocalDate.now().toString(),"yyyy-MM-dd");
		boolean before = today.before(fullSynStartDate);
		System.out.println("===" + before);
		
		
		System.out.println(falg);
	}
	
}

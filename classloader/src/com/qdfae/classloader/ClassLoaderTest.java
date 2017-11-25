package com.qdfae.classloader;

import java.util.concurrent.TimeUnit;

/**
 * 测试Java类的热加载
 * @author hongwei.lian 
 * @date 2017年11月25日 下午5:34:20
 */
public class ClassLoaderTest {
	
	/**
	 * 程序执行入口
	 * @param args 
	 * @author hongwei.lian  
	 * @date 2017年11月25日 下午5:34:41
	 */
	public static void main(String[] args) {
		//方式一：
		//创建Runnable接口的实现类MsgHandler
		//new Thread(new MsgHandler()).start();
		
		//方式二
		//匿名对象方式创建Runnable接口的实现类对象
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while (true) {
//					//使用ManagerFactory创建BaseManager接口的实现类对象
//					BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
//					manager.logic();
//					try {
//						//Thread.sleep(1000);
//		               TimeUnit.SECONDS.sleep(1);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//			
//		}).start();
		
		//方式三
		//JDK8新特性Lambda表达式创建Runnable接口的实现类对象
		new Thread(() -> {
			while (true) {
				//使用ManagerFactory创建BaseManager接口的实现类对象
				BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
				manager.logic();
				try {
					//Thread.sleep(1000);
		            TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
}

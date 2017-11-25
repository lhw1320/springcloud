package com.qdfae.classloader;

import java.util.concurrent.TimeUnit;

/**
 * 后台启动一条线程不断刷新重新加载实现了热加载的类
 * @author hongwei.lian 
 * @date 2017年11月25日 下午5:28:54
 */
public class MsgHandler implements Runnable {

	/**
	 * 线程执行方法
	 */
	@Override
	public void run() {
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
	}

}

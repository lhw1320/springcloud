package com.qdfae.jdk.thread.concurrent;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		try {
			//TODO 实际业务操作
			System.out.println("实际业务操作");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

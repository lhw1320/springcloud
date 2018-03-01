package com.qdfae.jdk.thread.concurrent;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Boolean> {

	@Override
	public Boolean call() throws Exception {
		//TODO 实际业务操作
		System.out.println("实际业务操作");
		return true;
	}

}

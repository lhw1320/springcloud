package com.qdfae.jdk.thread;

public class CountDemo {
	
    public static void main(String[] args) {
		//启动线程
    	//创建线程的实例对象
    	//运行到12行时又三个线程
    	//  ct和ct1两个线程同时进行会抢资源
    	ThreadDemo ct=new ThreadDemo("线程一");
    	//给线程设置名字
    	//ct.setName("线程一");
    
    	ThreadDemo ct1=new ThreadDemo("线程二");
    	//ct1.setName("线程二");
    	//启动线程
    	ct.start();
    	ct1.start();
	}
}

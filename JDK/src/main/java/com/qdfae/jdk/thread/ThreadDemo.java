package com.qdfae.jdk.thread;

public class ThreadDemo  extends Thread {
	
	public ThreadDemo(String name){
		super(name);
	}
    
	public ThreadDemo() {
		super();
	}
    
	@Override
	public void run() {
	    for(int i=0;i<50;i++){
	    	System.out.println(this.getName()+"hello"+i);
	    }
	}
	
}

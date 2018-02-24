package com.qdfae.jdk.thread;

public class XiaofeiFruit implements Runnable {
      private Fruit fruit;
//	public XiaofeiFruit(Fruit fruit) {
//		this.fruit = fruit;
//	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(fruit){
				if(!fruit.isIsExsit()){
					try {
						fruit.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					   try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(fruit.getName()+"水果被买走");
					fruit.setIsExsit(false);
					fruit.notify();
				}
			}
		}
	}

}

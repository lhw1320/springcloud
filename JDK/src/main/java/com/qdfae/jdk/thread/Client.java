package com.qdfae.jdk.thread;

public class Client {
   public static void main(String[] args) {
	Fruit fr=new Fruit();
	fr.setName("苹果");
	fr.setIsExsit(false);
	ProductFruit fd=new ProductFruit();
	fd.setFruit(fr);
	XiaofeiFruit xf=new XiaofeiFruit();
	xf.setFruit(fr);
	Thread tr1=new  Thread(fd);
	Thread tr2=new Thread(xf);
	tr1.start();
	tr2.start();
}
} 

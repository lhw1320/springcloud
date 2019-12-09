package com.qdfae.jdk;

public class Test11 extends Base11 {
	
	public static void main(String[] args) {
		new Test11().method1();
		new Test11().method();
	}
	
	public void method() {
		System.out.println(this.getClass().getName());
		System.out.println(super.getClass().getName());
	}

}

class Base11 {
	
	public void method1() {
		System.out.println("==1==" + this.getClass().getName());
		System.out.println("==2==" + super.getClass().getName());
	}
	
}

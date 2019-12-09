package com.qdfae.jdk;

/**
 * 参考：http://www.bjpowernode.com/tutorial_java_se/129.html
 *
 * @author hongwei.lian
 * @date 2019年12月9日 下午1:30:37
 */
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

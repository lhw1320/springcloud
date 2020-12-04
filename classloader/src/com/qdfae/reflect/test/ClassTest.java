package com.qdfae.reflect.test;

import java.lang.reflect.Constructor;

import com.qdfae.reflect.entity.User;

public class ClassTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
//		Class<?> claszz1 = new User().getClass();
//		Class<?> claszz2 = User.class;
		Class<?> claszz3 = Class.forName("com.qdfae.reflect.entity.User");
		
		//-- 类的全路径：com.qdfae.reflect.entity.User
		//System.out.println(claszz3.getName());
		//-- 类的简称：User
		//System.out.println(claszz3.getSimpleName());
		
		//-- 所有public类型构造方法
		//System.out.println(claszz3.getConstructors().length);
		
		//System.out.println(claszz3.getConstructor());
		
		//-- 所有构造方法
		//System.out.println(claszz3.getDeclaredConstructors().length);
		
		//claszz3.getDeclaredMethods()
		
	
		System.out.println(claszz3.getSuperclass());
		
	}

}

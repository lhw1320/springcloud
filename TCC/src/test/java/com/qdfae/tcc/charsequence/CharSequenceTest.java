package com.qdfae.tcc.charsequence;

import org.junit.Test;

/**
 * CharSequence接口与String、StringBuilder和StringBuffer关系
 * 
 * CharSequence是一个字符序列接口
 * String实现了CharSequence
 * AbstractStringBuilder实现了这个接口，但是这是一个抽象类
 * StringBuilder和StringBuffer都继承了AbstractStringBuilder抽象类
 * StringBuilder和StringBuffer都实现了CharSequence这个接口
 *  
 *  String、StringBuilder和StringBuffer都被final修饰
 *  String为什么是不可变字符串
 *  String类定义了：private final char value[]
 *  不会修改字符数组长度，也不会进行字符数据复制
 *  
 *  StringBuilder和StringBuffer为什么是可变字符串
 *  StringBuilder和StringBuffer都继承了AbstractStringBuilder抽象类
 *  AbstractStringBuilder抽象类中定义了：char[] value
 *  如果字符串长度变化可以进行字符数组复制，再进行新的字符添加和覆盖原来的字符数组
 *  
 *  画出UML类图（五个类）
 * 
 * @author hongwei.lian
 * 2017年12月1日 上午10:59:55
 */
public class CharSequenceTest {
	
	@Test
	public void testString() {
		CharSequence cs  = new String();
		
	} 
	
	@Test
	public void testStringBuffer() {
		CharSequence cs  = new StringBuffer();
		
	} 
	
	@Test
	public void testStringBuilder() {
		CharSequence cs  = new StringBuilder();
		
	} 
	
	
}

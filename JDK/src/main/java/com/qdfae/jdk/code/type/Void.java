package com.qdfae.jdk.code.type;

/**
 * java.lang.Void源码解读
 * 
 * Void类是一个不可实例化占位符类
 * 持有表示Java关键字void类对象的引用
 * 
 */
public final class Void {
	
	/**
	 * 表示对应于关键字void的伪类型的Class对象
	 */
	@SuppressWarnings("unchecked")
    //public static final Class<Void> TYPE = (Class<Void>) Class.getPrimitiveClass("void");
	
    /**
     * Void类不能被实例化
     */
	private Void() {}

}

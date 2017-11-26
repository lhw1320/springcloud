package com.qdfae.jdk.interfaces;

/**
 * 函数式接口信息
 * @author hongwei.lian 
 * @date 2017年11月26日 下午9:08:59
 */
@FunctionalInterface
public interface OneFunctionalInterface {
	
	/**
	 *  抽象方法
	 * @author hongwei.lian  
	 * @date 2017年11月26日 下午9:02:01
	 */
	void action();
	
	/**
	 * 默认方法
	 * @param name
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月26日 下午9:03:06
	 */
	default String getName(String name) {
		System.out.println("interface default method");
		return name;
	}
	
	/**
     *  静态方法
     * @author hongwei.lian  
     * @date 2017年11月26日 下午8:53:42
     */
    static void print() {
    	System.out.println("interface static method");
    }
    
    /**
     * Object类共有方法可以存在函数式接口中，相当于重写Object类的方法
     * @return 
     * @author hongwei.lian  
     * @date 2017年11月26日 下午9:00:19
     */
    int hashCode();
    boolean equals(Object obj);
    String toString();
    
    
    /**
     * Object类的受保护方法不可以存在函数式接口中
     * @author hongwei.lian  
     * @date 2017年11月26日 下午8:59:36
     */
    //void finalize();
    //Object clone();
	
}

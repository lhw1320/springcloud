package com.qdfae.jdk.functioninterface;

/**
 * 创建Person对象工厂函数式接口
 * @author hongwei.lian 
 * @date 2017年11月16日 上午12:10:38
 */
@FunctionalInterface
public interface PersonFactory<T extends Person> {
	
	/**
	 * 创建Person对象方法
	 * @param firstName
	 * @param lastName
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月16日 上午12:10:18
	 */
    T create(String firstName, String lastName);
    
}

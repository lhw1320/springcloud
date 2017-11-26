package com.qdfae.jdk.interfaces;

/**
 * Formula接口
 * @author hongwei.lian 
 * @date 2017年11月15日 下午10:13:32
 */
@FunctionalInterface
public interface Formula {
	
	/**
	 * 计算方法
	 * @param number
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午10:11:32
	 */
	double calculate(int number);
	
    /**
     * 平方根
     * @param number
     * @return 
     * @author hongwei.lian  
     * @date 2017年11月15日 下午10:11:56
     */
	default double sqrt(int number) {
        return Math.sqrt(number);
    }
    
}

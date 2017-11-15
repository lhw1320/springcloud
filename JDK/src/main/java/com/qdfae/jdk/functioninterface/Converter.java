package com.qdfae.jdk.functioninterface;

/**
 * 函数式接口
 * 通过JDK8源码javadoc，可以知道这个注解有以下特点：
 * 1、该注解只能标记在"有且仅有一个抽象方法"的接口上。
 * 2、JDK8接口中的静态方法和默认方法，都不算是抽象方法。
 * 3、接口默认继承java.lang.Object，所以如果接口显示声明覆盖了Object中方法，那么也不算抽象方法。
 * 4、该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响
 *       加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，但是加上了@FunctionInterface，
 *       那么编译器会报错。
 * 
 * 注意：
 * 1、@FunctionalInterface标记在接口上，函数式接口是指仅仅只包含一个抽象方法的接口
 * 2、如果一个接口中包含不止一个抽象方法，那么不能使用@FunctionalInterface，编译会报错
 * 
 * @author hongwei.lian 
 * @date 2017年11月15日 下午11:36:01
 */
@FunctionalInterface
interface Converter<F, T> {
	
	/**
	 * 转换方法
	 * @param from
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月15日 下午11:35:32
	 */
    T convert(F from);
    
}

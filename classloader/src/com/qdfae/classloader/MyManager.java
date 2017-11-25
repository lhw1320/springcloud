package com.qdfae.classloader;

/**
 * BaseManager的实现类，此类需要实现Java类的热加载功能
 * @author hongwei.lian 
 * @date 2017年11月25日 下午4:49:02
 */
public class MyManager implements BaseManager {

	/**
	 * 热加载
	 * @author hongwei.lian  
	 * @date 2017年11月25日 下午4:48:24
	 */
	@Override
	public void logic() {
		System.out.println("Java类热加载实现完成！！！");
	    //动态添加代码或者修改代码，热加载
		System.out.println("自己实现Java热加载");
	}

}

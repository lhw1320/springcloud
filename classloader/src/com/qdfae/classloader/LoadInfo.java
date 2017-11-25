package com.qdfae.classloader;

/**
 * 封装加载类的信息
 * @author hongwei.lian 
 * @date 2017年11月25日 下午4:51:11
 */
public class LoadInfo {
	
	/**
	 * 自定义的类加载器
	 */
	private MyClassLoader myLoader;
	
	/**
	 * 记录要加载的类的时间戳：类的加载时间
	 */
	private long loadTime;
	
	/**
	 * 热加载接口
	 */
	private BaseManager manager;

	/**
	 * 构造方法
	 * @param myLoader
	 * @param loadTime
	 */
	public LoadInfo(MyClassLoader myLoader, long loadTime) {
		this.myLoader = myLoader;
		this.loadTime = loadTime;
	}

	public MyClassLoader getMyLoader() {
		return myLoader;
	}

	public void setMyLoader(MyClassLoader myLoader) {
		this.myLoader = myLoader;
	}

	public long getLoadTime() {
		return loadTime;
	}

	public void setLoadTime(long loadTime) {
		this.loadTime = loadTime;
	}

	public BaseManager getManager() {
		return manager;
	}

	public void setManager(BaseManager manager) {
		this.manager = manager;
	}
	
}

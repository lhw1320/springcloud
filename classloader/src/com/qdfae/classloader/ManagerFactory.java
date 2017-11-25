package com.qdfae.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 加载manager接口实现类的工厂
 * @author hongwei.lian 
 * @date 2017年11月25日 下午5:04:48
 */
public class ManagerFactory {

	/**
	 * 记录热加载类的加载信息
	 */
	private static final Map<String, LoadInfo> LOADTIMEMAP = new HashMap<>();
	
	/**
	 * 要加载的类的classpath
	 */
	public static final String CLASS_PATH = "E:/workspace/springcloud/classloader/bin/";
	
	/**
	 * 实现热加载的类的全限定类名（包名+类名）
	 */
	public static final String MY_MANAGER = "com.qdfae.classloader.MyManager";
	
	public static BaseManager getManager(String className) {
		File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
		long lastModified = loadFile.lastModified();
		if (Objects.isNull(LOADTIMEMAP.get(className))) {
			//LOADTIMEMAP缓存中不包含className为key的LoadInfo信息，
			//证明这个类没有被加载，那么需要加载这个类到Java虚拟机中
			load(className, lastModified);
		} else if (LOADTIMEMAP.get(className).getLoadTime() != lastModified) {
			//加载类的时间戳变化了，我们同样要重新加载这个类到Java虚拟机中
			load(className, lastModified);
		}
		return LOADTIMEMAP.get(className).getManager();
	}

	/**
	 * 加载类并缓存到LOADTIMEMAP中
	 * @param className
	 * @param lastModified 
	 * @author hongwei.lian  
	 * @date 2017年11月25日 下午5:16:46
	 */
	private static void load(String className, long lastModified) {
		MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
		Class<?> loadClass = null;
		try {
			//加载类
			loadClass = myClassLoader.findClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//创建BaseManager接口的实现类对象
		BaseManager manager = newInstance(loadClass);
		LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
		loadInfo.setManager(manager);
		LOADTIMEMAP.put(className, loadInfo);
	}

	/**
	 * 以反射的方式创建BaseManager接口的实现类对象
	 * @param loadClass
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月25日 下午5:23:09
	 */
	private static BaseManager newInstance(Class<?> loadClass) {
		try {
			//使用构造方法创建
			return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

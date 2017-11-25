package com.qdfae.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 自定义java类加载器来实现Java类的热加载
 * @author hongwei.lian 
 * @date 2017年11月25日 下午4:32:13
 */
public class MyClassLoader extends ClassLoader {

	/**
	 * 要加载的Java类的classpath路径
	 */
	private String classpath;

	/**
	 * 构造方法，调用系统类加载器
	 * @param classpath
	 */
	public MyClassLoader(String classpath) {
		super(ClassLoader.getSystemClassLoader());
		this.classpath = classpath;
	}

	/**
	 * 重写ClassLoader的findClass()方法
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = this.loadClassData(name);
		return this.defineClass(name, data, 0, data.length);
	}
	
	/**
	 * 加载class文件中的内容
	 * @param name
	 * @return 
	 * @author hongwei.lian  
	 * @date 2017年11月25日 下午4:37:12
	 */
	private byte[] loadClassData(String name) {
		try {
			name = name.replace(".", "//");
			//字节输入流
			FileInputStream is  = new FileInputStream(new File(classpath + name + ".class"));
		    //字节输出流
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    int b = 0;
		    while ((b = is.read()) != -1) {
		    	baos.write(b);
		    }
		    is.close();
		    return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

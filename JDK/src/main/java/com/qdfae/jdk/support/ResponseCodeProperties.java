package com.qdfae.jdk.support;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class ResponseCodeProperties {
	
	private static Properties props;
	
	static {
		loadProperties();
	}
	
	/**
	 * 加载
	 * 
	 * @author hongwei.lian
	 * 2018年2月7日 下午7:58:12
	 */
	public static synchronized void loadProperties(){
		Resource resource = new ClassPathResource("/responsecode.properties");
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据Key读取value
	 * 
	 * @param key
	 * @return
	 * @author hongwei.lian
	 * 2018年2月7日 下午7:58:26
	 */
	public static String getProperty(int key){
		return props.getProperty(String.valueOf(key));
	}
	
	/**
	 * 根据key读value，如果没有匹配，则返回默认值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 * @author hongwei.lian
	 * 2018年2月7日 下午7:58:51
	 */
	public static String getProperty(int key ,String defaultValue){
		return props.getProperty(String.valueOf(key), defaultValue);
	}

}

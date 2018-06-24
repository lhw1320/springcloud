package com.qdfae.jdk.map;

import static org.assertj.core.api.Assertions.in;

import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Properties;
import java.util.UUID;

import org.junit.Test;

/**
 * Properties
 *
 * @author hongwei.lian
 * @date 2018年6月11日 下午1:24:15
 */
public class PropertiesTest {

	/**
	 * 
	 * public abstract class Dictionary<K,V>抽象类
	 * abstract public V put(K key, V value);
	 * 
	 * Hashtable<K,V>类
	 * public class Hashtable<K,V>
	 * public synchronized V put(K key, V value)
	 * 
	 * Properties类
	 * public synchronized Object setProperty(String key, String value) {
	 *     return put(key, value);
	 * }
	 * 这个方法直接调用其父类Hashtable的put方法
	 *
	 * @author hongwei.lian
	 * @date 2018年6月11日 下午1:30:45
	 */
	@Test
	public void test1() {
		Properties properties = new Properties();
		//-- key和value均不能为null，这是由Properties继承Hashtable<Object,Object>类的
		//-- public synchronized V put(K key, V value)方法的决定的。看源码即可
		//properties.put(null, 1);
		//properties.put(1, null);
		//properties.put(null, null);
		
		//-- 这是由Properties继承Hashtable<Object,Object>类的
		//-- public synchronized V get(Object key)方法的决定的。看源码即可
		//System.out.println(properties.get(null));
		
		//-- 这是由Properties继承Hashtable<Object,Object>类的
		//-- public synchronized V remove(Object key)方法的决定的。看源码即可
		System.out.println(properties.remove(null));
		
		//-- 由源码看出key不能为null，是因为需要调用key的hashcode()方法，如果为null，则抛出空指针异常
		//-- value不能为null是在HashTable类中判断为null时，抛出空指针异常
		
		//-- 上述三个方法的最终决定权在Dictionary<K,V>抽象类的三个方法
		//-- abstract public V put(K key, V value);
		//-- abstract public V get(Object key);
		//-- abstract public V remove(Object key);
		
		
		//properties.put("key1", "value1");
		properties.setProperty("key1", "value2");
		//System.out.println(properties.get(1));
	}
	
	/**
	 * 
	 *
	 * @author hongwei.lian
	 * @date 2018年6月11日 下午2:22:34
	 */
	@Test
	public void test2() {
		Properties properties = new Properties();
	    //-- public final class Class<T>
		//-- public InputStream getResourceAsStream(String name)
		//InputStream in = getClass().getResourceAsStream("/config.properties");
		
		//-- public abstract class ClassLoader
		//-- public InputStream getResourceAsStream(String name)
		InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");
		
		//-- public abstract class ClassLoader
		//-- public static InputStream getSystemResourceAsStream(String name)
		//InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
		
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(properties);
	}
	
	
	//private transient Entry<?,?>[] table;
	//Entry<?,?> tab[] = table;
	@Test
	public void test3() {
		//-- 十进制转换为十六进制
	    //System.out.println(Integer.toHexString(100));//64
	    
	    //-- 十六进制转换为十进制
	    //System.out.println(Integer.parseInt("7FFFFFFF", 16));//2147483647
	    //System.out.println(Integer.parseInt("0x7FFFFFFF".substring(2), 16));//2147483647
	    
	    
	    
	    String sessionId = UUID.randomUUID().toString().toUpperCase();
	    System.out.println(sessionId);
	    System.out.println(sessionId.length());//36位
	    
	   //sessionId = authorizedKey + "=" + sessionId
	    //-- 16位   +   1位   + 36位
	    //http://yz.ptoms.qdfae.com/bizmoney/asset/investorlist.do
	}
	
}
